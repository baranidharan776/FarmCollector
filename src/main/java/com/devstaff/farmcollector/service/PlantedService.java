/**
 * 
 */
package com.devstaff.farmcollector.service;

import org.springframework.http.ResponseEntity;

import com.devstaff.farmcollector.model.PlantedCropDTO;

/**
 * @author Barani
 *
 */
public interface PlantedService {
	
	public ResponseEntity<PlantedCropDTO> savePlantedCrop(PlantedCropDTO plantedCropReq);

}
