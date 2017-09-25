package pers.chdy.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(path = "movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id,User.class);
    }
    public User findByIdFallback(Long id){
        User user = new User();
        user.setId(0L);
        return user;
    }
}
