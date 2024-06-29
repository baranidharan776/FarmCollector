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
 * Farm entity class to store farm details
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "FARM")
public class Farm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    @NotEmpty
    private String name;
}
