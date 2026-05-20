package Secure.Invoice.Processing.System.demo.Secure.Invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Secure.Invoice.Processing.System.demo.Secure.Invoice.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}