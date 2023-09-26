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
    private String userAlias;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String joinDate;
    private String heroGrade;
    private int userPoint;
    private int days;

}
