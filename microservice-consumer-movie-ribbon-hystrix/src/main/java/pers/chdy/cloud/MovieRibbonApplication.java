package pers.chdy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * CreteTime:2017/9/7 15:44.
 *
 * @author chdy
 */
@SpringBootApplication
@Configuration
@EnableEurekaClient
@EnableCircuitBreaker
public class MovieRibbonApplication {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    public static void main(String[] args){
        SpringApplication.run(MovieRibbonApplication.class, args);
    }
}
