package com.example.decathlon.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DecathlonPointsResponse {

    private int speed100MSeconds;
    private int longJumpMeters;
    private int shotPutMeters;
    private int highJumpMeters;
    private int speed400MSeconds;
    private int hurdles110MSeconds;
    private int discThrowMeters;
    private int poleVaultMeters;
    private int javelinThrowMeters;
    private int speed1500MSeconds;

    public int getTotal() {
        return speed100MSeconds +
                longJumpMeters +
                shotPutMeters +
                highJumpMeters +
                speed400MSeconds +
                hurdles110MSeconds +
                discThrowMeters +
                poleVaultMeters +
                javelinThrowMeters +
                speed1500MSeconds;
    }
}
