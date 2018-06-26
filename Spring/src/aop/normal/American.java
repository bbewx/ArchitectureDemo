package aop.normal;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * "@Primary"注解表示装载IHuman对象的bean时，优先装载American对象的bean。参见
 * {@link EnableAspectJAutoProxyTest}
 */
@Component // 用来支持Spring自动扫描
@Primary
public class American implements IHuman {
    @Override
    public void chifan() {
        System.out.println("美国人吃饭");
    }

    @Override
    public void shuijiao() {
        System.out.println("美国人睡觉");
    }
}
