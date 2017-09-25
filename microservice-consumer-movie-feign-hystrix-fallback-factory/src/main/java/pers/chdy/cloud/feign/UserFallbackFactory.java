package pers.chdy.cloud.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import pers.chdy.cloud.entity.User;
@Component
public class UserFallbackFactory implements FallbackFactory<UserFeignClient>{
    @Override
    public UserFeignClient create(Throwable throwable) {
       return new UserFallbackClient() {
           @Override
           public User findById(Long id) {
               User user = new User();
               user.setId(0L);
               return user;
           }
       };
    }
}