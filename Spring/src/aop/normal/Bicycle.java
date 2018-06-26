package aop.normal;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018\6\22 0022.
 */
@Component
public class Bicycle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
