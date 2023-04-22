
package model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.DB.STUDbCon;
import model.StudentDipti;


public class STUDao {

    static STUDbCon con;
    static String sql;
    static PreparedStatement ps;
    static ResultSet rs;

    public STUDao(STUDbCon con) {
        this.con = con;
    }
    
    public static int save(StudentDipti s) throws NamingException, SQLException{
        int status=0;
        
        sql="insert into studentdipti(Name,Email,Cell,Gender,Subject) values(?,?,?,?,?)";
        ps=con.getCon().getConnection().prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCell());
        ps.setString(4, s.getGender());
        ps.setString(5, s.getSubject());
        
        status=ps.executeUpdate();
        
        
       return status;
    }
    
  public static ArrayList sList() throws NamingException, SQLException{
      ArrayList<StudentDipti>list=new ArrayList<StudentDipti>();
      StudentDipti s;
      sql="select * from studentdipti";
      ps=con.getCon().getConnection().prepareStatement(sql);
      rs=ps.executeQuery();
      while(rs.next()){
          s=new StudentDipti(
                              rs.getInt("id"),
                              rs.getString("Name"),
                              rs.getString("Email"),
                              rs.getString("Cell"),
                              rs.getString("Gender"),
                              rs.getString("Subject")
          );
          list.add(s);
      }
        return list;
  }
  public static StudentDipti getById(int id) throws NamingException, SQLException{
      StudentDipti s =null;
      sql="select * from studentdipti where id=?";
      ps=con.getCon().getConnection().prepareStatement(sql);
      ps.setInt(1, id);
      rs=ps.executeQuery();
       while(rs.next()){
          s=new StudentDipti(
                              rs.getInt("id"),
                              rs.getString("Name"),
                              rs.getString("Email"),
                              rs.getString("Cell"),
                              rs.getString("Gender"),
                              rs.getString("Subject")
          );
          
      }
        return s;
        
  }
  public  static int Delete(StudentDipti s) throws NamingException, SQLException{
      int status=0;
      sql="delete from studentdipti where id=?";
      ps=con.getCon().getConnection().prepareStatement(sql);
      ps.setInt(1, s.getId());
      status=ps.executeUpdate();
        return status;
  }
  public static int update(StudentDipti s) throws NamingException, SQLException{
      int status=0;
      sql="update studentdipti set Name=?,Email=?,Cell=?,Gender=?,Subject=? where id=?";
      ps=con.getCon().getConnection().prepareStatement(sql);
       ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCell());
        ps.setString(4, s.getGender());
        ps.setString(5, s.getSubject());
        ps.setInt(6, s.getId());
        
        
        status=ps.executeUpdate();
        
        return status;
}
}