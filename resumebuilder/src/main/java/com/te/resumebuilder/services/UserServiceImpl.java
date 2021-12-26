package com.te.resumebuilder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.te.resumebuilder.beans.EducationInfo;
import com.te.resumebuilder.beans.ExperienceInfo;
import com.te.resumebuilder.beans.ExtraDetails;
import com.te.resumebuilder.beans.PersonalDetails;
import com.te.resumebuilder.beans.ProjectsInfo;
import com.te.resumebuilder.beans.UserInfo;
import com.te.resumebuilder.customexception.ExceptionHandle;
import com.te.resumebuilder.repository.EducationDAO;
import com.te.resumebuilder.repository.ExperienceDAO;
import com.te.resumebuilder.repository.ExtraDetailsDAO;
import com.te.resumebuilder.repository.PersonalDAO;
import com.te.resumebuilder.repository.ProjectDAO;
import com.te.resumebuilder.repository.UserDAO;

@Service
public class UserServiceImpl
		implements UserService, EducationService, ExperienceService, ExtraService, PersonalService, ProjectService {

	@Autowired
	private UserDAO user;

	@Autowired
	private EducationDAO education;

	@Autowired
	private ExperienceDAO experience;

	@Autowired
	private ExtraDetailsDAO extra;

	@Autowired
	private PersonalDAO personal;

	@Autowired
	private ProjectDAO project;

	@Override
	@Transactional
	public UserInfo signup(UserInfo info) {
		if (info != null) {
			return user.save(info);
		}
		throw new ExceptionHandle("Data Already Found");
	}

	@Override
	public UserInfo login(String email, String password) {
		if ((!email.isEmpty() && email != null) && (!password.isEmpty() && password != null)) {
			UserInfo logg = user.findByEmailAndPassword(email, password);
			if (logg != null) {
				return logg;
			} else {
				throw new ExceptionHandle("Invalid Credentials");
			}
		} else {
			throw new ExceptionHandle("Enter valid Login Details");
		}
	}

	@Override
	@Transactional
	public PersonalDetails personalDetails(PersonalDetails details) {
		if (details != null) {
			return personal.save(details);
		}
		throw new ExceptionHandle("Please fill the correct details");
	}

	@Override
	@Transactional
	public ExtraDetails extraDetails(ExtraDetails extraDetails) {
		if (extraDetails != null) {
			return extra.save(extraDetails);
		}
		throw new ExceptionHandle("Please fill the correct details");
	}

	@Override
	@Transactional
	public ProjectsInfo projectsInfo(ProjectsInfo projectsInfo) {
		if (projectsInfo != null) {
			return project.save(projectsInfo);
		}
		throw new ExceptionHandle("Please fill the correct details");
	}

	@Override
	@Transactional
	public EducationInfo storeEducation(EducationInfo edu) {
		if (edu != null) {
			return education.save(edu);
		}
		throw new ExceptionHandle("Please fill the correct details");
	}

	@Override
	@Transactional
	public ExperienceInfo expInfo(ExperienceInfo exp) {
		if (exp != null) {
			return experience.save(exp);
		}
		throw new ExceptionHandle("Please fill the correct details");
	}

	@Override
	public UserInfo getUser(Integer serialNo) {
		Optional<UserInfo> info = user.findBySerialNo(serialNo);
		UserInfo info1 = info.get();
		return info1;
	}
}