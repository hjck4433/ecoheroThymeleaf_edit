package com.ecohero.ecohero.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MembersVO {

    private String userId;
    private String userPw;
    private String userAlias;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String joinDate;
    private String heroGrade;
    private int userPoint;
    private int days;

    public MembersVO(String userId, String userAlias, String userName, String userEmail, String userPhone, String joinDate, String heroGrade, int userPoint, int days) {
        this.userId = userId;
        this.userAlias = userAlias;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.joinDate = joinDate;
        this.heroGrade = heroGrade;
        this.userPoint = userPoint;
        this.days = days;
    }
}
