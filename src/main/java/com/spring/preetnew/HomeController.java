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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
				baseResponse.setSuccess("false");
				baseResponse.setMessage("email already exist");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.ALREADY_REPORTED);// 208
			} else {
				int res = dbServiceImpl.insertUser(user);
				if (res > 0) {
					baseResponse.setObject(user);
					baseResponse.setSuccess("true");
					baseResponse.setMessage("registered");
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
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 401
		}

		return responseEntity;
	}

	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public ModelAndView getUser() {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		String username = System.getenv("JDBC_DATABASE_USERNAME");
		String password = System.getenv("JDBC_DATABASE_PASSWORD");

		String data = dbUrl + " , " + username + " , " + password;
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("serverTime", data);
		return modelAndView;
	}
	

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<BaseResponse> loginUser(@RequestBody User user) {
		ResponseEntity<BaseResponse> responseEntity;
		BaseResponse baseResponse = new BaseResponse();
		if (user != null) {

			List<User> userList = dbServiceImpl.checkEmail(user.getEmail());
			if (userList.size() > 0) {
				String pass = userList.get(0).getPassword();

				if (pass.equals(user.getPassword())) {
					baseResponse.setObject(userList.get(0));
					baseResponse.setSuccess("true");
					baseResponse.setMessage("login sucessfully");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);// 200
				} else {
					baseResponse.setObject(userList.get(0));
					baseResponse.setSuccess("false");
					baseResponse.setMessage("password not match");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NO_CONTENT);// 204
				}
			} else {
				baseResponse.setSuccess("false");
				baseResponse.setMessage("email does not exist");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 400
			}
		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("Something went wrong");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.BAD_REQUEST);// 401
		}
                         
		return responseEntity;
	}

}
