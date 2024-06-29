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
public class PlantedCropDTO {
	@NotEmpty
	private Long farmId;
	private String farmName;
	@NotEmpty
	private Long cropId;
	private String cropType;
	@NotEmpty
	private Long season;
	private String seasonName;
	@NotEmpty
	private double plantingArea;
	@NotEmpty
	private double expectedProductAmount;
}
