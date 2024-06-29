package com.devstaff.farmcollector.dao.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devstaff.farmcollector.dao.entity.Planted;

@Repository
public interface PlantedRepository extends JpaRepository<Planted, Long> {
	
		@Query("select p from Planted p where p.farm.id = :farm and p.crop.id = :crop and p.season.id = :season")
		List<Planted> fecthPlantedCropsByParam(@Param("farm")Long farmId, @Param("crop")Long cropId, @Param("season")Long season);

}