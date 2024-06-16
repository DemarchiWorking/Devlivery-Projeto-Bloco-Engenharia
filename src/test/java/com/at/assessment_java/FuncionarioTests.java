package com.at.assessment_java;

import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.service.FuncionarioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest

public class FuncionarioTests {

    @Autowired
    FuncionarioService funcionarioService;

    @Test
    @DisplayName("Deve retornar todos os projetos")
    public void testaFindAll(){
        List<Funcionario> funcionarios = funcionarioService.findAll();
        assertEquals(2, funcionarios.size());
    }

    @Test
    @DisplayName("Deve remover um projeto")
    public void testaDelete(){
        funcionarioService.deleteById(112L);
        List<Funcionario> funcionarios = funcionarioService.findAll();
        assertEquals(1, funcionarios.size());
    }

    @Test
    @DisplayName("Deve adicionar um novo projeto")
    public void testaInsert(){
        Funcionario f = new Funcionario();
        f.setNome("Desenvolvimento");
        f.setTelefone("24567323");
        f.setEndereco("Rua A. Bela Vista, 155, Barra, RJ");
        f.setEmail("test@test.com");
        Funcionario funcionario = funcionarioService.save(f);
        List<Funcionario> funcionarios = funcionarioService.findAll();
        assertEquals(2, funcionarios.size());
    }

    @Test
    @DisplayName("Testa o buscar por Id")
    public void testaFindById(){
        Optional<Funcionario> funcionario = funcionarioService.findById(111L);
        assertEquals(funcionario.get().getNome(), "Antonio E. Demarchi");
    }

    @Test
    @DisplayName("Testa o update ")
    public void testaUpdate() {
        Funcionario funcionarioAntes = funcionarioService.findById(111L).get();
        assertEquals(funcionarioAntes.getNome(), "Antonio E. Demarchi");
        funcionarioAntes.setNome("Roberto Santos");

        Funcionario funcionario = funcionarioService.findById(111L).get();
        funcionarioService.save(funcionarioAntes);
        assertEquals(funcionarioAntes.getNome(), "Roberto Santos");

    }
}
