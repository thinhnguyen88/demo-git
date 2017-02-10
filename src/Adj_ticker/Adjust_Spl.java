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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tinh
 */
public class Adjust_Spl {
    private String ticker;
    private Date price_date;
    private float open;
    private float close;
    private float vwap;
    private float trade_volume;
    private float high;
    private float low;
    private byte adjust;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Date getPrice_date() {
        return price_date;
    }

    public void setPrice_date(Date price_date) {
        this.price_date = price_date;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getVwap() {
        return vwap;
    }

    public void setVwap(float vwap) {
        this.vwap = vwap;
    }

    public float getTrade_volume() {
        return trade_volume;
    }

    public void setTrade_volume(float trade_volume) {
        this.trade_volume = trade_volume;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public byte getAdjust() {
        return adjust;
    }

    public void setAdjust(byte adjust) {
        this.adjust = adjust;
    }
    
    public static void xuly(int i) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            // Lay du lieu Factor tu DB

            float count = 0;

            conn = DBConn.getConn();
            pstm = conn.prepareStatement("select * from T_DAILY_TRADING_ADJ_SPL_THINH where rownum = ?");
            pstm.setInt(1, i);
            rs = pstm.executeQuery();
            Adjust_Spl aSpl = new Adjust_Spl();

            while (rs.next()) {
                
                aSpl.setTicker(rs.getString(1));
                aSpl.setPrice_date(rs.getDate(2));
                aSpl.setOpen(rs.getFloat(3));
                aSpl.setClose(rs.getFloat(4));
                aSpl.setVwap(rs.getFloat(5));
                aSpl.setTrade_volume(rs.getInt(6));
                aSpl.setHigh(rs.getFloat(7));
                aSpl.setLow(rs.getFloat(8));
                aSpl.setAdjust(rs.getByte(9));
                
                count++;
            }
            System.out.println(count);
            System.out.println(aSpl.getLow());
            System.out.println(aSpl.getPrice_date());

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
