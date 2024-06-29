/**
 * 
 */
package com.devstaff.farmcollector.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.devstaff.farmcollector.dao.entity.Harvested;
import com.devstaff.farmcollector.dao.entity.Planted;
import com.devstaff.farmcollector.dao.entity.repository.HarvestedRepository;
import com.devstaff.farmcollector.dao.entity.repository.PlantedRepository;
import com.devstaff.farmcollector.model.ReportRequestDTO;
import com.devstaff.farmcollector.model.ReportResponseDTO;
import com.devstaff.farmcollector.service.ReportService;

import jakarta.validation.Valid;

/**
 * @author Barani
 *
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private PlantedRepository plantedRepository;
	
	@Autowired
	private HarvestedRepository harvestedRepository;

	@Override
	public ResponseEntity<List<ReportResponseDTO>> fetchReportByRequest(@Valid ReportRequestDTO request) {
		List<ReportResponseDTO> reportList = new ArrayList<ReportResponseDTO>();
		List<Planted> plantedCrops = plantedRepository.fecthPlantedCropsByParam(request.getFarmId(),request.getCropId(), request.getSeason());
		List<Harvested> harvestedCrops = harvestedRepository.fecthHarvestedCropsByParam(request.getFarmId(),request.getCropId(), request.getSeason());
		
		for(Planted plantedCrop : plantedCrops)
		{
			Harvested harvestedCrop = harvestedCrops.stream()
                    .filter(x -> x.getFarm().equals(plantedCrop.getFarm()) && x.getCrop().equals(plantedCrop.getCrop()) && x.getSeason().equals(plantedCrop.getSeason()))
                    .findFirst()
                    .orElse(null);
			ReportResponseDTO reportResponseDTO = new ReportResponseDTO();
			reportResponseDTO.setFarmId(plantedCrop.getFarm().getId());
			reportResponseDTO.setCropId(plantedCrop.getCrop().getId());
			reportResponseDTO.setSeason(plantedCrop.getSeason().getId());
			reportResponseDTO.setExpectedProductAmount(plantedCrop.getExpectedProductAmount());
			reportResponseDTO.setPlantingArea(plantedCrop.getPlantingArea());
			reportResponseDTO.setActualProductAmount(harvestedCrop.getActualProductAmount());
			reportList.add(reportResponseDTO);
		}
		
		return new ResponseEntity<List<ReportResponseDTO>>(reportList,HttpStatus.OK);
	}

}
