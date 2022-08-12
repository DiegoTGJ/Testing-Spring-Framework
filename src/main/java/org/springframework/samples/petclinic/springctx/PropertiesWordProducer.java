package org.springframework.samples.petclinic.springctx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Diego T. 12-08-2022
 */
@Component
@Profile("externalized")
public class PropertiesWordProducer implements WordProducer{

    private String word;

    @Value("${say.word}")
    public void setWord(String word){
        this.word = word;
    }
    @Override
    public String getWord() {
        return word;
    }
}
