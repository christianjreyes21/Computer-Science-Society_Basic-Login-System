package utility;

import model.MemberBean;

public class BeanFactory {
	
	public static MemberBean getFactoryBean(String username, String password, 
		String firstName, String lastName, 
		String gender, String birthdate,
		String email) {
		
		MemberBean member = new MemberBean();
		member.setUsername(username);
		member.setPassword(password);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setGender(gender);
		member.setBirthdate(birthdate);
		member.setEmail(email);
		return member;
	}
}
