package tienlv.demo.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import tienlv.demo.redis.model.Account;

@Repository
public class AccountDAO {
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	// public AccountDAO() {
	// ApplicationContext context = new
	// ClassPathXmlApplicationContext("redis-config.xml");
	// this.redisTemplate = (StringRedisTemplate)
	// context.getBean("stringRedisTemplate");
	// }

	public void save(Account acc) {
		stringRedisTemplate.opsForValue().set("spring", "like suck");
	}

	public void setString(String key, String value) {
		stringRedisTemplate.opsForValue().set(key, value);
	}

	public void setHash(String key, String field, String value) {
		stringRedisTemplate.opsForHash().put(key, field, value);
	}

}
