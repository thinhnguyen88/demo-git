/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adj_ticker;

/**
 *
 * @author Hoang Duong
 */
public class Calculate {
    public static void changePrice(Adjust_Spl spl, Adjust_Factor afac) {
        switch (afac.getType()) {
            case 1 : {
                spl.setOpen(spl.getOpen()/afac.getFactor());
                spl.setClose(spl.getClose()/afac.getFactor());
                spl.setVwap(spl.getVwap()/afac.getFactor());
                spl.setHigh(spl.getHigh()/afac.getFactor());
                spl.setLow(spl.getLow()/afac.getFactor());
                break;
            }
            case 2 : {
                spl.setOpen(spl.getOpen()*afac.getFactor());
                spl.setClose(spl.getClose()*afac.getFactor());
                spl.setVwap(spl.getVwap()*afac.getFactor());
                spl.setHigh(spl.getHigh()*afac.getFactor());
                spl.setLow(spl.getLow()*afac.getFactor());
                break;
            }
            case 3 : {
                spl.setOpen(spl.getOpen()+afac.getFactor());
                spl.setClose(spl.getClose()+afac.getFactor());
                spl.setVwap(spl.getVwap()+afac.getFactor());
                spl.setHigh(spl.getHigh()+afac.getFactor());
                spl.setLow(spl.getLow()+afac.getFactor());
                break;
            }
            case 4 : {
                spl.setOpen(spl.getOpen()-afac.getFactor());
                spl.setClose(spl.getClose()-afac.getFactor());
                spl.setVwap(spl.getVwap()-afac.getFactor());
                spl.setHigh(spl.getHigh()-afac.getFactor());
                spl.setLow(spl.getLow()-afac.getFactor());
                break;
            }
            default: {
                System.out.println("Loi Type");
                System.exit(0);
            }
        }
    }
    
    public static void changeVolume(Adjust_Spl spl, Adjust_Factor afac) {
        switch (afac.getType()) {
            case 1 : {
                spl.setTrade_volume(spl.getTrade_volume()*afac.getFactor());
                break;
            }
            case 2 : {
                spl.setTrade_volume(spl.getTrade_volume()/afac.getFactor());
                break;
            }
            case 3 : {
                spl.setTrade_volume(spl.getTrade_volume()-afac.getFactor());
                break;
            }
            case 4 : {
                spl.setTrade_volume(spl.getTrade_volume()+afac.getFactor());
                break;
            }
            default: {
                System.out.println("Loi Type");
                System.exit(0);
            }
        }
        
    }
    
    private static void Calculator(Adjust_Spl spl, Adjust_Factor afac) {
        switch (afac.getFlag()) {
            case 1 : changePrice(spl, afac); break;
            case 2 : changeVolume(spl, afac); break;
            case 3 : changePrice(spl, afac);
                     changeVolume(spl, afac); break;
            default: System.out.println("Loi Flag");
                    System.exit(0);
        }
    }
}
