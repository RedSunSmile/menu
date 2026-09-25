package menu.domain;

import java.util.List;

public class Coach {
    private final String name;
    private final List<String> counts;
    public Coach(String name, List<String> counts) {
        this.name = name;
        this.counts = counts;
        validateAvoidMenu(counts);
        limitedNameLength(name);
    }

    public String takeName() {
        return name;
    }

    public List<String> takeCounts() {
        return counts;
    }

    public void limitedNameLength(String name){

        boolean isInvalidLength = !(name.length() >= 2 && name.length()<= 4);
        if (isInvalidLength) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");
        }
    }

    public void validateAvoidMenu(List<String> values){
        boolean avoidMenuSize = !(values.size() <= 2 );
       if(avoidMenuSize){
           throw new IllegalArgumentException("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
       }
    }
}
