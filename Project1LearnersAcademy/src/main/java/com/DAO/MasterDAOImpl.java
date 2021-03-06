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
import com.dto.T2CMap;
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
		case ("T2CMap"):{
			T2CMap t2cu = new T2CMap();
			t2cu.setCode(rec.getVar1());
			t2cu.setClc(rec.getVar3());
			t2cu.setTec(rec.getVar2());
			se.save(t2cu);
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
		case("T2SMap"):{
			T2SMap t2su = se.get(T2SMap.class, key);
			t2su.setCode(rec.getVar1());
			t2su.setSuc(rec.getVar2());
			t2su.setTec(rec.getVar3());
			se.update(t2su);
			break;}
		case("T2CMap"):{
			T2CMap t2cu = se.get(T2CMap.class, key);
			t2cu.setCode(rec.getVar1());
			t2cu.setClc(rec.getVar3());
			t2cu.setTec(rec.getVar2());
			se.update(t2cu);
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
		case("T2SMap"):{
			T2SMap t2su = se.get(T2SMap.class, key);
			se.delete(t2su);
			break;}
		case("T2CMap"):{
			T2CMap t2c = se.get(T2CMap.class, key);
			se.delete(t2c);
			break;}
		case("St2CMap"):{
			St2CMap st2c = se.get(St2CMap.class, key);
			se.delete(st2c);
			break;}
		case("St2SuMap"):{
			St2SuMap st2su = se.get(St2SuMap.class, key);
			se.delete(st2su);
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
		String qry = "FROM LAStudent order by rono";
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
		String qry = "FROM LATeacher order by tID";
		se = fac.openSession();
		@SuppressWarnings("unchecked")
		TypedQuery<LATeacher> tqry = se.createQuery(qry);
		List<LATeacher> rec = tqry.getResultList();
		se.close();
		return rec;				
	}

	@Override
	public Record[] ListMappings(String master) {
		System.out.println("Inside List/Show Mapping Master method of DAO Implimentation");
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
				rec[i] = new Record();
				rec[i].setVar1(sub.getSucode());
				rec[i].setVar2(sub.getSub());
				rec[i].setVar3(sub.getSuDes());
				rec[i].setVar4(lacl.getClasscode());
				rec[i].setVar5(lacl.getClassname());
				rec[i].setVar6(lacl.getCldesc());
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
				rec[i] = new Record();
				rec[i].setVar1(teac.gettID());
				rec[i].setVar2(teac.getFname());
				rec[i].setVar3(teac.getLname());
				rec[i].setVar4(sub.getSucode());
				rec[i].setVar5(sub.getSub());
				rec[i].setVar6(sub.getSuDes());
			}
			break;}
		case("T2CMap"):{
			String qry = "FROM "+master;
			se = fac.openSession();
			@SuppressWarnings("unchecked")
			TypedQuery<T2CMap> tqryt2c = se.createQuery(qry);
			List<T2CMap> t2crec = tqryt2c.getResultList();
			rec = new Record[t2crec.size()];
			for (int i=0;i<t2crec.size();i++) {
				LATeacher teac = se.get(LATeacher.class, t2crec.get(i).getTec());
				LAClass lac = se.get(LAClass.class, t2crec.get(i).getClc());
				rec[i] = new Record();
				rec[i].setVar1(teac.gettID());
				rec[i].setVar2(teac.getFname());
				rec[i].setVar3(teac.getLname());
				rec[i].setVar4(lac.getClasscode());
				rec[i].setVar5(lac.getClassname());
				rec[i].setVar6(lac.getCldesc());
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
				rec[i] = new Record();
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
				rec[i] = new Record();
				rec[i].setVar1(stu.getRono());
				rec[i].setVar2(stu.getFname());
				rec[i].setVar3(stu.getLname());
				rec[i].setVar4(sub.getSucode());
				rec[i].setVar5(sub.getSub());
				rec[i].setVar6(sub.getSuDes());
			}
			break;}
		}
		return rec;
	}

	@Override
	public Record[][] ClassWiseReport(String classDesc) {
		System.out.println("Inside Show Class Wise Report method of DAO Implimentation");
		se = fac.openSession();
		//identify class code from class Description
		String classkey = "FROM LAClass WHERE cldesc='"+classDesc+"'";
		@SuppressWarnings("unchecked")
		TypedQuery<LAClass> qryclasskey = se.createQuery(classkey);
		LAClass lac = qryclasskey.getSingleResult();
		//pull up all the subjects mapped to the class
		String subqry = "FROM Su2CMap WHERE clc='"+lac.getClasscode()+"'";
		@SuppressWarnings("unchecked")
		TypedQuery<Su2CMap> tableheader = se.createQuery(subqry);
		List<Su2CMap> subject = tableheader.getResultList();
		//pull up all the Students mapped to the class
		String tvalueqry = "FROM St2CMap WHERE clc='"+lac.getClasscode()+"'";
		@SuppressWarnings("unchecked")
		TypedQuery<St2CMap> tableValue = se.createQuery(tvalueqry);
		List<St2CMap> student = tableValue.getResultList();
		
		Record[][] rec = new Record[subject.size()][student.size()+2];
		for(int i=0;i<rec.length;i++) {
			for(int j=0;j<rec[i].length;j++) {
				LASubject sub = se.get(LASubject.class, subject.get(i).getSuc());
				String t2scqry = "FROM T2SMap WHERE suc='"+sub.getSucode()+"'";
				@SuppressWarnings("unchecked")
				TypedQuery<T2SMap> qryt2s = se.createQuery(t2scqry);
				List<T2SMap> t2s = qryt2s.getResultList();
				
				if(j==0) {
					//set header row as Subject Name
					rec[i][j] = new Record();
					rec[i][j].setVar1(sub.getSub());
				}else if (j==1) {
					//set 2nd row as Teacher names, hence pull up the Teacher mapped to the subject
					for (int k =0; k < t2s.size(); k++) {
						String t2chql = "FROM T2CMap WHERE tec='"+t2s.get(k).getTec()+"'";
						@SuppressWarnings("unchecked")
						TypedQuery<T2CMap> qryt2c = se.createQuery(t2chql);
						T2CMap t2cmap = qryt2c.getSingleResult();
						String s1 = t2cmap.getClc();
						String s2 = lac.getClasscode();
						if(s1.equals(s2)) {
							LATeacher teacher = se.get(LATeacher.class, t2cmap.getTec());
							rec[i][j] = new Record();
							rec[i][j].setVar1(teacher.getFname()+" "+teacher.getLname());
						}
					}					
				}else {
					LAStudent stu = se.get(LAStudent.class, student.get(j-2).getRono());
					rec[i][j] = new Record();
					rec[i][j].setVar1(stu.getFname()+" "+stu.getLname());
				}
			}
		}
		se.close();
		return rec;
	}
}
