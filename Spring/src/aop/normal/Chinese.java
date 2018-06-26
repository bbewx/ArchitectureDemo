package aop.normal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018\6\22 0022.
 */
@Component // 用来支持Spring自动扫描
public class Chinese implements IHuman {

    @Autowired
    private Bicycle bicycle;

    @Override
    public void chifan() {
        System.out.println("中国人吃饭");
    }

    @Override
    public void shuijiao() {
        System.out.println("中国人睡觉");
    }

    public void goToWork() {
        assert(null != bicycle);
        System.out.println("我骑" + bicycle.getName() + "去上班");
    }
}
