import entity.Teacher;
import repository.TeacherRepository;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/teachers", name = "TeachersServlet")
public class TeachersServlet extends HttpServlet {

    private final TeacherRepository teacherRepository = new TeacherRepository();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final List<Teacher> list = teacherRepository.getList();

        request.setAttribute("teachers", list);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }


}
