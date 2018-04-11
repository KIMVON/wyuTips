package service;

import pojo.Achievement;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface WyuCourseService {
    InputStream getVerifyCode();

    int imitateLogin(String studentNumber, String password, String verifyCode);

    Map<String, Object> getCourse(String week);

    Map<String,Object> getNowCourse();

    Map<String,Object> getAverageAchievement(List<Achievement> list);
}
