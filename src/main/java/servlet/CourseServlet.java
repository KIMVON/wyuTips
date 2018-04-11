package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Course;
import service.WyuCourseService;
import service.impl.WyuCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CourseServlet", urlPatterns = "/course")
public class CourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String week = request.getParameter("week");
        //获取session值
        String verifyCookie = (String) request.getSession().getAttribute("verifyCookie");

        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();
        Map<String, Object> courseList = wyuCourseService.getCourse(week,verifyCookie);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(courseList);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/course.jsp").forward(request, response);
    }
}
