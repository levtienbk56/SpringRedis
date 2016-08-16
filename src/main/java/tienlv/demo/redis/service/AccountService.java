package tienlv.demo.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienlv.demo.redis.model.Account;
import tienlv.demo.redis.repository.AccountDAO;

@Service
public class AccountService {
	@Autowired
	AccountDAO accountDao;

	public void save(Account acc) {
		accountDao.save(acc);
	}

	public void setString(String key, String value) {
		System.out.println("{" + key + ":" + value + "}");
		accountDao.setString(key, value);
	}

	public void setHash(String key, String field, String value) {
		System.out.println("{" + key + ":" + field + ":" + value + "}");
		accountDao.setHash(key, field, value);
	}
}
