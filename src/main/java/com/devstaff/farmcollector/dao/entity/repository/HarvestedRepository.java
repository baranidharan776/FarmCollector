package com.devstaff.farmcollector.dao.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devstaff.farmcollector.dao.entity.Harvested;

@Repository
public interface HarvestedRepository extends JpaRepository<Harvested, Long> {

	@Query("select h from Harvested h where h.farm = :farm and h.crop = :crop and h.season = :season")
	List<Harvested> fecthHarvestedCropsByParam(@Param("farm")Long farmId, @Param("crop")Long cropId, @Param("season")Long season);
}