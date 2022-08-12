package org.springframework.samples.petclinic.springctx;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Diego T. 12-08-2022
 */
@TestPropertySource("classpath:laurel.properties")
@ActiveProfiles("externalized")
@SpringJUnitConfig(classes = {LaurelPropertiesTest.TestConfig.class})
public class LaurelPropertiesTest {

    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.springctx")
    static class  TestConfig {
    }
    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    void whatIheard() {
        String word = hearingInterpreter.whatIheard();

        assertEquals("Someofthat",word);
    }
}
