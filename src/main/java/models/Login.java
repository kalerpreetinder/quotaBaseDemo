package models;

import org.codehaus.jackson.annotate.JsonProperty;

public class Login {

	@JsonProperty("email")
	public String email;

	@JsonProperty("password")
	public String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
