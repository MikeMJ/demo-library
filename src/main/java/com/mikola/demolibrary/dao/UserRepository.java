package com.mikola.demolibrary.dao;

import com.mikola.demolibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Mikola on  Sep 08, 2018
 */

public interface UserRepository extends JpaRepository<User,Long> {
}
