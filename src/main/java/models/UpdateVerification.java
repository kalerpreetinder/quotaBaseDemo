package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class UpdateVerification {
	
//	 CREATE TABLE update_verification(id serial PRIMARY KEY, user_id varchar(20), verified varchar(20),
//	 quota_attainment varchar(200), tracked varchar(200), average_deal_size varchar(200),   
//	 average_sales_cycle varchar(200), target_market varchar(200), years_of_experiance varchar(200),
//	 team_manager varchar(200), team_manager_company_email varchar(200), your_company_email varchar(200),
//	 total_sales varchar(200));

	@JsonProperty("quota_attainment")
	public String quota_attainment;
	
	@JsonProperty("tracked")
	public String tracked;
	
	@JsonProperty("average_deal_size")
	public String average_deal_size;
	
	@JsonProperty("average_sales_cycle")
	public String average_sales_cycle;
	
	@JsonProperty("target_market")
	public String target_market;
	
	@JsonProperty("years_of_experiance")
	public String years_of_experiance;
	
	@JsonProperty("team_manager")
	public String team_manager;
	
	@JsonProperty("team_manager_company_email")
	public String team_manager_company_email;
	
	@JsonProperty("your_company_email")
	public String your_company_email;
	
	@JsonProperty("total_sales")
	public String total_sales;

	
	
	public String getQuota_attainment() {
		return quota_attainment;
	}

	public void setQuota_attainment(String quota_attainment) {
		this.quota_attainment = quota_attainment;
	}

	public String getTracked() {
		return tracked;
	}

	public void setTracked(String tracked) {
		this.tracked = tracked;
	}

	public String getAverage_deal_size() {
		return average_deal_size;
	}

	public void setAverage_deal_size(String average_deal_size) {
		this.average_deal_size = average_deal_size;
	}

	public String getAverage_sales_cycle() {
		return average_sales_cycle;
	}

	public void setAverage_sales_cycle(String average_sales_cycle) {
		this.average_sales_cycle = average_sales_cycle;
	}

	public String getTarget_market() {
		return target_market;
	}

	public void setTarget_market(String target_market) {
		this.target_market = target_market;
	}

	public String getYears_of_experiance() {
		return years_of_experiance;
	}

	public void setYears_of_experiance(String years_of_experiance) {
		this.years_of_experiance = years_of_experiance;
	}

	public String getTeam_manager() {
		return team_manager;
	}

	public void setTeam_manager(String team_manager) {
		this.team_manager = team_manager;
	}

	public String getTeam_manager_company_email() {
		return team_manager_company_email;
	}

	public void setTeam_manager_company_email(String team_manager_company_email) {
		this.team_manager_company_email = team_manager_company_email;
	}

	public String getYour_company_email() {
		return your_company_email;
	}

	public void setYour_company_email(String your_company_email) {
		this.your_company_email = your_company_email;
	}

	public String getTotal_sales() {
		return total_sales;
	}

	public void setTotal_sales(String total_sales) {
		this.total_sales = total_sales;
	}
	
	

}
