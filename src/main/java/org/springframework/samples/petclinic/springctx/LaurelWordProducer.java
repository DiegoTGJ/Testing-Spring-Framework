package org.springframework.samples.petclinic.springctx;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Diego T. 12-08-2022
 */
@Profile({"laurel","default"})
@Component
public class LaurelWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Laurel";
    }
}
