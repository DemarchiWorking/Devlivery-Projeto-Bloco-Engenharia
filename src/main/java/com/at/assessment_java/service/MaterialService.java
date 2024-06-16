package com.at.assessment_java.service;

import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.domain.domain.Material;
import com.at.assessment_java.repositories.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materialRepository;

    public List<Material> getAll() {
        return materialRepository.findAll();
    }
    public Material save(Material material) {
        return materialRepository.save(material);
    }
    public void delete(String id) {
        Material material = materialRepository.findById(id).orElseThrow();
        materialRepository.deleteById(id);
    }
    public Optional<Material> findById(String id){
        return materialRepository.findById(id);
    }
    public Material update(String id, Material materialNovo) {
        return materialRepository.findById(id).map(material -> {
            material.setNome(materialNovo.getNome());
            material.setQuantidade(materialNovo.getQuantidade());
            material.setDescricao(materialNovo.getDescricao());
            return materialRepository.save(material);
        }).orElseGet(() -> {
            materialNovo.setId(id);
            return materialRepository.save(materialNovo);
        });
    }
}
