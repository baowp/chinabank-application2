package cn.com.chinabank.app2.hessian;

import cn.com.chinabank.app2.hessian.service.HessianService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Owner on 2015/2/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "hessian-client.xml")
public class HessianServiceClient {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private HessianService hessianService;

    @Test
    public void test() {
        String str = hessianService.hello();
        logger.info(str);
    }
}
