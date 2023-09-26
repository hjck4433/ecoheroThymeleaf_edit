package com.ecohero.ecohero.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChallengeVO {
    private String chlName;
    private String chlIcon;
    private String chlDesc;
    private String date;
    private String chlLevel;
    private int chlPoint;
}
