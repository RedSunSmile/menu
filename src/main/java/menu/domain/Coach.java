package menu.domain;

import java.util.Map;

public class Coach {
    private final String name;
    private final int counts;
    public Coach(String name, int counts) {
        validateAvoidMenu(counts);
        this.name = name;
        limitedNameLength();
        this.counts = counts;

    }

    public String takeName() {
        return name;
    }

    public int takeCounts() {
        return counts;
    }

    public void limitedNameLength(){

        boolean b = !(name.length() >= 2 && name.length() <= 4);
        if (b) {
                throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");
        }
    }

    public void validateAvoidMenu(int values){
        boolean c = !(values <= 2 );
       if(c){
           throw new IllegalArgumentException("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
       }
    }
}
