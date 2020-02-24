package com.internet.forum.repos;

import com.internet.forum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long>{

    User findByUsername(String username);
}
