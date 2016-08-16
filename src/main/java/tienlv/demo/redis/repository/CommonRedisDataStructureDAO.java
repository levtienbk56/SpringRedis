package tienlv.demo.redis.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommonRedisDataStructureDAO {

	/* use web.xml config */
	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	public void setString(String key, String value) throws Exception {
		stringRedisTemplate.opsForValue().set(key, value);
	}

	public void setHash(String key, String field, String value) throws Exception {
		stringRedisTemplate.opsForHash().put(key, field, value);
	}

	public String getString(String key) throws Exception {
		return stringRedisTemplate.opsForValue().get(key);
	}

	public String getHash(String key, String field) throws Exception {
		return (String) stringRedisTemplate.opsForHash().get(key, field);
	}
}
