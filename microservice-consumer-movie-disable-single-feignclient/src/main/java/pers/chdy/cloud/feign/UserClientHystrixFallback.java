package pers.chdy.cloud.feign;

import org.springframework.stereotype.Component;
import pers.chdy.cloud.entity.User;

@Component
public class UserClientHystrixFallback implements UserFeignClient{
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        return user;
    }
}
