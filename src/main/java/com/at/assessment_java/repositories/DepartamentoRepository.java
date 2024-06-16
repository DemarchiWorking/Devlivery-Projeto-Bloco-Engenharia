package com.at.assessment_java.repositories;

import com.at.assessment_java.domain.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
