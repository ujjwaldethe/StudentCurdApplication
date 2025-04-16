package in.ineuron.service;
import in.ineuron.dao.IstudentDao;
import in.ineuron.dto.Student;
import in.ineuron.daofactory.StudentDaoFactory;
import in.ineuron.dto.Student;
//Service Layer Logic
public class StudentServiceImpl implements IStudentService{
    IstudentDao stdService=null;
    @Override
    public String addStudent(Student student) {
        stdService = StudentDaoFactory.getStudentDao();
        if(stdService!=null)
            return stdService.addStudent(student);
        else
            return "Failed";
    }

    @Override
    public Student searchStudent(Integer id) {
        stdService = StudentDaoFactory.getStudentDao();
        return stdService.searchStudent(id);
    }

    @Override
    public String updateStudent(Integer sid, String sname, Integer sage, String saddress) {

        stdService = StudentDaoFactory.getStudentDao();
        return stdService.updateStudent(sid,sname,sage,saddress);
    }
    @Override
    public String deleteStudent(Integer sid) {
        stdService = StudentDaoFactory.getStudentDao();
        return stdService.deleteStudent(sid);
    }
    @Override
    public String showStudents()
    {
        stdService = StudentDaoFactory.getStudentDao();
        return stdService.showStudents();
    }
}
