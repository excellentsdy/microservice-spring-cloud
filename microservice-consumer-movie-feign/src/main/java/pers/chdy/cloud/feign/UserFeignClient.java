
package pers.chdy.cloud.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pers.chdy.cloud.entity.User;

/**
 * CreteTime:2017/9/21 11:56.
 *
 * @author chdy
 */
@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {
    @RequestMapping(path = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user);
    // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。
    @RequestMapping(path = "/get-user",method = RequestMethod.GET)
    public User getUser(User user);
}
