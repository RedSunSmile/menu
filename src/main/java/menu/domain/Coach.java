package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    private final String name;
    private List<String> avoidMenu;
    private final List<String> digestedMenu;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.avoidMenu = new ArrayList<>();
        this.digestedMenu = new ArrayList<>();
    }

    public List<String> takeDigestedMenu() {
        return digestedMenu;
    }

    public String takeName() {
        return name;
    }

    public List<String> takeAvoidMenu() {
        return avoidMenu;
    }

    private void validateNameLength(String name) {

        boolean isInvalidLength = !(name.length() >= 2 && name.length() <= 4);
        if (isInvalidLength) {
            throw new IllegalArgumentException("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");
        }
    }

    private void validateAvoidMenu(List<String> avoidMenu) {
        boolean isOverLimit = !(avoidMenu.size() <= 2);
        if (isOverLimit) {
            throw new IllegalArgumentException("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
        }
    }

    public void addAvoidMenu(List<String> avoidMenu) {
        validateAvoidMenu(avoidMenu);
        this.avoidMenu = avoidMenu;
    }

    public void addDigestedMenu(String menu) {
        digestedMenu.add(menu);
    }

    public boolean canEat(String menu) {
        if (avoidMenu.contains(menu)) {
            return false;
        }
        if (digestedMenu.contains(menu)) {
            return false;
        }
        return true;
    }
}
