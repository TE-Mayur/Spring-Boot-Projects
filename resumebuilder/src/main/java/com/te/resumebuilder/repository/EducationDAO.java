package com.te.resumebuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.EducationInfo;

@Repository
public interface EducationDAO extends CrudRepository<EducationInfo, String> {

	public EducationInfo  save(EducationInfo edu);
}
