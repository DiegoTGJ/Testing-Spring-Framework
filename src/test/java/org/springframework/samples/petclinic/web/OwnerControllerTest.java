package org.springframework.samples.petclinic.web;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collection;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@SpringJUnitWebConfig(locations = {"classpath:spring/mvc-test-config.xml", "classpath:spring/mvc-core-config.xml"})
class OwnerControllerTest {



    @Autowired
    ClinicService clinicService;

    @Autowired
    OwnerController ownerController;


    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    MockMvc mockMvc;

    Owner owner = new Owner();

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    Collection<Owner> ownerCollection;
    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();
        ownerCollection = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        reset(clinicService);
    }

    @Test
    void initCreationFormTest() throws Exception {
        owner.setId(3);

        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name(VIEWS_OWNER_CREATE_OR_UPDATE_FORM))
                .andExpect(model().attributeExists("owner"));
    }

    @Test
    void findByNameNotFound() throws Exception {

        given(clinicService.findOwnerByLastName(anyString())).willReturn(new ArrayList<>());
        mockMvc.perform(get("/owners")
                .param("lastName","Don't Find Me"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"));
    }

    @Test
    void findByNameFoundOne() throws Exception {
        owner.setId(3);
        ownerCollection.add(owner);
        given(clinicService.findOwnerByLastName(anyString())).willReturn(ownerCollection);

        mockMvc.perform(get("/owners")
                        .param("lastName","Don't Find Me"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/owners/"+owner.getId()));
    }

    @Test
    void findByNameFoundMany() throws Exception {
        Owner owner2 = new Owner();
        ownerCollection.add(owner);
        ownerCollection.add(owner2);
        given(clinicService.findOwnerByLastName("")).willReturn(ownerCollection);

        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("selections"));
        then(clinicService).should().findOwnerByLastName(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue()).isEqualToIgnoringCase("");
    }
}