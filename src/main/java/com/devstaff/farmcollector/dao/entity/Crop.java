/**
 * 
 */
package com.devstaff.farmcollector.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Barani
 *	Crop entity class to store crop details
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "CROP")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TYPE")
    @NotEmpty
    private String type;

}
