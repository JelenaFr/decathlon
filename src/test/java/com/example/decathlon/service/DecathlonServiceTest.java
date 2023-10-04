package com.example.decathlon.service;

import com.example.decathlon.model.DecathlonMarksRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DecathlonServiceTest {
    DecathlonMarksRequest pierceLepageMarks= new DecathlonMarksRequest(
            "00:00:10.450",
            7.59,
            15.81,
            2.08,
            "00:00:47.210",
            "00:00:13.770",
            50.98,
            5.20,
            60.90,
            "00:04:39.880"
    );
    DecathlonMarksRequest janekOiglaneMarks  = new DecathlonMarksRequest(
                "00:00:10.940",
                        7.47,
                        15.08,
                        2.02,
                        "00:00:48.410",
                        "00:00:14.510",
                        40.85,
                        5.10,
                        70.45,
                        "00:04:23.430"
    );
    DecathlonService decathlonService= new DecathlonService();

    @Test
    void calculate() {
        assertEquals(8909, decathlonService.calculate(pierceLepageMarks).getTotal());
        assertEquals(8524, decathlonService.calculate(janekOiglaneMarks).getTotal());
    }

    @Test
    void getTimeAsDoubleTest() {
        assertEquals(10.45, decathlonService.getTimeAsDouble("00:00:10.450"));
        assertEquals(279.88, decathlonService.getTimeAsDouble("00:04:39.880"));
    }

    @Test
    void calculate100mScore() {
        assertEquals(987, decathlonService.calculate100mScore(pierceLepageMarks.getSpeed100MSeconds()));
        assertEquals(874, decathlonService.calculate100mScore(janekOiglaneMarks.getSpeed100MSeconds()));
    }

    @Test
    void calculateLongJumpScore() {
        assertEquals(957, decathlonService.calculateLongJumpScore(pierceLepageMarks.getLongJumpMeters()));
        assertEquals(927, decathlonService.calculateLongJumpScore(janekOiglaneMarks.getLongJumpMeters()));
    }

    @Test
    void calculateShotPutScore() {
        assertEquals(840, decathlonService.calculateShotPutScore(pierceLepageMarks.getShotPutMeters()));
        assertEquals(795, decathlonService.calculateShotPutScore(janekOiglaneMarks.getShotPutMeters()));
    }

    @Test
    void calculateHighJumpScore() {
        assertEquals(878, decathlonService.calculateHighJumpScore(pierceLepageMarks.getHighJumpMeters()));
        assertEquals(822, decathlonService.calculateHighJumpScore(janekOiglaneMarks.getHighJumpMeters()));
    }

    @Test
    void calculate400mScore() {
        assertEquals(948, decathlonService.calculate400mScore(pierceLepageMarks.getSpeed400MSeconds()));
        assertEquals(889, decathlonService.calculate400mScore(janekOiglaneMarks.getSpeed400MSeconds()));
    }

    @Test
    void calculate110mHurdlesScore() {
        assertEquals(1004, decathlonService.calculate110mHurdlesScore(pierceLepageMarks.getHurdles110MSeconds()));
        assertEquals(910, decathlonService.calculate110mHurdlesScore(janekOiglaneMarks.getHurdles110MSeconds()));
    }

    @Test
    void calculateDiscThrowScore() {
        assertEquals(891, decathlonService.calculateDiscThrowScore(pierceLepageMarks.getDiscThrowMeters()));
        assertEquals(682, decathlonService.calculateDiscThrowScore(janekOiglaneMarks.getDiscThrowMeters()));
    }

    @Test
    void calculatePoleVaultScore() {
        assertEquals(972, decathlonService.calculatePoleVaultScore(pierceLepageMarks.getPoleVaultMeters()));
        assertEquals(941, decathlonService.calculatePoleVaultScore(janekOiglaneMarks.getPoleVaultMeters()));
    }

    @Test
    void calculateJavelinThrowScore() {
        assertEquals(751, decathlonService.calculateJavelinThrowScore(pierceLepageMarks.getJavelinThrowMeters()));
        assertEquals(896, decathlonService.calculateJavelinThrowScore(janekOiglaneMarks.getJavelinThrowMeters()));
    }

    @Test
    void calculate1500mScore() {
        assertEquals(681, decathlonService.calculate1500mScore(pierceLepageMarks.getSpeed1500MSeconds()));
        assertEquals(788, decathlonService.calculate1500mScore(janekOiglaneMarks.getSpeed1500MSeconds()));
    }
}