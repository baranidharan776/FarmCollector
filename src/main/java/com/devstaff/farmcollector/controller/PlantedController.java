/**
 * 
 */
package com.devstaff.farmcollector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devstaff.farmcollector.model.PlantedCropDTO;
import com.devstaff.farmcollector.service.PlantedService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author Barani
 * Controller class to handle operations where farmer planted his crop
 */
@RestController
@RequestMapping("/api/planted")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Crop Planted API",
                version = "1.0",
                description = "API for managing crop palneted for the respective season for a farm"
        )
)
public class PlantedController {
	
	@Autowired
    private PlantedService plantedService;

    @PostMapping
    @Operation(summary = "Save the planted crop details", description = "API to save the planted crop data of a farm in a season for an actual amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Planted crop details were saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    public ResponseEntity<PlantedCropDTO> savePlantedCrop(@Valid @RequestBody PlantedCropDTO request){
        return plantedService.savePlantedCrop(request);
    }

}
