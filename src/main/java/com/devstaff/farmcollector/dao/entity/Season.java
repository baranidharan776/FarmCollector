/**
 * 
 */
package com.devstaff.farmcollector.dao.entity;

import com.devstaff.farmcollector.util.SeasonsEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Barani
 *
 */
@Entity
@Getter
@Setter
@ToString
@Table(name = "SEASON")
public class Season {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Enumerated(EnumType.STRING)
	private SeasonsEnum season;
}
