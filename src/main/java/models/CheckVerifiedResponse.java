package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class CheckVerifiedResponse {

	@JsonProperty("success")
	public String success;
	
	@JsonProperty("message")
	public String message;
	
	@JsonProperty("verified")
	public String verified;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}
	
	
	
}
