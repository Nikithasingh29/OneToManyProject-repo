package com.nikitha.jpa.presentation;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.nikitha.jpa.dao.StudentDaoInterfaceImpl;
import com.nikitha.jpa.model.Address;
import com.nikitha.jpa.model.Student;
import com.nikitha.jpa.validation.StudentValidation;

public class StudentUserInterfaceImpl implements StudentUserInterface
{
	private Integer studentId,addressId,houseNo,pinCode;
	private String firstName,lastName,phoneNo,emailId,addmissionDate,city,state;
	StudentDaoInterfaceImpl studentDao = new StudentDaoInterfaceImpl();
	Scanner scanner = new Scanner(System.in);
	
	public void inputAddStudent()
	{	
		boolean flagFirstName=true;
		boolean flagLastName=true;
		boolean flagEmailId=true;
		boolean flagPhoneNo=true;
		boolean flagAddmissionDate=true;
		boolean flagCity=true;
		boolean flagState=true;
		
		Student student = new Student();
		Address address = new Address();
		while(flagAddmissionDate)
		{
			System.out.print("Enter Addmission Date:");
			addmissionDate=scanner.next();
			if(StudentValidation.validateDate(addmissionDate))
			{
				student.setAddmisionDate(addmissionDate);
				flagAddmissionDate=false;
				while(flagFirstName)
				{
					System.out.print("Enter First Name:");
					firstName=scanner.next();
					if(StudentValidation.validateName(firstName))
					{
						student.setFirstName(firstName);
						flagFirstName=false;
						while(flagLastName)
						{
							System.out.print("Enter Last Name:");
							lastName=scanner.next();
							if(StudentValidation.validateName(lastName))
							{
								student.setLastName(lastName);
								flagLastName=false;							
								while(flagEmailId)
								{
									System.out.print("Enter Email Id:");
									emailId=scanner.next();									
									if(StudentValidation.validateEmailID(emailId))
									{
										student.setEmailId(emailId);
										flagEmailId=false;
										while(flagPhoneNo)
										{
											System.out.print("Enter Contact No:");
											phoneNo=scanner.next();
											if(StudentValidation.validatePhoneNo(phoneNo))
											{
												student.setPhoneNo(phoneNo);
												flagPhoneNo=false;
												while(flagCity)
												{
													System.out.print("Enter City:");
													city=scanner.next();
													if(StudentValidation.validateName(city))
													{
														address.setCity(city);
														flagCity=false;
														while(flagState)
														{
															System.out.print("Enter State:");
															state=scanner.next();
															if(StudentValidation.validateName(state))
															{
																flagState=false;
																System.out.print("Enter HouseNo:");
																houseNo=scanner.nextInt();
																System.out.print("Enter Pincode:");
																pinCode=scanner.nextInt();
																address.setState(state);
																address.setHouseNo(houseNo);
																address.setPincode(pinCode);
																student.setAddress(address);
																System.out.println(studentDao.addStudent(student));
															}
															else
															{
																System.out.println("Enter text value and it should not have more than 10 character");
															}
														 }
													}
													else 
													{
														System.out.println("Enter text value and it should not have more than 10 character");	
													}
												}
											}
											else
											{
											    System.out.println("Enter Valid Phone No ");
											}
										}
									}
									else
									{
										System.out.println("Enter Valid Email Id");
									}
								}
							}
							else
							{
								System.out.println(" Enter text value and it should not have more than 10 character. !!!!!!");
							}
						}
					}
					else
					{
						System.out.println("Enter text value and it should not have more than 10 character. !!!!!!!!!");
					}
				}
			}
			else
			{
				System.out.println("Enter Valid Date in this Format 'MM/DD/YYYY'!!!!!!!");
			}
		}
	}
	
