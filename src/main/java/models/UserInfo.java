package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserInfo {

	@JsonProperty("user_id")
	public String user_id;
	
	@JsonProperty("token")
	public String token;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
