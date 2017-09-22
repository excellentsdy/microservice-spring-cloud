package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pers.chdy.cloud.entity.User;

/**
 * CreteTime:2017/9/7 15:49.
 *
 * @author chdy
 */
@RestController
public class MovieRibbonController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(path = "movie/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
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
