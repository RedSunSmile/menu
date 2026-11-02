package menu.domain;

import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        this.coaches = coaches;
        validateSize(coaches);
    }

    private void validateSize(List<Coach> coaches){
        boolean canNot=!(coaches.size() >=2 && coaches.size()<=5);
        if(canNot){
            throw new IllegalArgumentException("[ERROR] 코치들은 최소 2명에서 최대 5명이하로 함께 식사 가능합니다.");
        }
    }

    public List<Coach> takeCoaches() {
        return coaches;
    }
}
