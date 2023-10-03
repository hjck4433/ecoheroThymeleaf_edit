package com.ecohero.ecohero.dao;

import com.ecohero.ecohero.common.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    // 로그인 하는 경우 아이디 비밀번호 기준으로 회원 테이블 확인 + 회원정보 수정 시에도 활용
    public boolean checkMember(String userId, String userPw) {
        boolean isMember = false;
        try{
            conn = Common.getConnection();
            String sql = "SELECT COUNT(*) FROM MEMBERS WHERE USER_ID = ? AND USER_PW = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,userId);
            pstmt.setString(2,userPw);
            rs = pstmt.executeQuery();
            if(rs.next()) {
                if(rs.getInt("COUNT(*)") == 1) {
                    isMember = true;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(pstmt);
        Common.close(conn);
        return isMember;
    }

}
