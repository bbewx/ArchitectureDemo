import aop.around.Performance;
import aop.normal.American;
import aop.normal.Chinese;
import aop.normal.IHuman;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * 测试切面的注解是否发挥了作用。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class EnableAspectJAutoProxyTest {

    @Autowired
    private Chinese c;

    /**
     * IHuman是一个接口，在这里之所以可以用@Autowired注解，是因为在{@link American}
     * 类中显性标记为@Primary。否则，这里的@Autowired不知道优先装载哪个bean。<br/>
     * "@Qualifier"注解表示限定使用id为chinese的bean。@Qualifier的优先级要高于@Primary。
     */
    @Autowired
    //@Qualifier("chinese")
    private IHuman a;

    @Autowired
    private Performance p;

    @Test
    public void aopNormalTest() {
        c.chifan();
        c.shuijiao();
        c.goToWork();
        System.out.println("*********************************");
        a.chifan();
        a.shuijiao();
    }

    @Test
    public void aopAroundTest() {
        assertNotNull(p);
        p.perform();
    }
}
