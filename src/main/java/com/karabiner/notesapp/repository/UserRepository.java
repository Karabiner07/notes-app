package com.karabiner.notesapp.repository;

import com.karabiner.notesapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findUserByUserId(Long userId);

    public boolean existsUserByUserName(String userName);
    public boolean existsUserByUserPass (String userPass);

    public boolean existsUserByUserId(Long userId);


    public User findUserByUserName(String userName);
}
