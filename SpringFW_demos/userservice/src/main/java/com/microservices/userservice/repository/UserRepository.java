    package com.microservices.userservice.repository;

    import com.microservices.userservice.model.User;
    import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepository extends JpaRepository<User, Long> {
    }
