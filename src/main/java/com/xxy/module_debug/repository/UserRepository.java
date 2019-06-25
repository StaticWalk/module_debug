package com.xxy.module_debug.repository;

import com.xxy.module_debug.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 * Created by xiongxiaoyu
 * Data:2019/5/30
 * Time:12:04
 */
public interface UserRepository extends MongoRepository<User, Long> {

	Optional<User> findByUsername(String username);

	@Override
	Optional<User> findById(Long id);

	List<Optional<User>> findByGradeLikeAndUsernameLikeOrGradeLikeAndAgeLike(String xx,String x, String y,String yy, Pageable page);
	List<Optional<User>> findByGradeLikeAndUsernameLike(String xx,String x, Pageable page);
	List<Optional<User>> findByGradeLikeAndAgeLike(String xx,String x,  Pageable page);


	@Query(value = "{ username : { $regex : ?0}}")
	List<Optional<User>> getByUsernameRegexQuery(String x);


}