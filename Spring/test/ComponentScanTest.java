import aop.normal.Chinese;
import config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * 测试"@ComponentScan"注解是否发挥了作用。
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ComponentScanTest {

    @Autowired
    private Chinese chinese;

    @Test
    public void chineseNotBeNull() {
        assertNotNull(chinese);
    }
}
