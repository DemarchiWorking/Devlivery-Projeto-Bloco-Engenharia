package com.at.assessment_java.service;

import com.at.assessment_java.domain.domain.Departamento;
import com.at.assessment_java.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> getAll(){
        return departamentoRepository.findAll();
    }
    public Departamento save(Departamento departamento){
        return departamentoRepository.save(departamento);
    }
    public Optional<Departamento> getById(@PathVariable Long id){
        return departamentoRepository.findById(id);
    }
    public void deleteById(@PathVariable Long id){
        Departamento departamento = departamentoRepository.findById(id).orElseThrow();
        departamentoRepository.deleteById(id);
    }
    public Departamento updateDepartamento(@PathVariable Long id, Departamento departamentoNovo) {
        return departamentoRepository.findById(id).map(departamento -> {
            departamento.setNome(departamentoNovo.getNome());
            departamento.setLocal(departamentoNovo.getLocal());
            return departamentoRepository.save(departamento);
        }).orElseGet(() -> {
            departamentoNovo.setId(id);
            return departamentoRepository.save(departamentoNovo);
        });

    }
}
