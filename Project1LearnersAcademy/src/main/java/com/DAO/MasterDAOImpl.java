package com.DAO;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.dto.LAClass;
import com.dto.LAStudent;
import com.dto.LASubject;
import com.dto.LATeacher;
import com.dto.Record;

public class MasterDAOImpl implements MastersDAO {
	private SessionFactory fac;
	private Session se;
	 
	
	public MasterDAOImpl() {
		StandardServiceRegistry reg = new StandardServiceRegistryBuilder().configure("/hibernate.cfg.xml").build();
		Metadata sources = new MetadataSources(reg).getMetadataBuilder().build();
		fac = sources.getSessionFactoryBuilder().build();
	}

	@Override
	public void addMaster(String master, Record rec) {
		se = fac.openSession();
		Transaction txn = se.beginTransaction();
		System.out.println("Inside Add master method of DAO Implimentation");
		System.out.println("Record to be updated:"+rec);
		switch (master) {
		case("class"):{
			LAClass laclass = new LAClass();
			laclass.setClasscode(rec.getVar1());
			laclass.setClassname(rec.getVar2());
			laclass.setCldesc(rec.getVar3());
			se.save(laclass);
			break;}
		case("student"):{
			LAStudent stu = new LAStudent();
			stu.setRono(rec.getVar1());
			stu.setFname(rec.getVar2());
			stu.setLname(rec.getVar3());
			se.save(stu);
			break;}
		case ("teacher"):{
			LATeacher teacher = new LATeacher();
			teacher.setTID(rec.getVar1());
			teacher.setFname(rec.getVar2());
			teacher.setLname(rec.getVar3());
			se.save(teacher);
			break;}
		case ("subject"):{
			LASubject sub = new LASubject();
			sub.setSucode(rec.getVar1());
			sub.setSub(rec.getVar2());
			sub.setSuDes(rec.getVar3());
			se.save(sub);
			break;}
	}
		txn.commit();
		se.close();		
	}

	@Override
	public void updateMaster(String master, String key, Record rec) {
		se = fac.openSession();
		Transaction txn = se.beginTransaction();
		System.out.println("Inside Update master method of DAO Implimentation");
		switch (master) {
		case("class"):{
			LAClass laclass = se.get(LAClass.class, key);
			laclass.setClasscode(rec.getVar1());
			laclass.setClassname(rec.getVar2());
			laclass.setCldesc(rec.getVar3());
			se.update(laclass);
			break;}
		case("student"):{
			LAStudent stu = se.get(LAStudent.class, key);
			stu.setRono(rec.getVar1());
			stu.setFname(rec.getVar2());
			stu.setLname(rec.getVar3());
			se.update(stu);
			break;}
		case ("teacher"):{
			LATeacher teacher = se.get(LATeacher.class, key);
			teacher.setTID(rec.getVar1());
			teacher.setFname(rec.getVar2());
			teacher.setLname(rec.getVar3());
			se.update(teacher);
			break;}
		case ("subject"):{
			LASubject sub = se.get(LASubject.class, key);
			sub.setSucode(rec.getVar1());
			sub.setSub(rec.getVar2());
			sub.setSuDes(rec.getVar3());
			se.update(sub);
			break;}}
		txn.commit();
		se.close();
	}

	@Override
	public void deleteMaster(String master, String key) {
		se = fac.openSession();
		Transaction txn = se.beginTransaction();
		System.out.println("Inside Delete master method of DAO Implimentation");
		switch (master) {
		case ("class"):{
			LAClass laclass = se.get(LAClass.class, key);
			se.delete(laclass);
			break;}
		case ("student"):{
			LAStudent stu = se.get(LAStudent.class, key);
			se.delete(stu);
			break;}
		case ("teacher"):{
			LATeacher teacher = se.get(LATeacher.class, key);
			se.delete(teacher);
			break;}
		case ("subject"):{
			LASubject sub = se.get(LASubject.class, key);
			se.delete(sub);
			break;}
		}
		txn.commit();
		se.close();	
	}

	@Override
	public List<LAClass> listClassMaster() {
		System.out.println("Inside List Class Master method of DAO Implimentation");
		String qry = "FROM LAClass";
		se = fac.openSession();
		@SuppressWarnings("unchecked")
		TypedQuery<LAClass> tqry = se.createQuery(qry);
		List<LAClass> rec = tqry.getResultList();
		se.close();
		return rec;				
	}

	@Override
	public List<LAStudent> listStudentMaster() {
		System.out.println("Inside List Student Master method of DAO Implimentation");
		String qry = "FROM LAStudent";
		se = fac.openSession();
		@SuppressWarnings("unchecked")
		TypedQuery<LAStudent> tqry = se.createQuery(qry);
		List<LAStudent> rec = tqry.getResultList();
		se.close();
		return rec;				
	}

	@Override
	public List<LASubject> listSubjectMaster() {
		System.out.println("Inside List Subject Master method of DAO Implimentation");
		String qry = "FROM LASubject";
		se = fac.openSession();
		@SuppressWarnings("unchecked")
		TypedQuery<LASubject> tqry = se.createQuery(qry);
		List<LASubject> rec = tqry.getResultList();
		se.close();
		return rec;				
	}

	@Override
	public List<LATeacher> listTeacherMaster() {
		System.out.println("Inside List Teacher Master method of DAO Implimentation");
		String qry = "FROM LATeacher";
		se = fac.openSession();
		@SuppressWarnings("unchecked")
		TypedQuery<LATeacher> tqry = se.createQuery(qry);
		List<LATeacher> rec = tqry.getResultList();
		se.close();
		return rec;				
	}
}
