package service.impl;

import dao.WyuCourseDao;
import pojo.Achievement;
import pojo.SchooolDate;
import service.WyuCourseService;


import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class WyuCourseServiceImpl implements WyuCourseService {

    @Override
    public int imitateLogin(String studentNumber, String password, String verifyCode) {
        WyuCourseDao wyuCourseDao = new WyuCourseDao();
        Map<String, Object> data = new HashMap<>();
        data.put("account", studentNumber);
        data.put("pwd", password);
        data.put("verifycode", verifyCode);

        //发送请求
        int status = wyuCourseDao.imitateLogin(data);
        if (status == 0) {
            return 200;
        }

        return 201;
    }

    @Override
    public Map<String, Object> getCourse(String week) {
        WyuCourseDao wyuCourseDao = new WyuCourseDao();
        Map<String, Object> data = new HashMap<>();
        Calendar calendar = Calendar.getInstance();
        String year = (calendar.get(Calendar.YEAR) - 1) + "";
        int month = calendar.get(Calendar.MONTH);
        String term = (month > 9 || month < 2) ? "01" : "02";
        String termCode = year + term;
        if (week.equals("0")) {
            return wyuCourseDao.getAllCourse(termCode);
        }

        data.put("xnxqdm", termCode);//学期
        data.put("zc", week);//周次
        return wyuCourseDao.getCourse(data);
    }

    @Override
    public Map<String, Object> getNowCourse() {
        Map<String, Object> courseList = getCourse("1");
        SchooolDate schooolDate = (SchooolDate) courseList.get("weekDate");
        String sundayString = schooolDate.getSunday();

        //2018-03-04
        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date firstDate = fmt.parse(sundayString);
            long nowDate = System.currentTimeMillis();
            long betweenMills = nowDate - firstDate.getTime();
            long betweenDays = betweenMills / (1000 * 60 * 60 * 24);
            long nowWeek = (betweenDays / 7) + 1;

            return getCourse(nowWeek + "");

        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Map<String, Object> getAverageAchievement(List<Achievement> list) {
        double sum = 0;
        double creditTotal = 0;
        for (Achievement achievement : list) {
            String achieve = achievement.getAchievement();//绩点
            String credit = achievement.getCredit();//学分

            creditTotal += Double.valueOf(credit);
            sum += Double.valueOf(achieve) * Double.valueOf(credit);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("averageAchievement", sum /= creditTotal);

        return result;
    }

    @Override
    public InputStream getVerifyCode() {
        WyuCourseDao wyuCourseDao = new WyuCourseDao();
        return wyuCourseDao.getVertifyCode();
    }

}
