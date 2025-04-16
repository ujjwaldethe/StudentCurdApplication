package in.ineuron.dao;

import in.ineuron.dto.Student;

import java.sql.ResultSet;

public interface IstudentDao {
    public String addStudent(Student student);
    public Student searchStudent(Integer id);
    public String updateStudent(Integer sid,String sname,Integer sage,String saddress);
    public String deleteStudent(Integer sid);
    public String showStudents();
}
