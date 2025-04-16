package in.ineuron.IStudentService;

import in.ineuron.service.IStudentService;
import in.ineuron.service.StudentServiceImpl;

//Abstraction Logic of Implementation
public class StudentServiceFactory {
    private static IStudentService studentService =null;
    private StudentServiceFactory()
    {

    }
    public static IStudentService getStudentService()
    {
        //Singleton pattern code
        if(studentService==null)
            studentService =  new StudentServiceImpl();
        return studentService ;
    }
}
