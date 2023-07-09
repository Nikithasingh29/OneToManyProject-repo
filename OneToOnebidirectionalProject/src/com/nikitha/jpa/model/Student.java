package com.nikitha.jpa.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="IdSeq")
	@SequenceGenerator(sequenceName = "stuIdSeq",allocationSize = 1, name="IdSeq")
	private Integer studentId;
	
	@Column(name="fname" , length=10)
	private String firstName;
	
	@Column(name="lname" , length=10)
	private String lastName;
	
	@Column(name="addDate" , length=10)
	private String addmisionDate;
	
	@Column(name="mailId" , length=30)
	private String emailId;
	
	@Column(name="phoneNo", length=10)
	private String phoneNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId")
	private Address address;
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddmisionDate() {
		return addmisionDate;
	}

	public void setAddmisionDate(String addmisionDate) {
		this.addmisionDate = addmisionDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
