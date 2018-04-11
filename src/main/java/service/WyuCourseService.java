package service;

import pojo.Achievement;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface WyuCourseService {
    Map<String,Object> getVerifyCode();

    int imitateLogin(String studentNumber, String password, String verifyCode, String verifyCookie);

    Map<String, Object> getCourse(String week, String verifyCookie);

    Map<String,Object> getNowCourse(String verifyCookie);

    Map<String,Object> getAverageAchievement(List<Achievement> list);
}
