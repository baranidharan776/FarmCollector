/**
 * 
 */
package com.devstaff.farmcollector.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devstaff.farmcollector.dao.entity.Harvested;
import com.devstaff.farmcollector.dao.entity.repository.CropRepository;
import com.devstaff.farmcollector.dao.entity.repository.FarmRepository;
import com.devstaff.farmcollector.dao.entity.repository.HarvestedRepository;
import com.devstaff.farmcollector.dao.entity.repository.SeasonRepository;
import com.devstaff.farmcollector.model.HarvestedCropDTO;
import com.devstaff.farmcollector.service.HarvestedService;

/**
 * @author Barani
 *
 */
@Service
public class HarvestedCropServiceImpl implements HarvestedService {

	@Autowired
	private HarvestedRepository harvestedRepository;

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private CropRepository cropRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public ResponseEntity<HarvestedCropDTO> saveHarvestedCrop(HarvestedCropDTO harvestCropReq) {
		Harvested harvest = new Harvested();
		harvest.setFarm(farmRepository.findById(harvestCropReq.getFarmId()).orElse(null));
		harvest.setCrop(cropRepository.findById(harvestCropReq.getCropId()).orElse(null));
		harvest.setSeason(seasonRepository.findById(harvestCropReq.getSeason()).orElse(null));
		harvest.setActualProductAmount(harvestCropReq.getActualProductAmount());
		Harvested harvestedCrop = harvestedRepository.save(harvest);
		if (harvestedCrop != null) {
			return new ResponseEntity<HarvestedCropDTO>(harvestCropReq, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<HarvestedCropDTO>(harvestCropReq, HttpStatus.BAD_REQUEST);
		}
	}

}
