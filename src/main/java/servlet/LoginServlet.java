package servlet;

import service.WyuCourseService;
import service.impl.WyuCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNum");
        String password = request.getParameter("password");
        String verifyCode = request.getParameter("verifyCode");
        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();

        //获取session值
        String verifyCookie = (String) request.getSession().getAttribute("verifyCookie");

        //200成功 201验证码错误 202帐号或者密码错误
        int status = wyuCourseService.imitateLogin(studentNumber,password,verifyCode,verifyCookie);
        switch (status){
            case 200:
                response.sendRedirect("home");//重定向
                break;
            case 201:
                response.sendRedirect("login");
                break;
            case 202:
                response.sendRedirect("login");
                break;
            default:
                response.sendRedirect("login");
                break;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(request,response);
    }
}
