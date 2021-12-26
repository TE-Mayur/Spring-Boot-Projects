package com.te.resumebuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.ExperienceInfo;

@Repository
public interface ExperienceDAO extends CrudRepository<ExperienceInfo, String> {

	public ExperienceInfo save(ExperienceInfo exp);
}
