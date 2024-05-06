package org.example.repository;

import org.example.model.SmartphoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<SmartphoneEntity, Long> {
}
