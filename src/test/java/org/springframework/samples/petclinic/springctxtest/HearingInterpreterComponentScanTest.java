package org.springframework.samples.petclinic.springctxtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.samples.petclinic.springctx.HearingInterpreter;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringJUnitConfig(classes = {HearingInterpreterComponentScanTest.TestConfig.class})
class HearingInterpreterComponentScanTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.springctx")
    static class  TestConfig {
    }
    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertEquals("Yanny",word);
    }
}