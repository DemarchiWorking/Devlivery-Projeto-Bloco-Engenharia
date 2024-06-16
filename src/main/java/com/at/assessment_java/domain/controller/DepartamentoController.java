package com.at.assessment_java.domain.controller;

import com.at.assessment_java.domain.domain.Departamento;
import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.service.DepartamentoService;
import com.at.assessment_java.service.FuncionarioService;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping()
    public List<Departamento> getDepartamentos() {
        return departamentoService.getAll();
    }
    @PostMapping()
    public Departamento addDepartamento(@RequestBody Departamento departamento) {
        return departamentoService.save(departamento);
    }
    @GetMapping("{id}")
    public Optional<Departamento> getDepartamentoById(@PathVariable Long id) {
        return departamentoService.getById(id);
    }
    @DeleteMapping("{id}")
    public void deleteDepartamentoById(@PathVariable Long id) {
        departamentoService.deleteById(id);
    }
    @PutMapping("{id}")
    public Departamento updateDepartamentoById(@PathVariable Long id, @RequestBody Departamento departamento) {
        return departamentoService.updateDepartamento(id, departamento);
    }

}
