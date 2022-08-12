package org.springframework.samples.petclinic.springctx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 * Created by Diego T. 12-08-2022
 */
@Profile("base-test")
@Configuration
public class YannyConfig {

    @Bean
    @Primary
    YannyWordProducer yannyWordProducer(){
        return new YannyWordProducer();
    }
}
