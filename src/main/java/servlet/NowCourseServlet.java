package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Course;
import pojo.SchooolDate;
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

@WebServlet(name = "NowCourseServlet", urlPatterns = "/nowCourse")
public class NowCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();
        Map<String, Object> courseList = wyuCourseService.getNowCourse();
        
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(courseList);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/course.jsp").forward(request, response);
    }
}
