package pers.chdy.cloud.feign;

import org.springframework.stereotype.Component;

@Component
public class UserClient2HystrixFallback implements UserFeignClient2{
    @Override
    public String findServiceInfoFromEurekaByServiceName(String serviceName) {
        return "fallback!!";
    }
}
