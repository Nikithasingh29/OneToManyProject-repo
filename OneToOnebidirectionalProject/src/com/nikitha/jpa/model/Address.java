package com.nikitha.jpa.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="AIdSeq")
	@SequenceGenerator(sequenceName = "addIdSeq",allocationSize = 10, name="AIdSeq")
	private Integer addressId;
	private Integer houseNo,pincode;
	
	@Column(name="city" , length=20)
	private String city;

	@Column(name="state" , length=20)
	private String state;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy ="address")
	private Student student;
	
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(Integer houseNo) {
		this.houseNo = houseNo;
	}

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}	
}
