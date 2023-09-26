package com.ecohero.ecohero.dao;

import com.ecohero.ecohero.common.Common;
import com.ecohero.ecohero.vo.MembersVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MembersInsertDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);


    public void MembersJoin(MembersVO membersVO) {
        String sql = "INSERT INTO MEMBERS(USER_ID, USER_PW, USER_ALIAS, USER_NAME, USER_EMAIL, USER_PHONE) VALUES(?,?,?,?,?,?)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, membersVO.getUserId());
            pstmt.setString(2, membersVO.getUserPw());
            pstmt.setString(3, membersVO.getUserAlias());
            pstmt.setString(4, membersVO.getUserName());
            pstmt.setString(5, membersVO.getUserEmail());
            pstmt.setString(6, membersVO.getUserPhone());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }


}
