/**
 * 
 */
package com.devstaff.farmcollector.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Barani
 *
 */
@Data
@Getter
@Setter
public class ReportRequestDTO {

	@NotEmpty
	private Long farmId;
	@NotEmpty
	private Long cropId;
	@NotEmpty
	private Long season;
	
}
