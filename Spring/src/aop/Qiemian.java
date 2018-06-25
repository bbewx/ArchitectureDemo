package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 切面类。<p/>
 *
 * "@Aspect"表示该类是切面类。<br/>
 *
 * "@Component"用来支持Spring自动扫描。
 */
@Aspect
@Component
public class Qiemian {

    @Before("execution(* aop.*.chifan())")
    public void chifanqian(){
        System.out.println("饭前洗手");
    }

    @After("execution(* aop.*.chifan())")
    public void chifanhou(){
        System.out.println("饭后漱口");
    }

    @Before("execution(* aop.*.shuijiao())")
    public void shuijiaoqian(){
        System.out.println("睡前洗澡");
    }
}
