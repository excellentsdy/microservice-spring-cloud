package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.chdy.cloud.entity.User;
import pers.chdy.cloud.feign.UserFeignClient;
import pers.chdy.cloud.feign.UserFeignClient2;

/**
 * CreteTime:2017/9/7 15:49.
 *
 * @author chdy
 */
@RestController
public class MovieRibbonController {

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserFeignClient userFeignClient;

    @Autowired
    @SuppressWarnings("SpringJavaAutowiringInspection")
    private UserFeignClient2 userFeignClient2;
    @GetMapping(path = "/movie/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/serviceinfo/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }

}
