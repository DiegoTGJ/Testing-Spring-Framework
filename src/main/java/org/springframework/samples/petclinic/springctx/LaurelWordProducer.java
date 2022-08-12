package org.springframework.samples.petclinic.springctx;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Diego T. 12-08-2022
 */
@Service
@Qualifier("Laurel")
public class LaurelWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Laurel";
    }
}
