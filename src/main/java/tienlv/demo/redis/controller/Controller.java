package tienlv.demo.redis.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import tienlv.demo.redis.model.Account;
import tienlv.demo.redis.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping(value = "")
public class Controller {
	@Autowired
	MyService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home() {
		return "index";
	}

	@RequestMapping(value = "/string", method = RequestMethod.POST)
	public String setString(@RequestParam(name = "key", defaultValue = "") String key, @RequestParam(name = "value", defaultValue = "") String value) {
		if (!key.equals("") && !value.equals("")) {
			service.setString(key, value);
		}
		return "index";
	}

	@RequestMapping(value = "/string", method = RequestMethod.GET)
	public String getString(@RequestParam(name = "key", defaultValue = "") String key, ModelMap model) {
		if (!key.equals("")) {
			String textResult = "Not Found key: " + key;
			String value = service.getString(key);
			if (value != null) {
				textResult = key + ":" + value;
			}
			model.put("type", "String");
			model.put("textResult", textResult);
		}
		return "index";
	}

	@RequestMapping(value = "/hash", method = RequestMethod.POST)
	public String setHash(@RequestParam(name = "key", defaultValue = "") String key, @RequestParam(name = "field", defaultValue = "") String field, @RequestParam(name = "value", defaultValue = "") String value) {
		if (!key.equals("") && !field.equals("") && !value.equals("")) {
			service.setHash(key, field, value);
		}
		return "index";
	}

	@RequestMapping(value = "/hash", method = RequestMethod.GET)
	public String getHash(@RequestParam(name = "key", defaultValue = "") String key, @RequestParam(name = "field", defaultValue = "") String field, ModelMap model) {
		if (!key.equals("") && !field.equals("")) {
			String value = service.getHash(key, field);
			String textResult = "Not Found key: " + key + " & field: " + field;
			if (value != null) {
				textResult = key + ":" + field + ":" + value;
			}
			model.put("type", "Hash");
			model.put("textResult", textResult);
		}
		return "index";
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public String setAccount(@RequestParam(name = "id", defaultValue = "") String id, @RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "password", defaultValue = "") String password) {
		if (!id.equals("") && !name.equals("") && !password.equals("")) {
			service.setAccount(new Account(id, name, password));
		}
		return "index";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String getAccount(@RequestParam(name = "id", defaultValue = "") String id, ModelMap model) {
		if (!id.equals("")) {
			Account acc = service.getAccount(id);
			String textResult = "Not Found " + id;
			if (acc != null) {
				textResult = "id:" + acc.getId() + "<br>name:" + acc.getName() + "<br>password:" + acc.getPassword();
			}
			model.put("type", "Account Object");
			model.addAttribute("textResult", textResult);
		}
		return "index";
	}

	@RequestMapping(value = "/account-byte", method = RequestMethod.POST)
	public String setAccountByte(@RequestParam(name = "id", defaultValue = "") String id, @RequestParam(name = "name", defaultValue = "") String name, @RequestParam(name = "password", defaultValue = "") String password) {
		if (!id.equals("") && !name.equals("") && !password.equals("")) {
			service.setAccountByte(new Account(id, name, password));
		}
		return "index";
	}

	@RequestMapping(value = "/account-byte", method = RequestMethod.GET)
	public String getAccountByte(@RequestParam(name = "id", defaultValue = "") String id, ModelMap model) {
		if (!id.equals("")) {
			Account acc = service.getAccountByte(id);
			String textResult = "Not Found " + id;
			if (acc != null) {
				textResult = "id:" + acc.getId() + "<br>name:" + acc.getName() + "<br>password:" + acc.getPassword();
			}
			model.put("type", "Account Object");
			model.addAttribute("textResult", textResult);
		}
		return "index";
	}
}
