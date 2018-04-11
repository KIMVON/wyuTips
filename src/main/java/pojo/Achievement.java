package pojo;

//　　　　　　        "rownum_":"1",              行号
//        　　　　　　"isactive":"1",             是否激活
//        　　　　　　"xsxm":"朱剑华",             学生姓名
//        　　　　　　"wpjbz":"",
//        　　　　　　"kcflmc":"",                课程分类名称
//        　　　　　　"xnxqmc":"2017-2018-1",     学年学期名称
//        　　　　　　"kcdlmc":"公共课",           课程大类名称
//        　　　　　　"cjjd":"3.5",               成绩绩点
//        　　　　　　"ksxzdm":"0",
//        　　　　　　"kcdm":"1007102",           课程代码
//        　　　　　　"bz":"",
//        　　　　　　"kcmc":"数据库原理",          课程名称
//        　　　　　　"cjdm":"7746829",           成绩代码
//        　　　　　　"zcj":"85",                 总成绩
//        　　　　　　"wzc":"0",
//        　　　　　　"ksxzmc":"正常考试",          考试性质名称
//        　　　　　　"cjbzmc":"",
//        　　　　　　"kcbh":"0500610",           课程编号
//        　　　　　　"xf":"3",                   学分
//        　　　　　　"wpj":"0",
//        　　　　　　"xnxqdm":"201701",          学年学期代码
//        　　　　　　"zxs":"48",                 总学时
//        　　　　　　"xsbh":"3115002516",        学生编号
//        　　　　　　"xdfsmc":"必修",             修读方式民初
//        　　　　　　"rwdm":"25527",             任务代码
//        　　　　　　"xsdm":"300211204",         学生代码
//        　　　　　　"wzcbz":"",
//        　　　　　　"cjfsmc":"百分制"            成绩方式名称
public class Achievement {
    private String rowNum;//行号
    private String isActive;//是否激活
    private String studentName;//学生姓名
    private String studentNumber;//学生编号，学号
    private String studentCode;//学生代码
    private String termCode;//学年学期代码
    private String termName;//学年学期名称
    private String courseName;//课程名称
    private String courseClassName;//课程大类名称
    private String courseCode;//课程代码
    private String courseNumber;//课程编号
    private String totalAchievement;//总成绩
    private String achievement;//成绩绩点
    private String credit;//学分
    private String achievementWayName;//成绩方式名称
    private String examCharacter;//考试性质
    private String totalHours;//总学时
    private String attendWay;//修读方式
    private String taskCode;//任务代码


    public String getRowNum() {
        return rowNum;
    }

    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseClassName() {
        return courseClassName;
    }

    public void setCourseClassName(String courseClassName) {
        this.courseClassName = courseClassName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getTotalAchievement() {
        return totalAchievement;
    }

    public void setTotalAchievement(String totalAchievement) {
        this.totalAchievement = totalAchievement;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getAchievementWayName() {
        return achievementWayName;
    }

    public void setAchievementWayName(String achievementWayName) {
        this.achievementWayName = achievementWayName;
    }

    public String getExamCharacter() {
        return examCharacter;
    }

    public void setExamCharacter(String examCharacter) {
        this.examCharacter = examCharacter;
    }

    public String getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(String totalHours) {
        this.totalHours = totalHours;
    }

    public String getAttendWay() {
        return attendWay;
    }

    public void setAttendWay(String attendWay) {
        this.attendWay = attendWay;
    }

    public String getTaskCode() {
        return taskCode;
    }

    public void setTaskCode(String taskCode) {
        this.taskCode = taskCode;
    }
}
