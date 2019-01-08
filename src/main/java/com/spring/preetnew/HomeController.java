package com.spring.preetnew;

import java.net.PasswordAuthentication;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import models.BaseResponse;
import models.CheckVerification;
import models.CheckVerifiedResponse;
import models.Login;
import models.UpdateVerification;
import models.User;
import models.UserInfo;
import models.UserList;

/**
 * Handles requests for the application home page.
 */

// heroku pg:psql --app preettestheroku
// heroku pg:psql --app postgresql-parallel-74754

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	DbServiceImpl dbServiceImpl;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> registerUser(@RequestBody User user) {
		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();
		if (user != null) {

			List<User> userList = dbServiceImpl.checkEmail(user.getEmail());
			if (userList.size() > 0) {
				baseResponse.setSuccess("true");
				baseResponse.setMessage("login sucessfully");

				UserInfo userInfo = dbServiceImpl.getUserInfo(user.getEmail());
				if (userInfo != null) {
					String token = dbServiceImpl.updateToken(userInfo.getUser_id());
					if (token.length() > 0) {
						baseResponse.setToken(token);
					} else {
						baseResponse.setToken(userInfo.getToken());
					}

					baseResponse.setUser_id(userInfo.getUser_id());
				}
				baseResponse.setObject(user);
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200

			} else {
				int res = dbServiceImpl.insertUser(user);
				if (res > 0) {
					UserInfo userInfo = dbServiceImpl.getUserInfo(user.getEmail());
					if (userInfo != null) {
						baseResponse.setToken(userInfo.getToken());
						baseResponse.setUser_id(userInfo.getUser_id());
					}
					baseResponse.setObject(user);
					baseResponse.setSuccess("true");
					baseResponse.setMessage("registered sucessfully");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
				} else {
					baseResponse.setSuccess("false");
					baseResponse.setMessage("not registered");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
				}
			}

		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("Something went wrong");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
		}

		return responseEntity;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> loginUser(@RequestBody Login login) {
		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();
		if (login != null) {
			String pass = "";
			List<User> userList = dbServiceImpl.checkEmail(login.getEmail());
			if (userList.size() > 0) {
				pass = "";

				if (pass.equals(login.getPassword())) {
					baseResponse.setObject(userList.get(0));
					baseResponse.setSuccess("true");
					baseResponse.setMessage("login sucessfully");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
				} else {
					// baseResponse.setObject(userList.get(0));
					baseResponse.setSuccess("false");
					baseResponse.setMessage("password not match ");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
				}
			} else {
				baseResponse.setSuccess("false");
				baseResponse.setMessage("email does not exist");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
			}
		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("Something went wrong");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
		}

		return responseEntity;
	}

	@RequestMapping(value = "/update_verification", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> updateVerification(
			@RequestHeader(value = "Authorization") String authorization, @RequestHeader(value = "id") String id,
			@RequestBody UpdateVerification upadateVerification) {
		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();
		if (upadateVerification != null) {

			boolean headerValid = dbServiceImpl.isHeaderValid(authorization, id);
			if (headerValid) {
				int res = dbServiceImpl.updateVerification(upadateVerification, id);
				if (res > 0) {
					baseResponse.setSuccess("true");
					baseResponse.setMessage("update sucessfully");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
				} else {
					baseResponse.setSuccess("false");
					baseResponse.setMessage("not update");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
				}
			} else {
				baseResponse.setSuccess("false");
				baseResponse.setMessage("invalid request");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.UNAUTHORIZED);// 401
			}

		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("Something went wrong");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
		}

		return responseEntity;
	}

	@RequestMapping(value = "/request_verified", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<CheckVerifiedResponse> requestVerified(
			@RequestHeader(value = "Authorization") String authorization, @RequestHeader(value = "id") String id,
			@RequestBody UpdateVerification upadateVerification) {

		ResponseEntity<CheckVerifiedResponse> responseEntity;
		CheckVerifiedResponse baseResponse = new CheckVerifiedResponse();

		if (upadateVerification != null) {

			boolean headerValid = dbServiceImpl.isHeaderValid(authorization, id);
			if (headerValid) {
				// sendMail();
				baseResponse.setVerified("true");
				baseResponse.setSuccess("true");
				baseResponse.setMessage("verified sucessfully");
				responseEntity = new ResponseEntity<CheckVerifiedResponse>(baseResponse, HttpStatus.OK);// 200

			} else {
				baseResponse.setSuccess("false");
				baseResponse.setMessage("invalid request");
				responseEntity = new ResponseEntity<CheckVerifiedResponse>(baseResponse, HttpStatus.UNAUTHORIZED);// 401
			}

		} else {
			baseResponse.setVerified("false");
			baseResponse.setSuccess("false");
			baseResponse.setMessage("not verified");
			responseEntity = new ResponseEntity<CheckVerifiedResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
		}

		return responseEntity;
	}

	@RequestMapping(value = "/check_verified", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> checkVerified(
			@RequestHeader(value = "Authorization") String authorization, @RequestHeader(value = "id") String id) {

		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();

		boolean headerValid = dbServiceImpl.isHeaderValid(authorization, id);
		if (headerValid) {
			CheckVerification checkVerification = dbServiceImpl.checkVerification(id);
			if (checkVerification != null) {
				baseResponse.setMessage("data fetch sucessfully");
				baseResponse.setSuccess("true");
				baseResponse.setToken(authorization);
				baseResponse.setUser_id(id);
				baseResponse.setObject(checkVerification);
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
			} else {
				baseResponse.setMessage("data not fetch");
				baseResponse.setSuccess("false");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
			}

		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("invalid request");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.UNAUTHORIZED);// 401
		}

		return responseEntity;
	}

	@RequestMapping(value = "/users_list", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> usersList(
			@RequestHeader(value = "Authorization") String authorization, @RequestHeader(value = "id") String id) {

		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();
		
		boolean headerValid = dbServiceImpl.isHeaderValid(authorization, id);
		if (headerValid) {
			List<UserList> usersList = dbServiceImpl.getUserList();
			if (usersList.size() > 0) {
				baseResponse.setMessage("data fetch sucessfully");
				baseResponse.setSuccess("true");
				baseResponse.setToken(authorization);
				baseResponse.setUser_id(id);
				baseResponse.setObject(usersList);
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
			} else {
				baseResponse.setMessage("data not fetch");
				baseResponse.setSuccess("false");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
			}

		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("invalid request");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.UNAUTHORIZED);// 401
		}
		
		return responseEntity;
		
	}
	
	public void sendMail() {
		try {
			final String to = "kalerpreetinder@gmail.com";
			final String from = "preetsumit368@gmail.com";
			String host = "smtp.sparkpostmail.com";
			Properties properties = System.getProperties();
			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
			properties.setProperty("mail.smtp.starttls.enable", "true");
			properties.setProperty("mail.smtp.starttls.required", "true");
			properties.setProperty("mail.smtp.auth", "true");

			// properties.put("mail.smtp.EnableSSL.enable", "true");
			properties.setProperty("mail.smtp.ssl.enable", "false");
			properties.setProperty("mail.smtp.debug", "true");

			// properties.setProperty("mail.smtp.socketFactory.class",
			// "javax.net.ssl.SSLSocketFactory");
			properties.setProperty("mail.smtp.socketFactory.fallback", "true");
			properties.setProperty("mail.port", "587");
			properties.setProperty("mail.smtp.socketFactory.port", "587");
			properties.put("mail.from", from);

			// Get the default Session object.
			Session mailSession = Session.getInstance(properties, new Authenticator() {
				public javax.mail.PasswordAuthentication getPasswordAuthentication() {
					String username = from;
					String password = "preet368@";
					if ((username != null) && (username.length() > 0) && (password != null)
							&& (password.length() > 0)) {

						return new javax.mail.PasswordAuthentication(username, password);
					}
					return null;
				}
			});

			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(mailSession);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: header field
			message.setSubject("WordBoost email verification");
			message.setContent(message, "text/html; charset=utf-8");
			// String link =
			// "http://112.196.64.115:8080/app_wordsprint/change_password_link.jsp?email=" +
			// to;
			StringBuilder bodyText = new StringBuilder();
			bodyText.append("<div>").append("  Dear User<br/><br/>")
					.append("  Your password change request is under process.<br/>")
					.append("  Please click <a href=\""
							+ "\">here</a> or open below link in browser to change password<br/>")
					.append("  <a href=''>Click here to verify</a>").append("  <br/><br/>").append("  Thanks,<br/>")
					.append("  WordBoost Team").append("</div>");

			// message.setText(bodyText.toString());
			message.setContent(bodyText.toString(), "text/html; charset=utf-8");

			MimeBodyPart mimeBodyPart = new MimeBodyPart();
			mimeBodyPart.setContent(bodyText, "text/html");

			MimeMultipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);

			MimeMessage messagep = new MimeMessage(mailSession);
			messagep.setFrom(new InternetAddress(from));
			messagep.setContent(multipart, "text/html; charset=utf-8");
			messagep.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			messagep.setSubject("WordBoost email verification");
			messagep.setContent(bodyText.toString(), "text/html; charset=utf-8");

			Transport.send(messagep);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
