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

import com.devstaff.farmcollector.dao.entity.Planted;
import com.devstaff.farmcollector.model.PlantedCropDTO;
import com.devstaff.farmcollector.service.PlantedService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlantedController.class)
public class PlantedControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PlantedService mockPlantService;

    @Test
    void testSaveHarvest() throws Exception {
        Planted savedPlant = new Planted();
        savedPlant.setId(1L);
        savedPlant.setExpectedProductAmount(200.0);

        when(mockPlantService.savePlantedCrop(any(PlantedCropDTO.class))).thenReturn(new ResponseEntity<PlantedCropDTO>(HttpStatus.CREATED));

        mockMvc.perform(MockMvcRequestBuilders.post("/api/planted")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"expectedProduct\":\"200.0\"}"))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
