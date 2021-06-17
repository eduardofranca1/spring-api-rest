package com.avaliacaobackend.domain.repositories;

import com.avaliacaobackend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.email =:email")
//    User findByEmail(@Param("email") String email);

    User findByUserName(String userName);

    Optional<User> findOptionalByEmail(String email);

}
