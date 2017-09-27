package pers.chdy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * CreteTime:2017/7/18 9:44
 *
 * @author chdy
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args){
        SpringApplication.run(ZuulApplication.class, args);
    }

}




