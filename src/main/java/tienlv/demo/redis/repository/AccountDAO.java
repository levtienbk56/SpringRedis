package tienlv.demo.redis.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import tienlv.demo.redis.model.Account;

/**
 * RedisTemplate will save data in ByteArray type. when you want to save an
 * object instance, this object need to implements Serializable class.
 * 
 * StringRedisTemplate save data in plantext type. when you want to save an
 * object instance, design that object use hash structure.
 * 
 * @author tienlv
 *
 */
@Repository
public class AccountDAO {
	/* use web.xml config */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	/* use extend xml config /resources/redis-config.xml */
//	public AccountDAO() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("redis-config.xml");
//		this.redisTemplate = (StringRedisTemplate) context.getBean("stringRedisTemplate");
//	}

	/**
	 * transform object instance into hash. see {@link StringRedisTemplate}
	 * 
	 * @param acc
	 *            account instance
	 * @throws Exception
	 */
	public void setAccount(Account acc) throws Exception {
		String key = String.format("account:%s", acc.getId());
		Map<String, String> properties = new HashMap<String, String>();

		properties.put("id", acc.getId());
		properties.put("name", acc.getName());
		properties.put("password", acc.getPassword());

		stringRedisTemplate.opsForHash().putAll(key, properties);
	}

	/**
	 * Redis save object instance as byte array. see {@link RedisTemplate}
	 * 
	 * @param acc
	 * @throws Exception
	 */
	public void setAccountAsByteArray(Account acc) throws Exception {
		String key = String.format("account:%s", acc.getId());
		redisTemplate.opsForValue().set(key, acc);
	}

	/**
	 * get from hash value. see {@link StringRedisTemplate}
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Account getAccount(String id) throws Exception {
		Account acc = null;
		String key = String.format("account:%s", id);
		Object name = stringRedisTemplate.opsForHash().get(key, "name");
		Object password = stringRedisTemplate.opsForHash().get(key, "password");

		if (name != null && password != (null)) {
			acc = new Account(id, (String) name, (String) password);
		}
		return acc;
	}

	/**
	 * see {@link RedisTemplate}
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public Account getAccountFromByteArray(String id) throws Exception {
		String key = String.format("account:%s", id);
		return (Account) redisTemplate.opsForValue().get(key);
	}

}
