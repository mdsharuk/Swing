package model.Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import model.DB.STUDbCon;

import model.TeacherDipti;

public class TEADao {

    static STUDbCon con;
    static String sql;
    static PreparedStatement ps;
    static ResultSet rs;

    public TEADao(STUDbCon con) {
        this.con = con;
    }

    public static int save(TeacherDipti s) throws NamingException, SQLException {
        int status = 0;

        sql = "insert into teacherdipti(Name,Email,Cell,Gender,Subject) values(?,?,?,?,?)";
        ps = con.getCon().getConnection().prepareStatement(sql);
        ps.setString(1, s.getName());
        ps.setString(2, s.getEmail());
        ps.setString(3, s.getCell());
        ps.setString(4, s.getGender());
        ps.setString(5, s.getSubject());

        status = ps.executeUpdate();

        return status;
    }
     public static ArrayList<TeacherDipti>sList() throws NamingException, SQLException{
        ArrayList<TeacherDipti>list=new ArrayList<TeacherDipti>();
        sql="select * from teacherdipti";
        ps=con.getCon().getConnection().prepareStatement(sql);
        rs=ps.executeQuery();
        while(rs.next()){
           TeacherDipti s=new TeacherDipti(rs.getInt("id"), 
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
     public static TeacherDipti getById(int id) throws NamingException, SQLException{
      TeacherDipti s =null;
      sql="select * from teacherdipti where id=?";
      ps=con.getCon().getConnection().prepareStatement(sql);
      ps.setInt(1, id);
      rs=ps.executeQuery();
       while(rs.next()){
          s=new TeacherDipti(
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
      public  static int Delete(TeacherDipti s) throws NamingException, SQLException{
      int status=0;
      sql="delete from  teacherdipti where id=?";
      ps=con.getCon().getConnection().prepareStatement(sql);
      ps.setInt(1, s.getId());
      status=ps.executeUpdate();
        return status;
  }
       public static int update(TeacherDipti s) throws NamingException, SQLException{
      int status=0;
      sql="update teacherdipti set Name=?,Email=?,Cell=?,Gender=?,Subject=? where id=?";
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