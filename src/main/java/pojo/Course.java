package pojo;

//         "dgksdm": "1406306",                             课室代码
//         "kbdm": "",                                      课表代码
//         "kcbh": "1400042",                               课程编号
//         "kcmc": "毛泽东思想和中国特色社会主义理论体系概论(2)",  课程名称
//         "teaxms": "黄文保",                               授课名师
//         "jxbdm": "1058887",                              教学班代码
//         "xnxqdm": "201702",                              学年学期代码
//         "jxbmc": "151005,150806,150804",                 教学班名称
//         "zc": "1",                                       周次
//         "jcdm": "0910",                                  节次代码
//         "jcdm2": "09,10",                                节次代码2
//         "xq": "1",                                       星期
//         "jxcdmc": "北主楼1005",                           教学场地名称
//         "sknrjj": "改革开放是发展中国特色社会主义的必由之路",   授课内容简介
//         "teadms": "200002007",                           名师
//         "jxcddm": "00446",                               教学场地代码
//         "kcdm": "1006661",                               课程代码
//         "zxs": "48",                                     总学时
//         "xs": "2",                                       学时
//         "pkrs": "144",                                   排课人数
//         "kxh": "1",                                      课序号
//         "flfzmc": "",                                    分组名称
//         "jxhjmc": "讲课",                                 教学环境名称
//         "tkbz": "1"
public class Course {
    private String courseCode;//课程编号
    private String courseName;//课程名称
    private String courseTeacher;//授课教师
    private String className;//教学班名称
    private String teachPlace;//教学地点
    private String termCode;//学期编号
    private String week;//周次
    private String weekday;//星期几
    private String section;//节次
    private String totalHours;//总学时
    private String hour;//学时
    private String classroomPersonNum;//排课人数
    private String teachIntroduction;//授课内容简介

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTeachPlace() {
        return teachPlace;
    }

    public void setTeachPlace(String teachPlace) {
        this.teachPlace = teachPlace;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getClassroomPersonNum() {
        return classroomPersonNum;
    }

    public void setClassroomPersonNum(String classroomPersonNum) {
        this.classroomPersonNum = classroomPersonNum;
    }

    public String getTeachIntroduction() {
        return teachIntroduction;
    }

    public void setTeachIntroduction(String teachIntroduction) {
        this.teachIntroduction = teachIntroduction;
    }
}
