package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class CheckVerification {
	
	@JsonProperty("verified_by")
	public String verified_by;
	
	@JsonProperty("last_verified")
	public String last_verified;
	
	@JsonProperty("quota_attainment_verified")
	public String quota_attainment_verified;
	
	@JsonProperty("tracked")
	public String tracked;
	
	@JsonProperty("average_deal_size_verified")
	public String average_deal_size_verified;
	
	@JsonProperty("average_sales_cycle_verified")
	public String average_sales_cycle_verified;
	
	@JsonProperty("year_of_experiance_verified")
	public String year_of_experiance_verified;

	
	
	public String getVerified_by() {
		return verified_by;
	}

	public void setVerified_by(String verified_by) {
		this.verified_by = verified_by;
	}

	public String getLast_verified() {
		return last_verified;
	}

	public void setLast_verified(String last_verified) {
		this.last_verified = last_verified;
	}

	public String getQuota_attainment_verified() {
		return quota_attainment_verified;
	}

	public void setQuota_attainment_verified(String quota_attainment_verified) {
		this.quota_attainment_verified = quota_attainment_verified;
	}

	public String getTracked() {
		return tracked;
	}

	public void setTracked(String tracked) {
		this.tracked = tracked;
	}

	public String getAverage_deal_size_verified() {
		return average_deal_size_verified;
	}

	public void setAverage_deal_size_verified(String average_deal_size_verified) {
		this.average_deal_size_verified = average_deal_size_verified;
	}

	public String getAverage_sales_cycle_verified() {
		return average_sales_cycle_verified;
	}

	public void setAverage_sales_cycle_verified(String average_sales_cycle_verified) {
		this.average_sales_cycle_verified = average_sales_cycle_verified;
	}

	public String getYear_of_experiance_verified() {
		return year_of_experiance_verified;
	}

	public void setYear_of_experiance_verified(String year_of_experiance_verified) {
		this.year_of_experiance_verified = year_of_experiance_verified;
	}
	

}
