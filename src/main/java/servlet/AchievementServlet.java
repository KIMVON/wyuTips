package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.Achievement;
import service.WyuAchievementService;
import service.impl.WyuAchievementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AchievementServlet",urlPatterns = "/achievement")
public class AchievementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //接受值
        String term = request.getParameter("term");
        //获取session值
        String verifyCookie = (String) request.getSession().getAttribute("verifyCookie");


        //处理值
        WyuAchievementService wyuAchievementService = new WyuAchievementServiceImpl();
        List<Achievement> list = wyuAchievementService.getAchievement(term,verifyCookie);

        //存进session中
        request.getSession().setAttribute("achievement",list);

        //返回值
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        response.getWriter().print(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/achievement.jsp").forward(request,response);
    }
}
