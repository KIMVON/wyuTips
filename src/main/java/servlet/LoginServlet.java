package servlet;

import service.WyuCourseService;
import service.impl.WyuCourseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URL;

@WebServlet(name = "LoginServlet" , urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNum");
        String password = request.getParameter("password");
        String verifyCode = request.getParameter("verifyCode");
        String remember = request.getParameter("remember");
        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();

        //获取session值
        HttpSession session = request.getSession();
        String verifyCookie = (String) session.getAttribute("verifyCookie");

        //200成功 201验证码错误 202帐号或者密码错误
        int status = wyuCourseService.imitateLogin(studentNumber,password,verifyCode,verifyCookie);
        switch (status){
            case 200:
                response.sendRedirect("home");//重定向
                //保存帐号密码
                if (remember!=null) {
                    saveInfo(session, studentNumber, password);
                }
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


    private void saveInfo(HttpSession session,String account , String password){
        session.setAttribute("account" , account);
        session.setAttribute("password",password);
        session.setMaxInactiveInterval(-1);
    }
}
