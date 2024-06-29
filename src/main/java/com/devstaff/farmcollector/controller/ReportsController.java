/**
 * 
 */
package com.devstaff.farmcollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devstaff.farmcollector.model.ReportRequestDTO;
import com.devstaff.farmcollector.model.ReportResponseDTO;
import com.devstaff.farmcollector.service.ReportService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

/**
 * @author Barani
 * Controller class to handle reports
 */
@RestController
@RequestMapping("/api/reports")
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Reports for farm collector",
                version = "1.0",
                description = "API and View for managing reports related to Farm collector"
        )
)
public class ReportsController {
	
	@Autowired
    private ReportService reportService;

    @PostMapping
    @Operation(summary = "Reports generated for farm collector", description = "API to fetch reports based on request")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Planted crop details were saved successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "500", description = "Internal Server error")
    })
    public ResponseEntity<List<ReportResponseDTO>> fetchReportByRequest(@Valid @RequestBody ReportRequestDTO request){
        return reportService.fetchReportByRequest(request);
    }
    

}
