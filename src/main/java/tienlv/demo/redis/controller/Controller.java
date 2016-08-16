package tienlv.demo.redis.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tienlv.demo.redis.model.Account;
import tienlv.demo.redis.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping(value = "")
public class Controller {
	@Autowired
	AccountService accountService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		Account acc = new Account("123", "Minh PD", "123@abc");
		accountService.save(acc);
		return "index";
	}

	@RequestMapping(value = "/string", method = RequestMethod.POST)
	public String setString(@RequestParam(name = "key", defaultValue = "") String key, @RequestParam(name = "value", defaultValue = "") String value) {
		if (!key.equals("") && !value.equals("")) {
			accountService.setString(key, value);
		}
		return "index";
	}

	@RequestMapping(value = "/hash", method = RequestMethod.POST)
	public String setHash(@RequestParam(name = "key", defaultValue = "") String key, @RequestParam(name = "field", defaultValue = "") String field, @RequestParam(name = "value", defaultValue = "") String value) {
		if (!key.equals("") && !field.equals("") && !value.equals("")) {
			accountService.setHash(key, field, value);
		}
		return "index";
	}
}
