package org.springframework.samples.petclinic.springctx;

import org.springframework.stereotype.Service;

/**
 * Created by Diego T. 12-08-2022
 */
@Service
public class HearingInterpreter {

    private final WordProducer wordProducer;

    public HearingInterpreter(WordProducer wordProducer) {
        this.wordProducer = wordProducer;
    }

    public String whatIheard(){
        String word = wordProducer.getWord();
        System.out.println(word);
        return word;
    }
}
