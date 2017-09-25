
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
@FeignClient(name = "microservice-provider-user",fallback = UserHystrixFallback.class)
public interface UserFeignClient {
    @RequestMapping(path = "/simple/{id}",method = RequestMethod.GET )
    public User findById(@PathVariable("id") Long id);
}
