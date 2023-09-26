package com.ecohero.ecohero.dao;

import com.ecohero.ecohero.common.Common;
import com.ecohero.ecohero.vo.ChallengeVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChallengeDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Scanner sc = new Scanner(System.in);

    // 챌린지 리스트 조회
    public List<ChallengeVO> challengeSelect(){
        List<ChallengeVO> list = new ArrayList<>();
        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement("SELECT CHL_NAME, CHL_ICON, CHL_LEVEL, CHL_DESC, TO_CHAR(CHL_DATE, 'YYYY-MM-DD') AS CHL_DATE, L.POINT\n" +
                    "FROM CHALLENGE C JOIN ECO_LV L ON C.CHL_LEVEL = L.LEVELS");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String chlName = rs.getString("CHL_NAME");
                String chlIcon = rs.getString("CHL_ICON");
                String chlDesc = rs.getString("CHL_DESC");
                String chlDate = rs.getString("CHL_DATE");
                String chlLevel = rs.getString("CHL_LEVEL");
                int chlPoint = rs.getInt("POINT");


                ChallengeVO chlvo = new ChallengeVO(chlName, chlIcon, chlDesc, chlDate, chlLevel, chlPoint);
                list.add(chlvo);
            }
            Common.close(rs);
            Common.close(pstmt);
            Common.close(conn);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // 챌린지 추가하기
    public void chlInsert(ChallengeVO challengeVO){

        String sql = "INSERT INTO CHALLENGE(CHL_NAME, CHL_ICON, CHL_DESC, CHL_DATE, CHL_LEVEL) VALUES(?, ?, ?, sysdate, ?)";
             try {
                conn = Common.getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, challengeVO.getChlName());
                pstmt.setString(2, challengeVO.getChlIcon());
                pstmt.setString(3, challengeVO.getChlDesc());
                pstmt.setString(4, challengeVO.getChlLevel());
                pstmt.executeUpdate();
             } catch (Exception e) {
                 e.printStackTrace();
             }
                Common.close(pstmt);
                Common.close(conn);
    }
}
