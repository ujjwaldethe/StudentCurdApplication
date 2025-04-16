package in.ineuron.daofactory;

import in.ineuron.dao.IstudentDao;
import in.ineuron.dao.StudentDaompl;

public class StudentDaoFactory {
    private static IstudentDao studentDao = null;
    private StudentDaoFactory() {
    }
    public static IstudentDao getStudentDao()
    {
        if(studentDao==null)
            studentDao = new StudentDaompl();
        return studentDao;
    }
}
