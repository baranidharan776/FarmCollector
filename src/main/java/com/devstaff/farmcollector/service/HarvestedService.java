/**
 * 
 */
package com.devstaff.farmcollector.service;

import org.springframework.http.ResponseEntity;

import com.devstaff.farmcollector.model.HarvestedCropDTO;

/**
 * @author Barani
 *
 */
public interface HarvestedService {
	
	public ResponseEntity<HarvestedCropDTO> saveHarvestedCrop(HarvestedCropDTO harvestCropReq);

}
