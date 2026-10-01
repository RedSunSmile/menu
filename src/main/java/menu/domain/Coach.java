package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> avoidMenus;
    private final List<String> digestedMenus;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.avoidMenus = new ArrayList<>();
        this.digestedMenus = new ArrayList<>();
    }

    public List<String> takeDigestedMenus() {
        return digestedMenus;
    }

    public String takeName() {
        return name;
    }

    public List<String> takeAvoidMenus() {
        return avoidMenus;
    }

    private void validateNameLength(String name) {

        boolean isInvalidLength = !(name.length() >= 2 && name.length() <= 4);
        if (isInvalidLength) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");
        }
    }

    private void validateAvoidMenus(List<String> avoidMenus) {
        boolean isOverLimit = !(avoidMenus.size() <= 2);
        if (isOverLimit) {
            throw new IllegalArgumentException("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
        }
    }

    public void addAvoidMenus(List<String> avoidMenus) {
        validateAvoidMenus(avoidMenus);
        this.avoidMenus = avoidMenus;
    }

    public void addDigestedMenu(String menu) {
        digestedMenus.add(menu);
    }

    public boolean canEat(String menu) {
        if (avoidMenus.contains(menu)) {
            return false;
        }
        if (digestedMenus.contains(menu)) {
            return false;
        }
        return true;
    }
}
