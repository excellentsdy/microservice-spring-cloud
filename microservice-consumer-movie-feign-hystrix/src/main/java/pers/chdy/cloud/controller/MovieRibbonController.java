package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.chdy.cloud.entity.User;
import pers.chdy.cloud.feign.UserFeignClient;

/**
 * CreteTime:2017/9/7 15:49.
 *
 * @author chdy
 */
@RestController
public class MovieRibbonController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping(path = "movie/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }
}
