package tienlv.demo.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tienlv.demo.redis.model.Account;
import tienlv.demo.redis.repository.AccountDAO;
import tienlv.demo.redis.repository.CommonRedisDataStructureDAO;

@Service
public class MyService {
	@Autowired
	AccountDAO accountDao;
	@Autowired
	CommonRedisDataStructureDAO commonRedisDao;

	public void setAccount(Account acc) {
		System.out.println(acc.toString());
		try {
			accountDao.setAccount(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Account getAccount(String id) {
		Account acc = null;
		try {
			acc = accountDao.getAccount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public void setString(String key, String value) {
		System.out.println("{" + key + ":" + value + "}");
		try {
			commonRedisDao.setString(key, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setHash(String key, String field, String value) {
		System.out.println("{" + key + ":" + field + ":" + value + "}");
		try {
			commonRedisDao.setHash(key, field, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getString(String key) {
		String str = null;
		try {
			str = commonRedisDao.getString(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}

	public void setAccountByte(Account acc) {
		try {
			accountDao.setAccountAsByteArray(acc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Account getAccountByte(String id) {
		Account acc = null;
		try {
			acc = accountDao.getAccountFromByteArray(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return acc;
	}

	public String getHash(String key, String field) {
		String value = null;
		try {
			value = commonRedisDao.getHash(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}
