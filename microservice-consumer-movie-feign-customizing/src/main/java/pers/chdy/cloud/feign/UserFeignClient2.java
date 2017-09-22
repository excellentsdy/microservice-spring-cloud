
package pers.chdy.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.chdy.configuration.FeignConfiguration2;

/**
 * CreteTime:2017/9/21 11:56.
 *
 * @author chdy
 */
@FeignClient(name = "xxxxx",url="http://localhost:8761/",configuration = FeignConfiguration2.class)
public interface UserFeignClient2 {
    @RequestMapping(value = "/eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
