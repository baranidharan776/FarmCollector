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

import com.devstaff.farmcollector.model.HarvestedCropDTO;
import com.devstaff.farmcollector.service.HarvestedService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

/**
 * @author Barani
 * Controller class to handle operations where farmer harvested his crop
 */
@RestController
@RequestMapping("/api/harvested")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Crop Harvested API",
                version = "1.0",
                description = "API for managing crop harvesting for the respective season for a farm"
        )
)
public class HarvestedController {
	
	@Autowired
    private HarvestedService harvestedService;

    @PostMapping
    @Operation(summary = "Save the harvested crop details", description = "API to save the harvested crop data of a farm in a season for an actual amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Harvested crop details were saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    public ResponseEntity<HarvestedCropDTO> saveHarvest(@Valid @RequestBody HarvestedCropDTO request) {
        return harvestedService.saveHarvestedCrop(request);
    }

}
