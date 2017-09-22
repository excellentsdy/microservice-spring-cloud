package pers.chdy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CreteTime:2017/7/18 9:44
 *
 * @author chdy
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderUserApplication {
    public static void main(String[] args){
        SpringApplication.run(ProviderUserApplication.class, args);
    }

}




