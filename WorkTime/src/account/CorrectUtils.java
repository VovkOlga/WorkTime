package account;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorrectUtils {

	public static String errorDataString(String name, String login, String password, String repassword, String email){
		String res="";
		if(!isFilledAllRequiredRows(name, login, password, repassword, email)){
			res=res.concat("Not all required fields are filled! ");
		}
		else{
			if(!isCorrectPassword(password,repassword))
			{
				res=res.concat("Passwords are not equal! ");	
			}
			if(!isCorrectEmail(email))
			{
				res=res.concat("Email is not correct! ");
			}
		}
		
		return res;
	}
	
	public static boolean isCorrectPassword(String passw1, String passw2)
	{
		return passw1.equals(passw2);
	}
	
	public static boolean isCorrectEmail(String email){
		Pattern p = Pattern
				.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.find();
	}
	
	public static boolean isFilledAllRequiredRows(String name, String login, String password, String repassword, String email){
		if(isFieldNotEmptyAndNull(name) && isFieldNotEmptyAndNull(login) && isFieldNotEmptyAndNull(password) && isFieldNotEmptyAndNull(repassword) && isFieldNotEmptyAndNull(email)){
			return true;
		}
		else return false;
	}
	
	public static boolean isFieldNotEmptyAndNull(String field){
		if(field!=null && !field.isEmpty() && !("".equals(field))){
			return true;
		}
		else return false;
	}
}
