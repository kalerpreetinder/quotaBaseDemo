package com.spring.preetnew;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

import models.Login;
import models.UpdateVerification;
import models.User;
import models.UserInfo;

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
					baseResponse.setToken(userInfo.getToken());
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

//	@RequestMapping(value = Constants.USER_UPDATE_PROFILE_URL, method = RequestMethod.POST, produces = "application/json")
//	public @ResponseBody ResponseEntity<UserResponse> updateUserProfile(
//			@RequestHeader(value = "Authorization") String header, @RequestBody UserRequestDto userRequestDto) {
//		if (userRequestDto == null) {
//			return new ResponseEntity<UserResponse>(HttpStatus.BAD_REQUEST);
//		}
//		HttpHeaders headers = new HttpHeaders();
//		boolean tokenValid = userDao.isTokenValid(header, userRequestDto.getUserId());
//
//		if (!tokenValid) {
//			UserResponse responseObject = new UserResponse(Constants.INVALID_TOKEN, header, "false",
//					Constants.INVALID_TOKEN_CODE);
//			return new ResponseEntity<UserResponse>(responseObject, headers, HttpStatus.UNAUTHORIZED);
//		} else {
//			UserDto userDto = userDao.getUser(userRequestDto.getUserId());
//			if (userDto != null) {
//				userDto = userDao.updateUserProfile(userRequestDto);
//				UserResponse responseObject = new UserResponse(userDto, Constants.PROFILE_UPDATED_SUCCESSFULLY,
//						userDto.getHeaderToken(), "true", Constants.SUCCESS_OK_CODE);
//				return new ResponseEntity<UserResponse>(responseObject, headers, HttpStatus.CREATED);
//			} else {
//				UserResponse responseObject = new UserResponse(userDto, Constants.NO_SUCH_USER_AVAILABLE, header,
//						"false", Constants.INVALID_EMAIL_CODE);
//				return new ResponseEntity<UserResponse>(responseObject, headers, HttpStatus.OK);
//			}
//		}
//	}

}
