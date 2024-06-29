/**
 * 
 */
package com.devstaff.farmcollector.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.devstaff.farmcollector.model.ReportRequestDTO;
import com.devstaff.farmcollector.model.ReportResponseDTO;

import jakarta.validation.Valid;

/**
 * @author Barani
 *
 */
public interface ReportService {

	ResponseEntity<List<ReportResponseDTO>> fetchReportByRequest(@Valid ReportRequestDTO request);
	
}
