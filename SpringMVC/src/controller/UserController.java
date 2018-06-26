/*
 * 创建 WJL 2017-03-12 17:23
 */
package controller;

import exception.UserException;
import model.User;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过练习，掌握采用SpringMVC实现增删改查。
 * <p>
 */
@Controller
@RequestMapping("/user")
public class UserController {
    Map<String, User> users = new HashMap<String, User>();

    public UserController() {
        users.put("wjl", new User("wjl", "123"));
        users.put("lyl", new User("lyl", "321"));
    }

    /**
     * 实现“查”
     * @param model
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", users);
        return "user/list";
    }

    /*

     */

    /**
     * 引入method方法，用来区分不同请求方式下的同名方法。例如：
     * 当前台以GET方式访问时，执行本方法；以POST方式访问时，执行下一个方法。
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        //开启modelDriver
        model.addAttribute(new User());
        return "user/add";
    }

    /**
     * 实现“增”

     1.返回值中包含redirect字段，表示需要重定向（即跳转）。
     参考{@link org.springframework.web.servlet.view.UrlBasedViewResolver}
     需要注意的是：重定向的路径一定要写全。
     2.关于验证。采用@Validated对描述对象进行验证，字段级的约束在对象类中，通过
     {@link org.springframework.validation.BindingResult}返回验证结果。
     3.关于上传文件，首先载入commons-fileupload-1.2.2和commons-io-2.0.1两个jar包，在
     形参中传入MultipartFile对象。
     * @param user
     * @param br
     * @param files
     * @param req
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated User user, BindingResult br,
                      @RequestParam MultipartFile[] files, HttpServletRequest req)
            throws IOException {
        if (br.hasErrors()) {
            return "user/add";
        }
        users.put(user.getName(), user);
        String realPath
                = req.getSession().getServletContext()
                .getRealPath("/resources/upload");
        System.out.println(realPath);
        for (MultipartFile file : files) {
            if (file.isEmpty()) continue;
            File f = new File(realPath + "/" + file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), f);
        }
        return "redirect:/user/users";
    }

    /**
     * 通过传参实现详细信息查询。
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String show(@PathVariable String name, Model model) {
        model.addAttribute(users.get(name));
        return "user/show";
    }

    /*
    获取json。
    http://localhost:8080/test/user/wjl?json
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String name) {
        return users.get(name);
    }

    /*
    获取修改界面。
     */
    @RequestMapping(value = "/{name}/update", method = RequestMethod.GET)
    public String update(@PathVariable String name, Model model) {
        model.addAttribute(users.get(name));
        return "user/update";
    }

    /*
    实现“改”
     */
    @RequestMapping(value = "/{name}/update", method = RequestMethod.POST)
    public String update(@PathVariable String name,
                         @Validated User user, BindingResult br) {
        if (br.hasErrors()) {
            return "user/update";
        }

        users.put(name, user);
        return "redirect:/user/users";
    }

    /*
    实现“删”。
     */
    @RequestMapping(value = "/{name}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable String name) {
        users.remove(name);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name, String password, HttpSession session) {
        if (!users.containsKey(name)) {
            throw new UserException("用户名不存在");
        }

        User u = users.get(name);
        if (!u.getPassword().equals(password)) {
            throw new UserException("密码错误");
        }

        // 为list.jsp中的loginUser提供全局变量
        session.setAttribute("loginUser", u);

        return "redirect:/user/users";
    }

    /**
     * 局部异常处理，仅仅只能处理这个控制器中的异常。
     * 自动拦截控制器中的{@link exception.UserException}异常，并将异常信息显示在error.jsp中。
     */
//    @ExceptionHandler(value = {UserException.class})
//    public String handleException(UserException e, HttpServletRequest req) {
//        req.setAttribute("e", e);
//        return "error";
//    }
}