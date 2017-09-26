package pers.chdy.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * CreteTime:2017/9/7 15:44.
 *
 * @author chdy
 */
@SpringBootApplication
@EnableTurbine
public class TurbineApplication {
    public static void main(String[] args){
        SpringApplication.run(TurbineApplication.class, args);
    }
}
