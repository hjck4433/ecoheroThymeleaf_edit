package com.ecohero.ecohero.dao;

import com.ecohero.ecohero.common.Common;
import com.ecohero.ecohero.vo.MembersVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;



public class MembersSelectDAO {

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public List<MembersVO> selectMembersInfo(){
        List<MembersVO> mvl = new ArrayList<>();
        try{
            conn = Common.getConnection();
            String sql = "SELECT USER_ID, USER_ALIAS, USER_NAME, HERO_EMAIL, USER_PHONE, TO_CHAR(JOIN_DATE, 'YYYY-MM-DD') JOIN_DATE, HERO_GRADE, USER_POINT, TRUNC(SYSDATE - JOIN_DATE) DAYS\n" +
                    "FROM MEMBERS M JOIN GRADE G\n" +
                    "ON M.USER_POINT BETWEEN G.LO_POINT AND G.HI_POINT;\n";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                 String userId = rs.getNString("USER_ID");
                 String userAlias = rs.getNString("USER_ALIAS");
                 String userName = rs.getNString("USER_NAME");
                 String userEmail = rs.getNString("HERO_EMAIL");
                 String userPhone = rs.getNString("USER_PHONE");
                 String joinDate = rs.getNString("JOIN_DATE");
                 String heroGrade = rs.getString("HERO_GRADE");
                 int userPoint = rs.getInt("USER_POINT");
                 int days = rs.getInt("DAYS");

                mvl.add(new MembersVO(userId,userAlias,userName,userEmail,userPhone,joinDate,heroGrade,userPoint,days));

            }
            Common.close(rs);
            Common.close(pstmt);
            Common.close(conn);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return mvl;
    }




}