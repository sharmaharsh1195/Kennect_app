package com.wellfound.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wellfound.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	
	public User findByname(String name);

//	@Query("select u from User u where u.name =:username")
//	public User findByName(@Param("username") String username);
}
