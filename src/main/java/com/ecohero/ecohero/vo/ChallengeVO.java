package com.ecohero.ecohero.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor // 모든 인스턴스 필드를 매개변수로 받는 생성자
@NoArgsConstructor // 기본 생성자 생성
public class ChallengeVO {
    private String chlName;
    private String chlIcon;
    private String chlDesc;
    private String date;
    private String chlLevel;
    private int chlPoint;
}
