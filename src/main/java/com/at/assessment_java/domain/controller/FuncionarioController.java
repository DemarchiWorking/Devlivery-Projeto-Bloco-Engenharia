package com.at.assessment_java.domain.controller;

import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.service.FuncionarioService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("funcionario")
public class FuncionarioController {
    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping()
    public List<Funcionario> getEmployees() {
        return funcionarioService.findAll();
    }
    @PostMapping()
    public Funcionario addEmployee(@RequestBody Funcionario funcionario) {
        return funcionarioService.save(funcionario);
    }
    @GetMapping("{id}")
    public Optional<Funcionario> getEmployee(@PathVariable Long id) {
        return funcionarioService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable Long id) {
        funcionarioService.deleteById(id);
    }
    @PutMapping("{id}")
    public Funcionario updateEmployee(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        return funcionarioService.update(id, funcionario);
    }
}
