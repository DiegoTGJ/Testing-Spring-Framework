package org.springframework.samples.petclinic.springctx;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * Created by Diego T. 12-08-2022
 */
@Service
@Primary
public class YannyWordProducer implements WordProducer{
    @Override
    public String getWord() {
        return "Yanny";
    }
}
