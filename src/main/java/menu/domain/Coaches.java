package menu.domain;

import java.util.List;

public class Coaches {
    private final List<Coach> coaches;
    public Coaches(List<Coach> coaches) {
        validateNumbersOfCoaches(coaches.size());
        this.coaches = coaches;
    }

    private void validateNumbersOfCoaches(int numbers){
        boolean  impossibleSize=!(numbers>=2 && numbers<=5);
        if(impossibleSize){
            throw new IllegalArgumentException("[ERROR] 코치는 2명 이상 5명 이하여야 합니다.");
        }
    }
}
