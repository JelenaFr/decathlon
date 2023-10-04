package com.example.decathlon.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecathlonMarksRequest {

    public static final String TIME_PATTERN = "^([0-5]?[0-9]):([0-5]?[0-9]):([0-5]?[0-9])\\.([0-9]{3})$";

    public static final String INVALID_TIME_FORMAT = "Invalid time format";

    @Pattern(regexp = TIME_PATTERN, message = INVALID_TIME_FORMAT)
    private String speed100MSeconds;

    @Min(0)
    private double longJumpMeters;

    @Min(0)
    private double shotPutMeters;

    @Min(0)
    private double highJumpMeters;

    @Pattern(regexp = TIME_PATTERN, message = INVALID_TIME_FORMAT)
    private String speed400MSeconds;

    @Pattern(regexp = TIME_PATTERN, message = INVALID_TIME_FORMAT)
    private String hurdles110MSeconds;

    @Min(0)
    private double discThrowMeters;

    @Min(0)
    private double poleVaultMeters;

    @Min(0)
    private double javelinThrowMeters;

    @Pattern(regexp = TIME_PATTERN, message = INVALID_TIME_FORMAT)
    private String speed1500MSeconds;
}
