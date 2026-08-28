package com.example.springconstructorinjection.repository;

import com.example.springconstructorinjection.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {

        users.add(
                new User(
                        1L,
                        "Rahul",
                        "rahul@gmail.com"
                )
        );

        users.add(
                new User(
                        2L,
                        "John",
                        "john@gmail.com"
                )
        );
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Long id) {

        for (User user : users) {

            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }

    public User save(User user) {

        users.add(user);

        return user;
    }

    public void deleteById(Long id) {

        users.removeIf(
                user -> user.getId().equals(id)
        );
    }
}
