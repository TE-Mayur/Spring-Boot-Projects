package com.te.resumebuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.ExtraDetails;

@Repository
public interface ExtraDetailsDAO extends CrudRepository<ExtraDetails, String> {

	public ExtraDetails save(ExtraDetails extraDetails);
}
