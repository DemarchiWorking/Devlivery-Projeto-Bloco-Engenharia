package com.at.assessment_java.repositories;

import com.at.assessment_java.domain.domain.Material;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MaterialRepository extends MongoRepository<Material, String> {

}
