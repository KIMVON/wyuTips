package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Calendar;

@WebServlet(name = "AllAverageAchievementServlet",urlPatterns = "/allAverageAchievementServlet")
public class AllAverageAchievementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        String number = account.substring(2,4);
        int inYear = Integer.valueOf(number);
        Calendar calendar = Calendar.getInstance();
        int nowYear = (calendar.get(Calendar.YEAR) - 1);
    }


}
