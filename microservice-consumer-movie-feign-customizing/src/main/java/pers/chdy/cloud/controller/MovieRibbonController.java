package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignClient2 userFeignClient2;
    @GetMapping(path = "movie/{id}")
    public User findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }
    @GetMapping(path = "movie/postUser")
    public User postUser(User user){
        return this.userFeignClient.postUser(user);
    }
    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
        return this.userFeignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
    @RequestMapping(path = "test")
    public String  test(){
        ServiceInstance serviceInstance  = loadBalancerClient.choose("microservice-provider-user");
        System.out.println("serviceInstanceinfo "+serviceInstance.getServiceId() +":"+ serviceInstance.getHost()+":"+serviceInstance.getPort() );
        ServiceInstance serviceInstance2  = loadBalancerClient.choose("microservice-provider-user2");
        System.out.println("serviceInstanceinfo2 "+serviceInstance2.getServiceId() +":"+ serviceInstance2.getHost()+":"+serviceInstance2.getPort() );
        return "ok";
    }
}
