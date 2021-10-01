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
import com.dto.St2CMap;
import com.dto.St2SuMap;
import com.dto.Su2CMap;
import com.dto.T2SMap;

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
		case ("Su2CMap"):{
			Su2CMap su2c = new Su2CMap();
			su2c.setCode(rec.getVar1());
			su2c.setSuc(rec.getVar2());
			su2c.setClc(rec.getVar3());
			se.save(su2c);
			break;}
		case ("St2CMap"):{
			St2CMap st2c = new St2CMap();
			st2c.setCode(rec.getVar1());
			st2c.setRono(rec.getVar2());
			st2c.setClc(rec.getVar3());
			se.save(st2c);
			break;}
		case ("St2SuMap"):{
			St2SuMap st2su = new St2SuMap();
			st2su.setCode(rec.getVar1());
			st2su.setRono(rec.getVar2());
			st2su.setSuc(rec.getVar3());
			se.save(st2su);
			break;}
		case ("T2SMap"):{
			T2SMap t2su = new T2SMap();
			t2su.setCode(rec.getVar1());
			t2su.setSuc(rec.getVar2());
			t2su.setTec(rec.getVar3());
			se.save(t2su);
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
			break;}
		case("Su2CMap"):{
			Su2CMap su2c = se.get(Su2CMap.class, key);
			su2c.setCode(rec.getVar1());
			su2c.setSuc(rec.getVar2());
			su2c.setClc(rec.getVar3());
			se.update(su2c);
			break;}
		case("St2CMap"):{
			St2CMap st2c = se.get(St2CMap.class, key);
			st2c.setCode(rec.getVar1());
			st2c.setRono(rec.getVar2());
			st2c.setClc(rec.getVar3());
			se.update(st2c);
			break;}
		case("St2SuMap"):{
			St2SuMap st2su = se.get(St2SuMap.class, key);
			st2su.setCode(rec.getVar1());
			st2su.setRono(rec.getVar2());
			st2su.setSuc(rec.getVar3());
			se.update(st2su);
			break;}
		case("T2SMap"):{
			T2SMap t2su = se.get(T2SMap.class, key);
			t2su.setCode(rec.getVar1());
			t2su.setSuc(rec.getVar2());
			t2su.setTec(rec.getVar3());
			se.update(t2su);
			break;}
		}
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
		case("Su2CMap"):{
			Su2CMap su2c = se.get(Su2CMap.class, key);
			se.delete(su2c);
			break;}
		case("St2CMap"):{
			St2CMap st2c = se.get(St2CMap.class, key);
			se.delete(st2c);
			break;}
		case("St2SuMap"):{
			St2SuMap st2su = se.get(St2SuMap.class, key);
			se.delete(st2su);
			break;}
		case("T2SMap"):{
			T2SMap t2su = se.get(T2SMap.class, key);
			se.delete(t2su);
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

	@Override
	public Record[] ListMappings(String master) {
		System.out.println("Inside List Teacher Master method of DAO Implimentation");
		Record[] rec = null;
		switch (master) {
		case("Su2CMap"):{
			String qry = "FROM "+master;
			se = fac.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<Su2CMap> tqrysu2c = se.createQuery(qry);
			List<Su2CMap> su2crec = tqrysu2c.getResultList();
			rec = new Record[su2crec.size()];
			for (int i=0;i<su2crec.size();i++) {
				LASubject sub = se.get(LASubject.class, su2crec.get(i).getSuc());
				LAClass lacl = se.get(LAClass.class, su2crec.get(i).getClc());
				/*
				 * rec[i].Var1 = sub.getSucode(); rec[i].Var2 = sub.getSub(); rec[i].Var3 =
				 * sub.getSuDes(); rec[i].var4 = lacl.getClasscode(); rec[i].var5 =
				 * lacl.getClassname(); rec[i].var6 = lacl.getCldesc();
				 */
				 rec[i].setVar1(sub.getSucode());
				 rec[i].setVar2(sub.getSub());
				 rec[i].setVar3(sub.getSuDes());
				 rec[i].setVar4(lacl.getClasscode());
				 rec[i].setVar5(lacl.getClassname());
				 rec[i].setVar6(lacl.getCldesc());
			}
			break;}
		case("St2CMap"):{
			String qry = "FROM "+master;
			se = fac.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<St2CMap> tqryst2c = se.createQuery(qry);
			List<St2CMap> st2crec = tqryst2c.getResultList();
			rec = new Record[st2crec.size()];
			for (int i=0;i<st2crec.size();i++) {
				LAStudent stu = se.get(LAStudent.class, st2crec.get(i).getRono());
				LAClass lacl = se.get(LAClass.class, st2crec.get(i).getClc());
				rec[i].setVar1(stu.getRono());
				rec[i].setVar2(stu.getFname());
				rec[i].setVar3(stu.getLname());
				rec[i].setVar4(lacl.getClasscode());
				rec[i].setVar5(lacl.getClassname());
				rec[i].setVar6(lacl.getCldesc());
			}
			break;}
		case("St2SuMap"):{
			String qry = "FROM "+master;
			se = fac.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<St2SuMap> tqryst2c = se.createQuery(qry);
			List<St2SuMap> st2surec = tqryst2c.getResultList();
			rec = new Record[st2surec.size()];
			for (int i=0;i<st2surec.size();i++) {
				LAStudent stu = se.get(LAStudent.class, st2surec.get(i).getRono());
				LASubject sub = se.get(LASubject.class, st2surec.get(i).getSuc());
				rec[i].setVar1(stu.getRono());
				rec[i].setVar2(stu.getFname());
				rec[i].setVar3(stu.getLname());
				rec[i].setVar4(sub.getSucode());
				rec[i].setVar5(sub.getSub());
				rec[i].setVar6(sub.getSuDes());
			}
			break;}
		case("T2SMap"):{
			String qry = "FROM "+master;
			se = fac.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<T2SMap> tqryt2s = se.createQuery(qry);
			List<T2SMap> t2srec = tqryt2s.getResultList();
			rec = new Record[t2srec.size()];
			for (int i=0;i<t2srec.size();i++) {
				LATeacher teac = se.get(LATeacher.class, t2srec.get(i).getTec());
				LASubject sub = se.get(LASubject.class, t2srec.get(i).getSuc());
				rec[i].setVar1(teac.gettID());
				rec[i].setVar2(teac.getFname());
				rec[i].setVar3(teac.getLname());
				rec[i].setVar4(sub.getSucode());
				rec[i].setVar5(sub.getSub());
				rec[i].setVar6(sub.getSuDes());
			}
			break;}
		}
		return rec;
	}
}
