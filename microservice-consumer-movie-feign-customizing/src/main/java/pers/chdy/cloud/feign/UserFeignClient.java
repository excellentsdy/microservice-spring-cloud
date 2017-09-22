
package pers.chdy.cloud.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import pers.chdy.cloud.entity.User;
import pers.chdy.configuration.FeignConfiguration;

/**
 * CreteTime:2017/9/21 11:56.
 *
 * @author chdy
 */
@FeignClient(name = "microservice-provider-user",configuration = FeignConfiguration.class)
public interface UserFeignClient {

    @RequestLine("GET /simple/{id}")
    public User findById(@Param("id") Long id);

    @RequestLine("POST /user")
    public User postUser(User user);

}
