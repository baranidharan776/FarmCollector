/**
 * 
 */
package com.devstaff.farmcollector.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Barani
 * Planted entity class to store planted crop details
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "PLANTED")
public class Planted {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @NotEmpty
    @JoinColumn(name = "FARM_ID", nullable = false)
    private Farm farm;

    @ManyToOne
    @NotEmpty
    @JoinColumn(name = "CROP_ID", nullable = false)
    private Crop crop;

    @ManyToOne
    @NotEmpty
    @JoinColumn(name = "SEASON", nullable = false)
    private Season season;

    @Column(name = "PLANTING_AREA")
    @NotEmpty
    private double plantingArea;

    @Column(name = "EXPECTED_PRODUCT_AMT")
    @NotEmpty
    private double expectedProductAmount;
}
