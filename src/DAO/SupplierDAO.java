/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.SupplierDTO;
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
public class SupplierDAO {
    public static ArrayList getSupplierData() {
        ArrayList<SupplierDTO> supList=new ArrayList<>();
        try {
            Connection cn= MyConection.makeConnection();
            if(cn!=null){
                String sql = "select supCode,supName,address,collaborating\n" +
                             "from tblSuppliers";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while (rs.next()){
                    SupplierDTO sup=new SupplierDTO(rs.getString("supCode"), rs.getString("supName"),rs.getString("address"), rs.getInt("collaborating"));
                    supList.add(sup);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supList;
    }
    
    public static int insertSupplier(String supCode, String supName, String address, int collaborating) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="insert tblSuppliers\n" +
                       "values(?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, supCode);
            pst.setString(2, supName);
            pst.setString(3, address);
            pst.setInt(4, collaborating);
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int updateSupplier(String supCode, String supName, String address, int collaborating) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="update tblSuppliers\n" +
                       "set supName=?,address=?,collaborating=?\n" +
                       "where supCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);         
            pst.setString(1, supName);
            pst.setString(2, address);
            pst.setInt(3, collaborating);
            pst.setString(4, supCode);
            
            result=pst.executeUpdate();
        }
        return result;
    }
    
    public static int deleteSupplier(String supCode) throws SQLException {
        Connection cn=MyConection.makeConnection();
        int result = 0;
        if(cn!=null){
            String sql="delete from tblSuppliers\n" +
                       "where supCode=?";
            PreparedStatement pst=cn.prepareStatement(sql);         
            pst.setString(1, supCode);
     
            result=pst.executeUpdate();
        }
        return result;
    }
}
