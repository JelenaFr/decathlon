package com.example.decathlon.controller;

import com.example.decathlon.model.DecathlonMarksRequest;
import com.example.decathlon.service.DecathlonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DecathlonControllerTest {
    private MockMvc mockMvc;
    @Mock
    DecathlonService decathlonService;

    @InjectMocks private DecathlonController decathlonController;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(decathlonController).build();    }

    @Test
    void receiveDecathlonMarks() throws Exception {
        DecathlonMarksRequest pierceLepageMarks = new DecathlonMarksRequest(
                "00:00:10.450",
                7.59,
                15.81,
                2.08,
                "00:00:47.210",
                "00:00:13.770",
                50.98,
                5.20,
                60.90,
                "00:04:39.880");

        mockMvc.perform(post("/decathlon/calculate")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(pierceLepageMarks)))
                .andExpect(status().isOk());
        Mockito.verify(decathlonService).calculate(pierceLepageMarks);
    }
    private static String asJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}