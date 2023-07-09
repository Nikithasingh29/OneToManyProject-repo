package com.nikitha.jpa.presentation;
import java.util.Scanner;

public class StudentApplication 
{
	public static void main(String[] args) 
	{	
		Scanner scanner = new Scanner(System.in);
		StudentUserInterfaceImpl studentUser =  new StudentUserInterfaceImpl();
		Integer option;	
		do
		{
			System.out.println("-------------------------------------");
			System.out.println("         Student Applicaton          ");
			System.out.println("-------------------------------------");		
			System.out.println("Press 1 to add Student Record");		
			System.out.println("Press 2 to update Student Record");
			System.out.println("Press 3 to delete Student Record");
			System.out.println("Press 4 to find By StudentId");
			System.out.println("Press 5 to find By AddressId");
			System.out.println("Press 6 to find By Student Name");
			System.out.println("Press 7 to find By City");
			System.out.println("Press 8 to find By State");
			System.out.println("Press 9 to find all Student Record");
			System.out.println("Press 10 to find all Address Record");
			System.out.println("Press 11 to exit application");
			
			System.out.print("Enter the option : ");
			option = scanner.nextInt();
			switch (option) 
			{
			case 1:
				  	studentUser.inputAddStudent();
				  	break;
			case 2:
			  		studentUser.inputUpdateStudent();
			  		break;
			case 3:
			  		studentUser.inputDeleteStudent();
			  		break;
			case 4:
					studentUser.inputFindByStudentId();
		  			break;
			case 5:
					studentUser.inputFindByAddressId();
					break;
			case 6:
					studentUser.inputFindByName();
					break;
			case 7:
					studentUser.inputFindByCity();
					break;
			case 8:
					studentUser.inputFindByState();
					break;
			case 9:
					studentUser.findAllStudent();
					break;				
			case 10:
					studentUser.findAllAddress();
					break;
			case 11:
					System.out.println("User wants to quit");
					System.exit(0);
			default:
				System.out.println("Invalid option...Enter the option again : ");
			}
		}
		while(option!=11);
	}
}
