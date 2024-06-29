package com.devstaff.farmcollector.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Barani
 * Harvested entity class to store harvested crop details for a season
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "HARVESTED")
public class Harvested {
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
    @JoinColumn(name = "SEASON", nullable =false)
    private Season season;

    @Column(name = "ACTUAL_PRODUCT_AMT")
    @NotEmpty
    private double actualProductAmount;

}
