package org.springframework.samples.petclinic.springctxtest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.springctx.HearingInterpreter;
import org.springframework.samples.petclinic.springctx.WordProducer;

/**
 * Created by Diego T. 12-08-2022
 */
@Configuration
public class BaseConfig {

    @Bean
    HearingInterpreter hearingInterpreter(WordProducer wordProducer){
        return new HearingInterpreter(wordProducer);
    }
}
