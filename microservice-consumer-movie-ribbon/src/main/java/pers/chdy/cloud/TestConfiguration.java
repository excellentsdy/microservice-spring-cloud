package pers.chdy.cloud;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * CreteTime:2017/9/11 11:39.
 *
 * @author chdy
 */
@ExcludeFromCompentScan
@Configuration
public class TestConfiguration {

    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
