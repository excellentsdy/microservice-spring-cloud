package pers.chdy.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class MovieController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServicePath}")
    private String userServicePath;
    @RequestMapping(path = "movie/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject(userServicePath+id,User.class);
    }
}
