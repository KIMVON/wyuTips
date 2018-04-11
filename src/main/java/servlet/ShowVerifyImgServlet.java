package servlet;

import service.WyuCourseService;
import service.impl.WyuCourseServiceImpl;
import sun.awt.image.JPEGImageDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet(name = "ShowVerifyImgServlet" , urlPatterns = "/showVerifyImage")
public class ShowVerifyImgServlet extends HttpServlet {
    private static final String JPEG = "image/jpg;charset=GB2312";// 设定输出的类型

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WyuCourseService wyuCourseService = new WyuCourseServiceImpl();
        InputStream inputStream = wyuCourseService.getVerifyCode();

        response.setContentType(JPEG);
        OutputStream out = response.getOutputStream();
        int len;
        byte[] buffer = new byte[8*1024];
        while((len = inputStream.read(buffer,0,buffer.length))!=-1){
            out.write(buffer,0,len);
            out.flush();
        }
        inputStream.close();
        out.close();
    }
}
