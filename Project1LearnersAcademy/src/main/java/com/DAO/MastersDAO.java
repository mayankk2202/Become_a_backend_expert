package com.DAO;

import java.util.List;

import com.dto.LAClass;
import com.dto.LAStudent;
import com.dto.LASubject;
import com.dto.LATeacher;
import com.dto.Record;

public interface MastersDAO {
	public void addMaster(String master, Record rec);
	public void updateMaster(String master, String key, Record rec);
	public void deleteMaster(String master, String key);
	public List<LAClass> listClassMaster();
	public List<LAStudent> listStudentMaster();
	public List<LASubject> listSubjectMaster();
	public List<LATeacher> listTeacherMaster();
}
