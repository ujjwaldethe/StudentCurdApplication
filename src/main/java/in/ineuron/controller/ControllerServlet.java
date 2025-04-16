package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.ineuron.service.IStudentService;
import in.ineuron.IStudentService.StudentServiceFactory;
import in.ineuron.dto.Student;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/controller/*")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request,response);
	}
	public void doProcess(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException
	{
			IStudentService std = StudentServiceFactory.getStudentService();
			System.out.println("Request Method Type : "+req.getMethod());
			PrintWriter out = res.getWriter();	
			res.setContentType("text/html");
			
			if(req.getRequestURI().endsWith("create"))	
			{
				
				String sname = req.getParameter("sname");
				String sage = req.getParameter("sage");
				String saddr = req.getParameter("saddr");
				Student student = new Student();
				student.setName(sname);
				student.setSage(Integer.parseInt(sage));
				student.setSaddress(saddr);
				String status = std.addStudent(student);
				if(status.equalsIgnoreCase("success"))
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Success</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10004;</div>");
					out.println("            <div id='message'>Successfully Submitted! Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
				}
				else
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Failed</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10060;</div>");
					out.println("            <div id='message'>Submission Failed. Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			
			if(req.getRequestURI().endsWith("delete"))	
			{
				String sid = req.getParameter("sid");
				String status = std.deleteStudent(Integer.parseInt(sid));
				if(status.equalsIgnoreCase("success"))
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Success</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10004;</div>");
					out.println("            <div id='message'>Successfully Submitted! Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
				}
				else
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Failed</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10060;</div>");
					out.println("            <div id='message'>Submission Failed. Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			
			if(req.getRequestURI().endsWith("search"))	
			{
				
				String sid = req.getParameter("sid");
				Student student = std.searchStudent(Integer.parseInt(sid));
				if(student!=null)
				{
					  out.println("<html><head><title>Student Data</title><link rel=\"stylesheet\" href=\"../data.css\"></head><body><div class=\"wrapper\"><div class=\"studentData\"><div class=\"div1\">");
					  out.print("<h1>Student Data</h1> </div> <div class=\"div2\">");
                      out.print("<p>Student Name : " + student.getName() + "</p>");
                      out.print("<p>Student ID : " + student.getSid() + "</p>");
                      out.print("<p>Student Age : " + student.getSage() + "</p>");
                      out.print("<p>Student Address : " + student.getSaddress() + "</p></div>");
                      out.println("<div class=\"box-3\"><a href=\"../index.html\" title=\"Go back to the homepage\"><div class=\"btn btn-three\"><span>Go Back</span></div></a></div>");
                      out.println("</body></html>");
				}
				else
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Failed</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10060;</div>");
					out.println("            <div id='message'>No Records Available. Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
				}
			}
			
			if(req.getRequestURI().endsWith("update"))	
			{
				String sid = req.getParameter("sid");
				String sname = req.getParameter("sname");
				Integer sage = Integer.parseInt(req.getParameter("sage"));
				String saddr = req.getParameter("saddr");
				Student student = std.searchStudent(Integer.parseInt(sid));
				if(student!=null)
				{
					if((std.updateStudent(student.getSid(), sname, sage, saddr)).equalsIgnoreCase("success"))
					{
						out.println("<!DOCTYPE html>");
						out.println("<html>");
						out.println("<head>");
						out.println("    <meta charset='UTF-8'>");
						out.println("    <title>Success</title>");
						out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
						out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
						out.println("</head>");
						out.println("<body>");
						out.println("    <div id='container'>");
						out.println("        <div id='message-box'>");
						out.println("            <div id='checkmark'>&#10004;</div>");
						out.println("            <div id='message'>Successfully Submitted! Redirecting...</div>");
						out.println("        </div>");
						out.println("    </div>");
						out.println("</body>");
						out.println("</html>");

					}
					else
					{
						out.println("<!DOCTYPE html>");
						out.println("<html>");
						out.println("<head>");
						out.println("    <meta charset='UTF-8'>");
						out.println("    <title>Failed</title>");
						out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
						out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
						out.println("</head>");
						out.println("<body>");
						out.println("    <div id='container'>");
						out.println("        <div id='message-box'>");
						out.println("            <div id='checkmark'>&#10060;</div>");
						out.println("            <div id='message'>Submission Failed. Redirecting...</div>");
						out.println("        </div>");
						out.println("    </div>");
						out.println("</body>");
						out.println("</html>");

					}
				}
				else
				{
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("<head>");
					out.println("    <meta charset='UTF-8'>");
					out.println("    <title>Failed</title>");
					out.println("    <meta http-equiv='refresh' content='3;url=../index.html'>");
					out.println("    <link rel='stylesheet' type='text/css' href='../success.css'>");
					out.println("</head>");
					out.println("<body>");
					out.println("    <div id='container'>");
					out.println("        <div id='message-box'>");
					out.println("            <div id='checkmark'>&#10060;</div>");
					out.println("            <div id='message'>No Records Available. Redirecting...</div>");
					out.println("        </div>");
					out.println("    </div>");
					out.println("</body>");
					out.println("</html>");
					
				}
			}
			
			
	  }

}
