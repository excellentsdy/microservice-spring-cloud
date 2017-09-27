package pers.chdy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * CreteTime:2017/7/18 9:44
 *
 * @author chdy
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper(){
        //正则表达式路由
        //下面的规则匹配这样的serviceid：microservice-provider-user-v1
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }

    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class, args);
    }

}




