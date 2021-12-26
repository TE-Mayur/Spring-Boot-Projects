package com.te.resumebuilder.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.te.resumebuilder.beans.PersonalDetails;

@Repository
public interface PersonalDAO extends CrudRepository<PersonalDetails, String> {

	public PersonalDetails save(PersonalDetails details);
}
