package interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import models.CheckVerification;
import models.MailVerified;
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

	public int mailReqVerify(String user_id, String verified_by, String quota_attainment_verified, String tracked,
			String average_deal_size_verified, String average_sales_cycle_verified, String year_of_experiance_verified,
			String target_market_verified, String total_sales_2018_verified);

}
