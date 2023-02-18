/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ItemDTO;
import Utils.MyConection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author minhv
 */
public class ItemDAO {
    public static ArrayList getItemData() {
        ArrayList<ItemDTO> itemList=new ArrayList<>();
        try {
            Connection cn= MyConection.makeConnection();
            if(cn!=null){
                String sql = "select itemCode,itemName,i.supCode,s.supName,unit,price,supplying\n" +
                             "from tblItems i, tblSuppliers s\n" +
                             "where i.supCode=s.supCode";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    ItemDTO item=new ItemDTO(rs.getString("itemCode"), rs.getString("itemName"), rs.getString("unit"),
                            rs.getFloat("price"), rs.getInt("supplying"), rs.getString("supCode")+"-"+rs.getString("supName"));
                    itemList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemList;
    }
    
    public static int insertItem(String itemCode, String itemName, String unit, float price, int supplying, String supplier) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="insert tblItems\n" +
                       "values(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, itemCode);
            pst.setString(2, itemName);
            pst.setString(3, unit);
            pst.setFloat(4, price);
            pst.setInt(5, supplying);
            pst.setString(6, supplier);
            
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int updateItem(String itemCode, String itemName, String unit, float price, int supplying, String supplier) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="update tblItems\n" +
                       "set itemName=?,unit=?,price=?,supplying=?,supCode=?\n" +
                       "where itemCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);      
            pst.setString(1, itemName);
            pst.setString(2, unit);
            pst.setFloat(3, price);
            pst.setInt(4, supplying);
            pst.setString(5, supplier);
            pst.setString(6, itemCode);
            
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int deleteItem(String itemCode) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="delete from tblItems\n" +
                       "where itemCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);      
            pst.setString(1, itemCode);
            
            result=pst.executeUpdate();
        }
        return result;
    }
    
}
