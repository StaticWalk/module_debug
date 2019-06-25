package com.xxy.module_debug.repository;

import com.xxy.module_debug.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/30
 * Time:12:05
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Before
	public void setUp() {
		userRepository.deleteAll();
	}

	@Test
	public void test() throws Exception {

		userRepository.save(new User("22", "张三里", "300","77"));
		userRepository.save(new User("66", "周五六", "300","66"));
		userRepository.save(new User("78", "王奇奇", "六  ","77"));
		userRepository.save(new User("88", "三六六", "300","77"));

		//模糊检索
//		Pageable page = new PageRequest(2,1);
		System.out.println(userRepository.findAll());
		System.out.println("=========================");
		System.out.println(userRepository.findByGradeLikeAndUsernameLikeOrGradeLikeAndAgeLike("77", "","77","六",new PageRequest(0,10)));
		System.out.println("=========================");
		System.out.println(userRepository.findByGradeLikeAndUsernameLike("77", "",new PageRequest(0,10)));
		System.out.println("=========================");
		System.out.println(userRepository.findByGradeLikeAndAgeLike("77","六",new PageRequest(0,10)));

		//分页功能
//		Pageable page = new PageRequest(0,10);
//		Page<User> list = userRepository.findAll(page);
//		System.out.println("查询总页数:"+list.getTotalPages());
//		System.out.println("查询总记录数:"+list.getTotalElements());
//		System.out.println("查询当前第几页:"+list.getNumber()+1);
//		System.out.println("查询当前页面的集合:"+list.getContent());
//		System.out.println("查询当前页面的记录数:"+list.getNumberOfElements());

	}

}