package com.tornado.mawalltracker.repository;

import com.tornado.mawalltracker.data.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
