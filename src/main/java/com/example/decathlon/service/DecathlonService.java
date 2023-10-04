package com.example.decathlon.service;


import com.example.decathlon.model.ScoringCoefficient;
import com.example.decathlon.model.DecathlonMarksRequest;
import com.example.decathlon.model.DecathlonPointsResponse;
import org.springframework.stereotype.Service;


@Service
public class DecathlonService {

    public DecathlonPointsResponse calculate(DecathlonMarksRequest decathlonMarksRequest) {

        return DecathlonPointsResponse.builder()
                .speed100MSeconds(calculate100mScore(decathlonMarksRequest.getSpeed100MSeconds()))
                .longJumpMeters(calculateLongJumpScore(decathlonMarksRequest.getLongJumpMeters()))
                .shotPutMeters(calculateShotPutScore(decathlonMarksRequest.getShotPutMeters()))
                .highJumpMeters(calculateHighJumpScore(decathlonMarksRequest.getHighJumpMeters()))
                .speed400MSeconds(calculate400mScore(decathlonMarksRequest.getSpeed400MSeconds()))
                .hurdles110MSeconds(calculate110mHurdlesScore(decathlonMarksRequest.getHurdles110MSeconds()))
                .discThrowMeters(calculateDiscThrowScore(decathlonMarksRequest.getDiscThrowMeters()))
                .poleVaultMeters(calculatePoleVaultScore(decathlonMarksRequest.getPoleVaultMeters()))
                .javelinThrowMeters(calculateJavelinThrowScore(decathlonMarksRequest.getJavelinThrowMeters()))
                .speed1500MSeconds(calculate1500mScore(decathlonMarksRequest.getSpeed1500MSeconds()))
                .build();
    }

    public double getTimeAsDouble(String timeStr) {
        String[] timeComponents = timeStr.split(":");
        String[] secondsAndMillis = timeComponents[2].split("\\.");
        return Integer.parseInt(timeComponents[0]) * 3600 + Integer.parseInt(timeComponents[1]) * 60 + Integer.parseInt(secondsAndMillis[0]) + Integer.parseInt(secondsAndMillis[1]) / 1000.0;
    }

    private int calculateScores(double A, double B, double C, double result) {
        if (result == 0.0) {
            return 0;
        } else {
            return (int) (A * Math.pow(Math.abs(B - result), C));
        }
    }

    public int calculate100mScore(String timeStr) {
        return calculateScores(ScoringCoefficient.A_100_M, ScoringCoefficient.B_100_M, ScoringCoefficient.C_100_M, getTimeAsDouble(timeStr));
    }

    public int calculateLongJumpScore(double longJumpMeters) {
        return calculateScores(ScoringCoefficient.A_LONG_JUMP, ScoringCoefficient.B_LONG_JUMP, ScoringCoefficient.C_LONG_JUMP, longJumpMeters);
    }

    public int calculateShotPutScore(double shotPutMeters) {
        return calculateScores(ScoringCoefficient.A_SHOT_PUT, ScoringCoefficient.B_SHOT_PUT, ScoringCoefficient.C_SHOT_PUT, shotPutMeters);
    }

    public int calculateHighJumpScore(double highJumpMeters) {
        return (calculateScores(ScoringCoefficient.A_HIGH_JUMP, ScoringCoefficient.B_HIGH_JUMP, ScoringCoefficient.C_HIGH_JUMP, highJumpMeters));
    }

    public int calculate400mScore(String timeStr) {
        return calculateScores(ScoringCoefficient.A_400_M, ScoringCoefficient.B_400_M, ScoringCoefficient.C_400_M, getTimeAsDouble(timeStr));
    }

    public int calculate110mHurdlesScore(String timeStr) {
        return calculateScores(ScoringCoefficient.A_110_M_HARDLES, ScoringCoefficient.B_110_M_HARDLES, ScoringCoefficient.C_110_M_HARDLES, getTimeAsDouble(timeStr));
    }

    public int calculateDiscThrowScore(double discThrowMeters) {
        return calculateScores(ScoringCoefficient.A_DISC_THROW, ScoringCoefficient.B_DISC_THROW, ScoringCoefficient.C_DISC_THROW, discThrowMeters);
    }

    public int calculatePoleVaultScore(double poleVaultMeters) {
        return calculateScores(ScoringCoefficient.A_POLE_VAULT, ScoringCoefficient.B_POLE_VAULT, ScoringCoefficient.C_POLE_VAULT, poleVaultMeters);
    }

    public int calculateJavelinThrowScore(double javelinThrowDistanceMeters) {
        return calculateScores(ScoringCoefficient.A_JAVELIN_THROW, ScoringCoefficient.B_JAVELIN_THROW, ScoringCoefficient.C_JAVELIN_THROW, javelinThrowDistanceMeters);
    }

    public int calculate1500mScore(String timeStr) {
        return calculateScores(ScoringCoefficient.A_1500_M, ScoringCoefficient.B_1500_M, ScoringCoefficient.C_1500_M, getTimeAsDouble(timeStr));
    }
}
