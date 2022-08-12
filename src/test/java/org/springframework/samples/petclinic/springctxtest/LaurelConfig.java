package org.springframework.samples.petclinic.springctxtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.springctx.LaurelWordProducer;

/**
 * Created by Diego T. 12-08-2022
 */
@Configuration
public class LaurelConfig {
    @Bean
    LaurelWordProducer laurelWordProducer(){
        return new LaurelWordProducer();
    }
}
