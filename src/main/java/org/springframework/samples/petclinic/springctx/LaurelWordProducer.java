package org.springframework.samples.petclinic.springctx;

import org.springframework.stereotype.Component;

/**
 * Created by Diego T. 12-08-2022
 */
@Component
public class LaurelWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Laurel";
    }
}
