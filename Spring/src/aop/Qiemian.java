package aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018\6\22 0022.
 */
@Aspect // 表示该类是切面类
@Component // 用来支持Spring自动扫描
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
