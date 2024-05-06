package org.example.Controller;


import org.example.model.SmartphoneEntity;
import org.example.service.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private SmartphoneService smartphoneService;

    @GetMapping("/smartphones")
    public ResponseEntity<List<SmartphoneEntity>> getSmartphonesApi() {
        List<SmartphoneEntity> smartphones = smartphoneService.getAllSmartphones();
        return new ResponseEntity<>(smartphones, HttpStatus.OK);
    }
}
