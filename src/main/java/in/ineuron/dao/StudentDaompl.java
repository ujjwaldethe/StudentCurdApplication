package in.ineuron.dao;

import in.ineuron.JDBC.JDBCStandardApp2;
import in.ineuron.dto.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Persistance Logic USing JDBC API
public class StudentDaompl implements IstudentDao{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    @Override
    public String showStudents()
    {
        String sqlQuery = "Select * from Students";
        try {
            conn = JDBCStandardApp2.getJDBCConnection();
            if (conn!=null)
            {
                ps = conn.prepareStatement(sqlQuery);
            }
            if (ps!=null)
            {
                rs = ps.executeQuery();
                if (rs!=null)
                {
                    System.out.println("\tId\tName\tAge\tAddress");
                    while (rs.next())
                    {
                        System.out.println("\t"+rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getString(4));
                    }
                    return "success";
                }
                else {
                    return "Not Found";
                }
            }
        }catch (Exception e) {
            throw new RuntimeException();
        }
        return "Failed";
    }
    @Override
    public String addStudent(Student student) {
        try {
            conn = JDBCStandardApp2.getJDBCConnection();
            String sqlInsertQuery  = "Insert into students (`name`,`age`,`address`) values (?,?,?)";
            if(conn!=null)
            {
                ps = conn.prepareStatement(sqlInsertQuery);
            }
            if(ps!=null)
            {
                ps.setString(1,student.getName());
                ps.setInt(2,student.getSage());
                ps.setString(3,student.getSaddress());

                int rowAffected= ps.executeUpdate();
                if(rowAffected==1)
                {
                    return "Success";
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "Failed";
    }

    @Override
    public Student searchStudent(Integer id) {
        try {
            conn = JDBCStandardApp2.getJDBCConnection();
            String sqlInsertQuery  = "select id,name, age, address from students where id=? ";
            if(conn!=null)
            {
                ps = conn.prepareStatement(sqlInsertQuery);
            }
            if(ps!=null)
            {
                ps.setInt(1,id);
                rs = ps.executeQuery();
            }
            if(rs!=null)
            {
                Student s ;
                if(rs.next())
                {
                    s = new Student();
                    s.setSid(rs.getInt(1));
                    s.setName(rs.getString(2));
                    s.setSage(rs.getInt(3));
                    s.setSaddress(rs.getString(4));
                    return s;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

       return null;
    }
    @Override
    public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {
        try {
            conn = JDBCStandardApp2.getJDBCConnection();
            String sqlInsertQuery  = "update students set name=? ,age=?,address=? where id=?";
            if(conn!=null)
            {
                ps = conn.prepareStatement(sqlInsertQuery);
            }
            if(ps!=null)
            {
                ps.setString(1,sname);
                ps.setInt(2,sage);
                ps.setString(3,saddress);
                ps.setInt(4,sid);

                int rowAffected = ps.executeUpdate();
                if(rowAffected==1)
                {
                    return "success";
                }
                else {
                    return "not found";
                }
            }
        }catch (Exception e)
        {
            throw new RuntimeException();
        }
        return "Failed";
    }

    @Override
    public String deleteStudent(Integer sid) {

        try {
            conn = JDBCStandardApp2.getJDBCConnection();
            String sqlInsertQuery  = "delete from students where id=?";
            if(conn!=null)
            {
                ps = conn.prepareStatement(sqlInsertQuery);
            }
            if(ps!=null)
            {
                ps.setInt(1,sid);
                int rowAffected= ps.executeUpdate();
                if(rowAffected==1)
                {
                    return "Success";
                }
                else {
                    return "not found";
                }
            }
        }catch (Exception e)
        {
            throw new RuntimeException();
        }
       return "Failed";
    }

}
