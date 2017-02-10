/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Adj_ticker;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tinh
 */
public class Adjust_Factor {
    private int id;
    private String ticker;
    private Date date;
    private float factor;
    private byte type;
    private byte flag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getFactor() {
        return factor;
    }

    public void setFactor(float factor) {
        this.factor = factor;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }
    
    public static void nhap() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            // Lay du lieu Factor tu DB

            ArrayList<Adjust_Factor> listFactor = new ArrayList<Adjust_Factor>();
            int count = 0;

            conn = DBConn.getConn();
            pstm = conn.prepareStatement("select * from T_DVD_ADJUST_FACTOR_THINH");
            rs = pstm.executeQuery();

            while (rs.next()) {
                Adjust_Factor aFac = new Adjust_Factor();
                aFac.setId(rs.getInt(1));
                aFac.setTicker(rs.getString(2));
                aFac.setDate(rs.getDate(3));
                aFac.setFactor(rs.getFloat(4));
                aFac.setType(rs.getByte(5));
                aFac.setFlag(rs.getByte(6));
                listFactor.add(aFac);
                count++;
            }
            System.out.println(count);
            
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                DBConn.closeAll(conn, pstm, rs);
            } catch (Exception e) {
            }
        }
    }
}
