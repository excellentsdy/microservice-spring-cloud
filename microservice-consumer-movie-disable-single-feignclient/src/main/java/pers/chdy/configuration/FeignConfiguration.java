package pers.chdy.configuration;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CreteTime:2017/9/21 16:54.
 *
 * @author chdy
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public Contract contract(){
        return new feign.Contract.Default();
    }
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
