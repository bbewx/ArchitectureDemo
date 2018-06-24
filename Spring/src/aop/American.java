package aop;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018\6\22 0022.
 */
@Component // 用来支持Spring自动扫描
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
