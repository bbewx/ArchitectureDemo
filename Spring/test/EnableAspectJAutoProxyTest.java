import aop.American;
import aop.Chinese;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/6/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EnableAspectJAutoProxyTest {

    @Autowired
    private Chinese c;

    @Autowired
    private American a;

    @Test
    public void aopTest() {
        c.chifan();
        c.shuijiao();
        c.goToWork();
        System.out.println("*********************************");
        a.chifan();
        a.shuijiao();
    }
}
