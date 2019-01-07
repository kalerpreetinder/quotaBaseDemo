package interfaces;

import java.util.List;

import models.UpdateVerification;
import models.User;
import models.UserInfo;

public interface DbServices {

	public List<User> getUserList();
	
	public UserInfo getUserInfo(String email);
	
	public int insertUser(User user);
	
	public List<User> checkEmail(String email);
	
	public int updateVerification(UpdateVerification updateVerification, String id);
	
	public boolean isHeaderValid(String authorization, String id);
	
	public String updateToken(String user_id);
	
}
