package com.at.assessment_java.domain.controller;

import com.at.assessment_java.domain.domain.Funcionario;
import com.at.assessment_java.domain.domain.Material;
import com.at.assessment_java.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;
    @GetMapping()
    public List<Material> getAllMateriais() {
        return materialService.getAll();
    }
    @PostMapping()
    public Material addMaterial(@RequestBody Material material) {
        return materialService.save(material);
    }
    @GetMapping("{id}")
    public Optional<Material> getMaterialById(@PathVariable String id) {
        return materialService.findById(id);
    }
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable String id) {
        materialService.delete(id);
    }
    @PutMapping("{id}")
    public Material updateEmployee(@PathVariable String id, @RequestBody Material material) {
        return materialService.update(id, material);
    }
}
