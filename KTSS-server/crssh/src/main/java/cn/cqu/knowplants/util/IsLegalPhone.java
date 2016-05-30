package cn.cqu.knowplants.util;

public class IsLegalPhone {
	
	
	public boolean check(String phoneNumber)
	{
		String regex="^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$";   //正则表达式判断
		if(phoneNumber.matches(regex))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	

}
