package com.nikitha.jpa.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.nikitha.jpa.model.Address;
import com.nikitha.jpa.model.Student;


public class StudentDaoInterfaceImpl implements StudentDaoInterface
{
	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	
	static
	{
		emf = Persistence.createEntityManagerFactory("nikitha");
		em = emf.createEntityManager();
	}
	
	public String addStudent(Student student) 
	{
		et = em.getTransaction();
		et.begin();
			em.persist(student);
		et.commit();
		return "Record added";
	}
	
	public String updateStudent(Student student) 
	{
		et = em.getTransaction();
		et.begin();
			Student student1 = em.find(Student.class,student.getStudentId());
			student1.setFirstName(student.getFirstName());
			student1.setLastName(student.getLastName());
			student1.setPhoneNo(student.getPhoneNo());
			student1.setEmailId(student.getEmailId());
			student1.setAddmisionDate(student.getAddmisionDate());
			student1.getAddress().setHouseNo(student.getAddress().getHouseNo());
			student1.getAddress().setCity(student.getAddress().getCity());
			student1.getAddress().setState(student.getAddress().getState());
			student1.getAddress().setPincode(student.getAddress().getPincode());
		et.commit();
		return "Record Upadted";
	}
	
	public String deleteStudent(Integer studentId) 
	{
		Student student = em.find(Student.class,studentId);
		et = em.getTransaction();
		et.begin();
			em.remove(student);
		et.commit();
		return "Record deleted";
	}


	public Student findByStudentId(Integer studentId)
	{
		Student student = em.find(Student.class,studentId);
		return student;
	}
	
	public List<Student> findByStudentName(String firstName)
	{
		Query query = em.createQuery("select s from Student s where s.firstName like ?1");
		query.setParameter(1, firstName+"%");
		List<Student> list = query.getResultList();
		return list;
	}
	
	public List<Address> findByCity(String city)
	{
		Query query = em.createQuery("select a from Address a where a.city like ?1");
		query.setParameter(1, city+"%");
		List<Address> list = query.getResultList();
		return list;
	}
	
	public List<Address> findByState(String state)
	{
		Query query = em.createQuery("select a from Address a where a.state like ?1");
		query.setParameter(1, state+"%");
		List<Address> list = query.getResultList();
		return list;
	}
	
	public Address findByAddressId(Integer addressId)
	{
		Address address = em.find(Address.class,addressId);
		return address;
	}
	
	public List<Student> findAllStudent() 
	{
		Query query = em.createQuery("select s from Student s");
		List<Student> list = query.getResultList();
		return list;
	}

	public List<Address> findAllAddress() 
	{
		Query query = em.createQuery("select a from Address a");
		List<Address> list = query.getResultList();
		return list;
	}
}
