package mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import models.CheckVerification;
import models.UserInfo;

public class CheckVerificationMapper implements RowMapper<CheckVerification> {

	public CheckVerification mapRow(ResultSet rs, int arg1) throws SQLException {

		CheckVerification checkVerification = new CheckVerification();
		checkVerification.setVerified_by(rs.getString("verified_by"));
		checkVerification.setLast_verified(rs.getString("last_verified"));
		checkVerification.setQuota_attainment_verified(rs.getString("quota_attainment_verified"));
		checkVerification.setTracked(rs.getString("tracked"));
		checkVerification.setAverage_deal_size_verified(rs.getString("average_deal_size_verified"));
		checkVerification.setAverage_sales_cycle_verified(rs.getString("average_sales_cycle_verified"));
		checkVerification.setYear_of_experiance_verified(rs.getString("year_of_experiance_verified"));

		return checkVerification;
	}
	
}
