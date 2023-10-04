package com.example.decathlon.controller;

import com.example.decathlon.model.DecathlonMarksRequest;
import com.example.decathlon.model.DecathlonPointsResponse;
import com.example.decathlon.service.DecathlonService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DecathlonController {
    private final DecathlonService decathlonService;

    @PostMapping("/decathlon/calculate")
    public DecathlonPointsResponse receiveDecathlonMarks(@Valid @RequestBody DecathlonMarksRequest decathlonMarksRequest) {
        return decathlonService.calculate(decathlonMarksRequest);
    }
}
