package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.WyuCourseDao;
import pojo.Achievement;
import service.WyuAchievementService;
import service.WyuCourseService;
import service.impl.WyuAchievementServiceImpl;
import service.impl.WyuCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CalculateAchievementServlet", urlPatterns = "/calculateAchievement")
public class CalculateAchievementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String term = request.getParameter("term");
        List<Achievement> list = (List<Achievement>) request.getSession().getAttribute("achievement");
        if (list==null){
            //获取session值
            String verifyCookie = (String) request.getSession().getAttribute("verifyCookie");
            //处理值
            WyuAchievementService wyuAchievementService = new WyuAchievementServiceImpl();
            list = wyuAchievementService.getAchievement(term,verifyCookie);
        }

        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();
        Map<String, Object> result = wyuCourseService.getAverageAchievement(list);

        //返回值
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
