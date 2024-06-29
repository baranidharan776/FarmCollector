/**
 * 
 */
package com.devstaff.farmcollector.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devstaff.farmcollector.dao.entity.Crop;
import com.devstaff.farmcollector.dao.entity.Farm;
import com.devstaff.farmcollector.dao.entity.Planted;
import com.devstaff.farmcollector.dao.entity.Season;
import com.devstaff.farmcollector.dao.entity.repository.CropRepository;
import com.devstaff.farmcollector.dao.entity.repository.FarmRepository;
import com.devstaff.farmcollector.dao.entity.repository.PlantedRepository;
import com.devstaff.farmcollector.dao.entity.repository.SeasonRepository;
import com.devstaff.farmcollector.model.PlantedCropDTO;
import com.devstaff.farmcollector.service.PlantedService;
import com.devstaff.farmcollector.util.InvalidInputException;
import com.devstaff.farmcollector.util.SeasonsEnum;

/**
 * @author Barani
 *
 */
@Service
public class PlantedCropServiceImpl implements PlantedService {

	@Autowired
	private PlantedRepository PlantedRepository;

	@Autowired
	private FarmRepository farmRepository;

	@Autowired
	private CropRepository cropRepository;

	@Autowired
	private SeasonRepository seasonRepository;

	@Override
	public ResponseEntity<PlantedCropDTO> savePlantedCrop(PlantedCropDTO plantedCropReq){
		Planted planted = new Planted();
		Farm farm = farmRepository.findById(plantedCropReq.getFarmId()).orElse(null);
		if (farm == null) {
			farm = new Farm();
			farm.setId(plantedCropReq.getFarmId());
			farm.setName(plantedCropReq.getFarmName());
			farm = farmRepository.save(farm);
		}
		planted.setFarm(farm);
		Crop crop = cropRepository.findById(plantedCropReq.getCropId()).orElse(null);
        if (crop == null) {
            crop = new Crop();
            crop.setId(plantedCropReq.getCropId());
            crop.setType(plantedCropReq.getCropType());
            crop = cropRepository.save(crop);
        }
		planted.setCrop(crop);
		Season season = seasonRepository.findById(plantedCropReq.getSeason()).orElse(null);
		if (season == null) {
            season = new Season();
            SeasonsEnum enumValue = findBySeasonName(plantedCropReq.getSeasonName());
            if(enumValue ==  null)
            	throw new InvalidInputException("Season");
            season.setSeason(enumValue);
            season = seasonRepository.save(season);
        }
		planted.setSeason(season);
		planted.setExpectedProductAmount(plantedCropReq.getExpectedProductAmount());
		planted.setPlantingArea(plantedCropReq.getPlantingArea());
		Planted PlantedCrop = PlantedRepository.save(planted);
		if (PlantedCrop != null) {
			return new ResponseEntity<PlantedCropDTO>(plantedCropReq, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<PlantedCropDTO>(plantedCropReq, HttpStatus.BAD_REQUEST);
		}
	}

	
	public static SeasonsEnum findBySeasonName(String SeasonName) {
		SeasonsEnum result = null;
	    for (SeasonsEnum season : SeasonsEnum.values()) {
	        if (season.name().equalsIgnoreCase(SeasonName)) {
	            result = season;
	            break;
	        }
	    }
	    return result;
	}
}
