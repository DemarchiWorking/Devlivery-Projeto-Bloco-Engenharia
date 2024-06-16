package com.at.assessment_java.service;

import com.at.assessment_java.domain.domain.Departamento;
import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }
    public Funcionario save(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
    public Optional<Funcionario> findById(Long id){
        return funcionarioRepository.findById(id);
    }
    public void deleteById(Long id){
        funcionarioRepository.findById(id).orElseThrow();
        funcionarioRepository.deleteById(id);
    }
    public Funcionario update(Long id, Funcionario funcionarioNovo) {
        return funcionarioRepository.findById(id).map(funcionario -> {
            funcionario.setNome(funcionarioNovo.getNome());
            funcionario.setEmail(funcionarioNovo.getEmail());
            funcionario.setTelefone(funcionarioNovo.getTelefone());
            funcionario.setNascimento(funcionarioNovo.getNascimento());
            funcionario.setEndereco(funcionarioNovo.getEndereco());
            return funcionarioRepository.save(funcionario);
        }).orElseGet(() -> {
            funcionarioNovo.setId(id);
            return funcionarioRepository.save(funcionarioNovo);
        });
    }
}
