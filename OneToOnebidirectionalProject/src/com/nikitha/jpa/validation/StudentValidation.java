package com.nikitha.jpa.validation;

import java.util.regex.Pattern;

public class StudentValidation 
{
	public static boolean validateName(String name)
	{
		boolean flag=false;
		if(name.length()<=10)
		{
			char arr[]=name.toCharArray();
			for(int i=0;i<arr.length;i++)
			{
				if((arr[i]>=65 && arr[i]<=90) || (arr[i]>=97 && arr[i]<=122))
					flag=true;
			}			
		}
		return flag;
	}

	public static Boolean validateEmailID(String emailId)
	{
		String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\."+
							"[a-zA-Z0-9_+&*-]+)*@"+
							"(?:[a-zA-Z0-9]+\\.)+[a-z"+
							"A-Z]{2,7}$";
		Pattern pattern=Pattern.compile(emailRegex);
		if(emailId!=null)
				return pattern.matcher(emailId).matches();
		else
			return false;
	}
	
	
	public static Boolean validatePhoneNo(String phoneNo)
	{
		String phoneNoRegex="(0/91)?[6-9][0-9]{9}";
		Pattern pattern=Pattern.compile(phoneNoRegex);
		if(phoneNo!=null)
				return pattern.matcher(phoneNo).matches();
		else
			return false;
	}
	
	public static Boolean validateDate(String date)
	{
		String dateRegex="^((19|2[0-9])[0-9]{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
		String currentDate = java.time.LocalDate.now().toString();
		System.out.println(currentDate+" "+date);
		if(date.matches(dateRegex)&& date.compareTo(currentDate)==0)
		{
			return true;
		}
		else
			return false;
	}	
}
