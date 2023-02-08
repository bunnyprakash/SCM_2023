package com.example.demo.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Signup;
@Repository
public interface SignupRepository extends  MongoRepository<Signup, String> {

	Signup findByEmail(String email);
	boolean existsByEmail(String email);
}
