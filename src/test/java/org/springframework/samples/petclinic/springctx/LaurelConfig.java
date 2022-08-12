package org.springframework.samples.petclinic.springctx;

import org.springframework.context.annotation.Bean;

/**
 * Created by Diego T. 12-08-2022
 */
public class LaurelConfig {
    @Bean
    LaurelWordProducer laurelWordProducer(){
        return new LaurelWordProducer();
    }
}
