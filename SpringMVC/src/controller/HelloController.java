/*
 * 创建 WJL 2017-03-12 9:57
 */
package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 通过注解形式实现View层和Controller层的关联。
 * 在Controller类中，必须采用@Controller注解显示声明，这样才能通过配置文件中
 * component-scan的扫描。
 * <p>
 */
@Controller
public class HelloController {

    /**
    1.@RequestMapping相当于配置文件中bean的name，给出了一个访问的url。
    2.形参传值可采用@RequestParam注解，需要注意的是，采用该注解时外部必须传入值，
    否则会报400错误。如果形参不是必须的，不用@RequestParam注解也可传值。
     */
    //@RequestMapping({"/hello", "/"})
    public String hello(String username) {
        System.out.println("hello");
        System.out.println(username);
        return "hello";
    }

    /**
    形参中的Map可以实现值的回传，这个是很有用的，也是经常用到的。
     但是，Spring不建议采用Map进行值的回传，而是采用Model（见下一个方法）。
     */
    //@RequestMapping({"/hello", "/"})
    public String hello(String username, Map<String, Object> context) {
        System.out.println("hello");
        System.out.println(username);
        context.put("username", username);
        return "hello";
    }

    @RequestMapping({"/hello", "/"})
    public String hello(String username, Model model) {
        System.out.println("hello");
        System.out.println(username);
        model.addAttribute("username", username);
        //如果addAttribute方法中仅有一个参数，等同于
        //model.addAttribute("string", username)
        model.addAttribute(username);
        return "hello";
    }
}
