package org.example.service;

import org.example.model.SmartphoneEntity;
import org.example.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    @Autowired
    private SmartphoneRepository smartphoneRepository;

    @Override
    public List<SmartphoneEntity> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }
}
