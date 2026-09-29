package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> counts;
    private final List<String> digestedMenus;

    public Coach(String name) {
        this.name = name;
        this.counts = new ArrayList<>();
        this.digestedMenus = new ArrayList<>();
        limitedNameLength(name);
    }

    public List<String> takeDigestedMenus() {
        return digestedMenus;
    }

    public String takeName() {
        return name;
    }

    public List<String> takeCounts() {
        return counts;
    }

    public void limitedNameLength(String name) {

        boolean isInvalidLength = !(name.length() >= 2 && name.length() <= 4);
        if (isInvalidLength) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");
        }
    }

    public void validateAvoidMenu(List<String> values) {
        boolean avoidMenuSize = !(values.size() <= 2);
        if (avoidMenuSize) {
            throw new IllegalArgumentException("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
        }
    }

    public void addAvoidMenu(List<String> avoidMenus) {
        validateAvoidMenu(avoidMenus);
        this.counts = avoidMenus;
    }

    public void addDigestedMenu(String menu) {
        digestedMenus.add(menu);
    }

    public boolean canEat(String menu) {
        if (counts.contains(menu)) {
            return false;
        } else if (digestedMenus.contains(menu)) {
            return false;
        }
        return true;
    }


}
