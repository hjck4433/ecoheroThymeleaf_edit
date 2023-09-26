package com.ecohero.ecohero.dao;

import com.ecohero.ecohero.common.Common;
import com.ecohero.ecohero.vo.FeedVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FeedDAO {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    public String getUserAlias(String userId) {
        String userAlias = "";
        try{
            conn = Common.getConnection();
            String sql = "SELECT USER_ALIAS FROM MEMBERS WHERE USER_ID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();

            if(rs.next()) {
                userAlias = rs.getString("USER_ALIAS");
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        Common.close(rs);
        Common.close(pstmt);
        Common.close(conn);

        return userAlias;
    }
    public List<FeedVO> feedSelect() {
        List<FeedVO> fvl = new ArrayList<>();
        try{
            conn = Common.getConnection();
            String sql = "SELECT FEED_NUM, USER_ID, ECO_IMG, CHL_NAME, ECO_TXT, (SELECT COUNT(*) FROM GOOD G WHERE F.FEED_NUM = G.FEED_NUM) GOOD_NUM FROM FEED F";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                int feedNum = rs.getInt("FEED_NUM");
                String userId = rs.getString("USER_ID");
                String ecoImg = rs.getString("ECO_IMG");
                String chlName = rs.getString("CHL_NAME");
                String ecoTxt = rs.getString("ECO_TXT");
                int goodNum = rs.getInt("GOOD_NUM");


                //String userAlias = getUserAlias(userId);

                fvl.add(new FeedVO(feedNum, userId, ecoImg, chlName, ecoTxt, goodNum));
            }
            Common.close(rs);
            Common.close(pstmt);
            Common.close(conn);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return fvl;
    }

    public void insertFeed(FeedVO feedVO) {
        String sql = "INSERT INTO FEED (FEED_NUM, USER_ID, ECO_IMG, CHL_NAME, ECO_TXT)\n" +
                "    VALUES(FEED_NUM_SEQ.NEXTVAL,?, ?, ?, ?)";

        try {
            conn = Common.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, feedVO.getUserId());
            pstmt.setString(2, feedVO.getEcoImg());
            pstmt.setString(3, feedVO.getChlName());
            pstmt.setString(4, feedVO.getEcoTxt());
            pstmt.executeUpdate();


        } catch (Exception e) {
            e.printStackTrace();
        }
        Common.close(pstmt);
        Common.close(conn);
    }



}
