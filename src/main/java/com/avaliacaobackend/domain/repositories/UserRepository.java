package com.avaliacaobackend.domain.repositories;

import com.avaliacaobackend.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findOptionalByUsername(String username);

    Optional<User> findOptionalByEmail(String email);

    List<User> findAllByDeleted(boolean isDeleted);

    @Query("UPDATE User u SET u.deleted=true where u.id=?1")
    @Modifying
    void softDelete(Long id);

//     others examples for soft delete
//
    @Query("SELECT u FROM User u WHERE u.deleted=false")
    List<User> findAllEnabled();

    List<User> findAllByDeletedIsFalse();
    List<User> findAllByDeletedIsTrue();

    @Query("SELECT u FROM User u WHERE u.deleted=true")
    List<User> findAllDisabled();

}
