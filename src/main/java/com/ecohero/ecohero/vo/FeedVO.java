package com.ecohero.ecohero.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedVO {
    private String userId;
    private int feedNum;
    private String userAlias;
    private String ecoImg;
    private String chlName;
    private String ecoTxt;
    private int goodNum;

    public FeedVO(int feedNum, String userAlias, String ecoImg, String chlName, String ecoTxt, int goodNum) {
        this.feedNum = feedNum;
        this.userAlias = userAlias;
        this.ecoImg = ecoImg;
        this.chlName = chlName;
        this.ecoTxt = ecoTxt;
        this.goodNum = goodNum;
    }
}
