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
			User users = dbServiceImpl.getUser(user.getDeviceId());
			if (users == null) {
				int res = dbServiceImpl.insertUser(user);
				if (res > 0) {
					baseResponse.setSuccess("true");
					baseResponse.setMessage("registered");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
				} else {
					baseResponse.setSuccess("false");
					baseResponse.setMessage("not registered");
					responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
				}
			} else {
				int res = dbServiceImpl.updateUser(user);
				baseResponse.setSuccess("true");
				baseResponse.setMessage("registered");
				responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
			}

		} else {
			baseResponse.setSuccess("false");
			baseResponse.setMessage("Something went wrong");
			responseEntity = new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
		}

		return responseEntity;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public List<User> getUser() {
		//ModelAndView modelAndView = new ModelAndView("home");
		List<User> userList = dbServiceImpl.getUserList();
		if (userList.size() > 0) {
			System.out.println(userList.size());
			//modelAndView.addObject("userlist", userList);
		} else {
			//modelAndView.addObject("userMessage", "No user info");
		}
		return userList;
	}

}
