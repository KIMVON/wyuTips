package dao;


import org.json.JSONArray;
import org.json.JSONObject;
import pojo.Achievement;
import pojo.Course;
import pojo.SchooolDate;
import util.HttpUtil;
import util.FormatUtil;

import java.io.*;
import java.net.*;
import java.util.*;

import static java.lang.System.*;

//http://www.cnblogs.com/chenyangqi/p/4906376.html
public class WyuCourseDao {
    private static String loginUrl;
    private static String vertifyCodeUrl;
    private static String courseBaseUrl;
    private static String courseAchievementUrl;
    private static String cookie;

    static {
        InputStream inputStream = WyuCourseDao.class.getClassLoader().getResourceAsStream("url.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            loginUrl = properties.getProperty("wyu.loginUrl");
            vertifyCodeUrl = properties.getProperty("wyu.login.verifycodeUrl");
            courseAchievementUrl = properties.getProperty("wyu.course.achievement");
            courseBaseUrl = properties.getProperty("wyu.course.baseUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public InputStream getVertifyCode() {
        HttpURLConnection urlConnection;
        try {
            vertifyCodeUrl = vertifyCodeUrl + "?d=" + currentTimeMillis();
            URL url = new URL(vertifyCodeUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();

            cookie = HttpUtil.getCookie(urlConnection, "Set-Cookie");
            return inputStream;
//            byte[] buffer = new byte[1024 * 8];
//            int len;
//            FileOutputStream fileOutputStream = new FileOutputStream(new File("/home/kim/IJ_Project/test3/a.jpg"));
////            while ((len = inputStream.read(buffer, 0, buffer.length)) != -1) {
//                fileOutputStream.write(buffer, 0, len);
//            }
////            cookie = getCookie(urlConnection);
//            System.out.println(cookie);
//            return cookie;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public int imitateLogin(Map<String, Object> data) {
        try {
            URL url = new URL(loginUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
            urlConnection.setRequestProperty("Cookie", cookie);

            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            urlConnection.connect();

            //提交    "account=3115002516&pwd=wyu790691685&verifycode=" + code
            String d = FormatUtil.buildPostData(data);
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
            out.print(d);
            out.flush();

            //获取返回
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append("\n");
                result.append(line);
            }
            System.out.println(result);

            JSONObject jsonObject = new JSONObject(result.toString());
            return jsonObject.getInt("code");
            //登录失败
//            if (status != 0) {
//
//            }

//            return cookie;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }


    public Map<String, Object> getCourse(Map<String, Object> params) {
        URL url;
        try {
            url = new URL(FormatUtil.buildUrl(courseBaseUrl, params));

            URLConnection urlConnection = url.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
            urlConnection.setRequestProperty("Cookie", cookie);
            urlConnection.connect();

            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append("\n");
                result.append(line);
            }

            return convertJsonToObjForCourse(result.toString(), (String) params.get("zc"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public Map<String, Object> getAllCourse(String term) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xnxqdm", term);//选择学期
        return getCourse(params);
    }


    public List<Achievement> getAchievement(String term) {
        try {
            URL url = new URL(courseAchievementUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // 设置通用的请求属性
            urlConnection.setRequestProperty("accept", "*/*");
            urlConnection.setRequestProperty("connection", "Keep-Alive");
            urlConnection.setRequestProperty("user-agent",
                    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.119 Safari/537.36");
            urlConnection.setRequestProperty("Cookie", cookie);
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            urlConnection.connect();

            //"xnxqdm=201701&page=1&rows=20&sort=xnxqdm&order=asc"
            Map<String, Object> data = new HashMap<String, Object>();
            data.put("xnxqdm", term);
            data.put("page", 1);
            data.put("rows", 20);
            data.put("sort", "xnxqdm");
            data.put("order", "asc");
            String param = FormatUtil.buildPostData(data);
            //提交
            PrintWriter out = new PrintWriter(urlConnection.getOutputStream());
            out.print(param);
            out.flush();

            //获取返回
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(inputStream));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                result.append(line);
            }

//            JSONObject jsonObject = new JSONObject(result.toString());
//            int status = jsonObject.getInt("code");
//            //登录失败
//            if (status!=0){
//
//            }

            return convertJsonToObjForAchievement(result.toString());
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private Map<String, Object> convertJsonToObjForCourse(String json, String week) {
        JSONArray jsonArray = new JSONArray(json);
        JSONArray jsonArrayMore = jsonArray.getJSONArray(0);
        JSONArray weekDateJSONArray = jsonArray.getJSONArray(1);
        List<Course> list = new ArrayList<Course>();
        for (int i = 0; i < jsonArrayMore.length(); i++) {
            Course course = new Course();

            JSONObject jsonObject = jsonArrayMore.getJSONObject(i);

            course.setCourseName(jsonObject.getString("kcmc"));
            course.setTeachPlace(jsonObject.getString("jxcdmc"));
            course.setClassName(jsonObject.getString("jxbmc"));
            course.setClassroomPersonNum(jsonObject.getString("pkrs"));
            course.setCourseCode(jsonObject.getString("kcdm"));
            course.setCourseTeacher(jsonObject.getString("teaxms"));
            course.setTeachIntroduction(jsonObject.getString("sknrjj"));
            course.setTermCode(jsonObject.getString("xnxqdm"));
            course.setWeek(jsonObject.getString("zc"));
            course.setWeekday(jsonObject.getString("xq"));
            course.setSection(jsonObject.getString("jcdm2"));
            course.setTotalHours(jsonObject.getString("zxs"));
            course.setHour(jsonObject.getString("xs"));
            list.add(course);
        }

        //获取周日期
        SchooolDate schooolDate = new SchooolDate();
        schooolDate.setWeek(week);
        for (int j = 0; j < weekDateJSONArray.length(); j++) {
            JSONObject jsonObject = weekDateJSONArray.getJSONObject(j);
            String weekday = jsonObject.getString("xqmc");
            String date = jsonObject.getString("rq");
            switch (weekday) {
                case "7":
                    schooolDate.setSunday(date);
                    break;
                case "1":
                    schooolDate.setMonday(date);
                    break;
                case "2":
                    schooolDate.setTuesday(date);
                    break;
                case "3":
                    schooolDate.setWebnesday(date);
                    break;
                case "4":
                    schooolDate.setThursday(date);
                    break;
                case "5":
                    schooolDate.setFriday(date);
                    break;
                case "6":
                    schooolDate.setSaturday(date);
                    break;
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("courseInfo", list);
        result.put("weekDate", schooolDate);

        return result;
    }

    private List<Achievement> convertJsonToObjForAchievement(String json) {
        JSONObject jsonObject = new JSONObject(json);
        JSONArray jsonArray = jsonObject.getJSONArray("rows");
        List<Achievement> list = new ArrayList<Achievement>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            Achievement achievement = new Achievement();

            achievement.setAchievement(object.getString("cjjd"));
            achievement.setAchievementWayName(object.getString("cjfsmc"));
            achievement.setTotalAchievement(object.getString("zcj"));
            achievement.setAttendWay(object.getString("xdfsmc"));
            achievement.setCourseName(object.getString("kcmc"));
            achievement.setCourseCode(object.getString("kcdm"));
            achievement.setCourseNumber(object.getString("kcbh"));
            achievement.setCredit(object.getString("xf"));
            achievement.setExamCharacter(object.getString("ksxzmc"));
            achievement.setCourseClassName(object.getString("kcdlmc"));
            achievement.setIsActive(object.getString("isactive"));
            achievement.setRowNum(object.getString("rownum_"));
            achievement.setStudentCode(object.getString("xsdm"));
            achievement.setStudentName(object.getString("xsxm"));
            achievement.setStudentNumber(object.getString("xsbh"));
            achievement.setTaskCode(object.getString("rwdm"));
            achievement.setTermCode(object.getString("xnxqdm"));
            achievement.setTermName(object.getString("xnxqmc"));
            achievement.setTotalHours(object.getString("zxs"));

            list.add(achievement);
        }

        return list;
    }


}
