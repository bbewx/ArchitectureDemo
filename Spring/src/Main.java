import aop.normal.Chinese;
import aop.normal.IHuman;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2018\6\22 0022.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context
                = new ClassPathXmlApplicationContext("spring-config.xml");
        //要用接口接收
        Chinese c= (Chinese) context.getBean("chinese");
        c.chifan();
        c.shuijiao();
        c.goToWork();
        System.out.println("*********************************");
        //要用接口接收
        IHuman a= (IHuman) context.getBean("american");
        a.chifan();
        a.shuijiao();

    }
}
