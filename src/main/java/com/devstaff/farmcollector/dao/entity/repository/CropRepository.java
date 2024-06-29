package com.devstaff.farmcollector.dao.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devstaff.farmcollector.dao.entity.Crop;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}
