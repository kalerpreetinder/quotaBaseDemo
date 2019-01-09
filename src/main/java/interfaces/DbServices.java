package interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import models.CheckVerification;
import models.MailVerification;
import models.UpdateVerification;
import models.User;
import models.UserInfo;
import models.UserList;

public interface DbServices {

	public List<UserList> getUserList();

	public UserInfo getUserInfo(String email);

	public int insertUser(User user);

	public List<User> checkEmail(String email);

	public int updateVerification(UpdateVerification updateVerification, String id);

	public boolean isHeaderValid(String authorization, String id);

	public String updateToken(String user_id);

	public CheckVerification checkVerification(String user_id);

	public int mailReqVerify(MailVerification mailVerification);

}
