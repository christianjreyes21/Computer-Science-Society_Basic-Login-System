package utility.sql;

public interface SQLCommands {

	String INSERT_MEMBER = "insert into MEMBERS(USERNAME, PASSWORD, FIRSTNAME, LASTNAME, GENDER, BIRTHDATE, EMAIL) values(?,?,?,?,?,?,?)";
	String RETRIEVE_MEMBER = "select * from MEMBERS where USERNAME=?";
	
}
