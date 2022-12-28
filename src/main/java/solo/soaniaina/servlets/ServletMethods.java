package solo.soaniaina.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import solo.soaniaina.dao.StudentDAO;
import solo.soaniaina.models.Student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletMethods {

    public final static Logger LOGGER = LogManager.getLogger(ServletMethods.class);

    public static void listAllStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> studentList = StudentDAO.findAll();

        request.setAttribute("studentList", studentList);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/studentList.jsp").forward(request, response);
    }

    public static void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/studentForm.jsp").forward(request, response);
    }

    public static void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = StudentDAO.findById(id);
        request.setAttribute("student", existingStudent);
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/studentForm.jsp").forward(request, response);
    }

    public static void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Student student = getStudentFromRequest(request);
        new StudentDAO().save(student);
//        rédirection vers /list
        response.sendRedirect("list");
    }

    public static void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = getStudentFromRequest(request);
        student.setId(id);
        new StudentDAO().update(student);
        response.sendRedirect("list");
    }

    public static void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentDAO.remove(id);
        response.sendRedirect("list");
    }

    private static Student getStudentFromRequest(HttpServletRequest request) {

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String telephone = request.getParameter("telephone");
        String matricule = request.getParameter("matricule");
        String email = request.getParameter("email");
        String niveau = request.getParameter("niveau");
        String mention = request.getParameter("mention");

        return Student.builder().firstname(firstname).lastname(lastname).address(address)
                .telephone(telephone).matricule(matricule).email(email).niveau(niveau).mention(mention).build();
    }

}
