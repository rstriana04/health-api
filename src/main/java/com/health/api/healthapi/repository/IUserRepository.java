package com.health.api.healthapi.repository;

import com.health.api.healthapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = false)
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String name);

    Optional<User> findByEmail(String email);

    Optional<User> findByAccessToken(String accessToken);

    @Override
    Optional<User> findById(Long aLong);

    Boolean existsByUsername(String name);

    Boolean existsByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE User u SET u.accessToken = :accessToken WHERE u.id = :userId")
    int updateToken(@Param("userId") Long id, @Param("accessToken") String accessToken);
}
