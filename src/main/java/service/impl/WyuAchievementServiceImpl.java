package service.impl;

import dao.WyuCourseDao;
import pojo.Achievement;
import service.WyuAchievementService;

import java.util.List;

public class WyuAchievementServiceImpl implements WyuAchievementService {

    @Override
    public List<Achievement> getAchievement(String term) {
        WyuCourseDao wyuCourseDao = new WyuCourseDao();
        return wyuCourseDao.getAchievement(term);
    }
}