	public void inputUpdateStudent() 	
	{
		boolean flagFirstName=true;
		boolean flagLastName=true;
		boolean flagEmailId=true;
		boolean flagPhoneNo=true;
		boolean flagAddmissionDate=true;
		boolean flagCity=true;
		boolean flagState=true;
		
		Student student = new Student();
		Address address = new Address();
		
		System.out.print("Enter Student Id :");
		studentId = scanner.nextInt();
		if(studentDao.findByStudentId(studentId)!=null)
		{
			student.setStudentId(studentId);
			while(flagAddmissionDate)
			{
				System.out.print("Enter Addmission Date:");
				addmissionDate=scanner.next();
				if(StudentValidation.validateDate(addmissionDate))
				{
				student.setAddmisionDate(addmissionDate);
				flagAddmissionDate=false;
				while(flagFirstName)
				{
					System.out.print("Enter First Name:");
					firstName=scanner.next();
					if(StudentValidation.validateName(firstName))
					{
						student.setFirstName(firstName);
						flagFirstName=false;
						while(flagLastName)
						{
							System.out.print("Enter Last Name:");
							lastName=scanner.next();
							if(StudentValidation.validateName(lastName))
							{
								student.setLastName(lastName);
								flagLastName=false;							
								while(flagEmailId)
								{
									System.out.print("Enter Email Id:");
									emailId=scanner.next();									
									if(StudentValidation.validateEmailID(emailId))
									{
										student.setEmailId(emailId);
										flagEmailId=false;
										while(flagPhoneNo)
										{
											System.out.print("Enter Contact No:");
											phoneNo=scanner.next();
											if(StudentValidation.validatePhoneNo(phoneNo))
											{
												student.setPhoneNo(phoneNo);
												flagPhoneNo=false;
												while(flagCity)
												{
													System.out.print("Enter City:");
													city=scanner.next();
													if(StudentValidation.validateName(city))
													{
														address.setCity(city);
														flagCity=false;
														while(flagState)
														{
															System.out.print("Enter State:");
															state=scanner.next();
															if(StudentValidation.validateName(state))
															{
																address.setState(state);
																flagState=false;
																System.out.print("Enter HouseNo:");
																houseNo=scanner.nextInt();
																System.out.print("Enter Pincode:");
																pinCode=scanner.nextInt();
																address.setHouseNo(houseNo);
																address.setPincode(pinCode);
																student.setAddress(address);
																System.out.println(studentDao.updateStudent(student));
															}
															else
															{
																System.out.println("Enter text value and it should not have more than 10 character");
															}
														 }
													}
													else 
													{
														System.out.println("Enter text value and it should not have more than 10 character");	
													}
												}
											}
											else
											{
											    System.out.println("Enter Valid Phone No ");
											}
										}
									}
									else
									{
										System.out.println("Enter Valid Email Id");
									}
								}
							}
							else
							{
								System.out.println(" Enter text value and it should not have more than 10 character. !!!!!!");
							}
						}
					}
					else
					{
						System.out.println("Enter text value and it should not have more than 10 character. !!!!!!!!!");
					}
				}
			}
			else
			{
				System.out.println("Enter Valid Date in this Format 'YYYY-MM-DD'!!!!!!!");
			}
		}
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}
	
	public void inputDeleteStudent() 
	{
		System.out.print("Enter Student Id :");
		studentId = scanner.nextInt();
		if(studentDao.findByStudentId(studentId)!=null)
		{
			System.out.println(studentDao.deleteStudent(studentId));
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}

	
	public void inputFindByStudentId() 
	{
		System.out.print("Enter Student Id :");
		studentId = scanner.nextInt();
		Student student = studentDao.findByStudentId(studentId);		
		if(student!=null)
		{
			System.out.println("StudentId\tFName\tLName\tAddmissionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(student.getStudentId() + "\t\t" + student.getFirstName() + "\t" +
					student.getLastName() + "\t" + student.getAddmisionDate() + "\t\t" +
					student.getPhoneNo()+"\t" + student.getEmailId() + "\t" + 
					student.getAddress().getHouseNo()+ "\t" + student.getAddress().getCity() + "\t" +
					student.getAddress().getState()+ "\t" + student.getAddress().getPincode());
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}

	public void inputFindByName() 
	{
		System.out.print("Enter Student First Name :");
		firstName = scanner.next();
		List<Student> list = studentDao.findByStudentName(firstName);
		Iterator<Student> itr = list.iterator();
		if(list.size()!=0)
		{
			System.out.println("StudentId\tFName\tLName\tAddmissionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			while(itr.hasNext())
			{
			Student student = itr.next();
			System.out.println(student.getStudentId() + "\t\t" + student.getFirstName() + "\t" +
					student.getLastName() + "\t" + student.getAddmisionDate() + "\t\t" +
					student.getPhoneNo()+"\t" + student.getEmailId() + "\t" + 
					student.getAddress().getHouseNo()+ "\t" + student.getAddress().getCity() + "\t" +
					student.getAddress().getState()+ "\t" + student.getAddress().getPincode());
			}
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}
	
	public void inputFindByCity() 
	{
		System.out.print("Enter City :");
		city = scanner.next();
		List<Address> list = studentDao.findByCity(city);
		Iterator<Address> itr = list.iterator();
		if(list.size()!=0)
		{
			System.out.println("StudentId\tFName\tLName\tAddmissionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			while(itr.hasNext())
			{
			Address address = itr.next();
			System.out.println(address.getStudent().getStudentId() + "\t\t" + address.getStudent().getFirstName() + "\t" + 
					address.getStudent().getLastName() + "\t" + address.getStudent().getAddmisionDate() + "\t\t" + 
					address.getStudent().getPhoneNo() + "\t" + address.getStudent().getEmailId() + "\t" + 
					address.getHouseNo() + "\t"+ address.getCity() + "\t" + address.getState() +  "\t" +
					address.getPincode());
			}
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}
	
	public void inputFindByState() 
	{
		System.out.print("Enter State :");
		state = scanner.next();
		List<Address> list = studentDao.findByState(state);
		Iterator<Address> itr = list.iterator();
		if(list.size()!=0)
		{
			System.out.println("StudentId\tFName\tLName\tAddmissionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");
			while(itr.hasNext())
			{
			Address address = itr.next();
			System.out.println(address.getStudent().getStudentId() + "\t\t" + address.getStudent().getFirstName() + "\t" + 
					address.getStudent().getLastName() + "\t" + address.getStudent().getAddmisionDate() + "\t\t" + 
					address.getStudent().getPhoneNo() + "\t" + address.getStudent().getEmailId() + "\t" + 
					address.getHouseNo() + "\t"+ address.getCity() + "\t" + address.getState() +  "\t" +
					address.getPincode());
			}
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}
	public void inputFindByAddressId() 
	{
		System.out.print("Enter Address Id :");
		addressId = scanner.nextInt();
		Address address = studentDao.findByAddressId(addressId);
		if(address!=null)
		{
			System.out.println("AddressId\tFName\tLName\tAddmisionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");		
			System.out.println("------------------------------------------------------------------------------------------------------------------------------");			
			System.out.println(address.getAddressId() + "\t\t" + address.getStudent().getFirstName() + "\t" + 
					address.getStudent().getLastName() + "\t" + address.getStudent().getAddmisionDate() + "\t\t" + 
					address.getStudent().getPhoneNo() + "\t" + address.getStudent().getEmailId() + "\t" + 
					address.getHouseNo() + "\t"+ address.getCity() + "\t" + address.getState() +  "\t" +
					address.getPincode());
		}
		else
		{
			System.out.println("Record Not Found");
		}
	}
	
	public void findAllStudent() 
	{
		List<Student> list = studentDao.findAllStudent();
		Iterator<Student> itr = list.iterator();
		System.out.println("StudentId\tFName\tLName\tAddmissionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		while(itr.hasNext())
		{
			Student student = itr.next();
			System.out.println(student.getStudentId() + "\t\t" + student.getFirstName() + "\t" +
					student.getLastName() + "\t" + student.getAddmisionDate() + "\t\t" +
					student.getPhoneNo()+"\t" + student.getEmailId() + "\t" + 
					student.getAddress().getHouseNo()+ "\t\t" + student.getAddress().getCity() + "\t\t" +
					student.getAddress().getState()+ "\t" + student.getAddress().getPincode());
		}
	}	
	
	public void findAllAddress() 
	{
		List<Address> list = studentDao.findAllAddress(); 
		Iterator<Address> itr = list.iterator();
		System.out.println("AddressId\tFName\tLName\tAddmisionDate\t\tPhoneNo\t\tMailId\t\tHNo\tCity\tState\tPinCode");		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------");
		while(itr.hasNext())
		{
			Address address = itr.next();
			System.out.println(address.getAddressId() + "\t\t" + address.getStudent().getFirstName() + "\t" + 
					address.getStudent().getLastName() + "\t" + address.getStudent().getAddmisionDate() + "\t\t" + 
					address.getStudent().getPhoneNo() + "\t" + address.getStudent().getEmailId() + "\t" + 
					address.getHouseNo() + "\t"+ address.getCity() + "\t" + address.getState() + "\t" +
					address.getPincode()); 

		}
	}
}
