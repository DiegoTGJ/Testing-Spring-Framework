package org.springframework.samples.petclinic.springctxtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.samples.petclinic.springctx.YannyWordProducer;

/**
 * Created by Diego T. 12-08-2022
 */
@Configuration
public class YannyConfig {

    @Bean
    @Primary
    YannyWordProducer yannyWordProducer(){
        return new YannyWordProducer();
    }
}
