package com.devstaff.farmcollector.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.devstaff.farmcollector.dao.entity.Harvested;
import com.devstaff.farmcollector.model.HarvestedCropDTO;
import com.devstaff.farmcollector.service.HarvestedService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HarvestedController.class)
class HarvestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HarvestedService mockHarvestService;

    @Test
    void testSaveHarvest() throws Exception {
        Harvested savedHarvest = new Harvested();
        savedHarvest.setId(1L);
        savedHarvest.setActualProductAmount(200.0);
        when(mockHarvestService.saveHarvestedCrop(any(HarvestedCropDTO.class))).thenReturn(new ResponseEntity<HarvestedCropDTO>(HttpStatus.CREATED));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/harvested")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"farmId\":1,\"cropId\":1,\"season\":1,\"actualProductAmount\":\"200.0\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }


}
