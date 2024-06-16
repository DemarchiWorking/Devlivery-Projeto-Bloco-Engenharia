package com.at.assessment_java.repositories;

import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<User> findByEmail(String email);

}
