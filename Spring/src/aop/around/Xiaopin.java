package aop.around;

import org.springframework.stereotype.Component;

/**
 * 小品类，实现了表演接口。
 */
@Component
public class Xiaopin implements Performance {
    @Override
    public void perform() {
        System.out.println("小品正式开演");
    }
}
