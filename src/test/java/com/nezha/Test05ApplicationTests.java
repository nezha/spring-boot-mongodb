package com.nezha;

import com.nezha.domain.User;
import com.nezha.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test05ApplicationTests{
	@Autowired
	private UserRepository userRepository;

	@Test
	public void test() {
		userRepository.deleteAll();
		// 创建三个User，并验证User总数
		userRepository.save(new User("didi", 30));
		userRepository.save(new User("mama", 40));
		userRepository.save(new User("kaka", 50));
		Assert.assertEquals(3, userRepository.findAll().size());

		// 删除一个User，再验证User总数
		User u = userRepository.findByUsername("didi");
        System.out.println(u.toString());
		userRepository.delete(u);
		Assert.assertEquals(2, userRepository.findAll().size());
	}

}
