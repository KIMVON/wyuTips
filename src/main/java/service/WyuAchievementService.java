package service;

import pojo.Achievement;

import java.util.List;

public interface WyuAchievementService {
    List<Achievement> getAchievement(String term , String verifyCookie);
}
