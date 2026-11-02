package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<String> avoidMenu;
    private List<String> digestedMenu;

    public Coach(String name) {
        this.name = name;
        validateNameLength(name);
        this.avoidMenu = new ArrayList<>();
        this.digestedMenu = new ArrayList<>();
    }

    public String takeName() {
        return name;
    }

    public List<String> takeAvoidMenu() {
        return avoidMenu;
    }

    public List<String> takeDigestedMenu() {
        return digestedMenu;
    }

    private void validateNameLength(String name) {
        boolean impossibleScope = !(name.length() >= 2 && name.length() <= 4);
        if (impossibleScope) {
            throw new IllegalArgumentException("[ERROR] 코치이름 길이는 최소 2글자에서 최대 4글자입니다.");
        }
    }

    public void addAvoidMenu(List<String> avoidMenu) {
        boolean inValidScope = !(avoidMenu.size() <= 2);
        if (inValidScope) {
            throw new IllegalArgumentException("[ERROR] 최대 2개 못먹는 메뉴를 고를 수 있습니다.");
        }
        this.avoidMenu.addAll(avoidMenu);
    }

    public void addDigestedMenu(String menu){
        digestedMenu.add(menu);
    }

    public boolean canEat(String menu){
        if(avoidMenu.contains(menu)){
            return false;
        }
        if(digestedMenu.contains(menu)){
            return false;
        }
        return true;
    }

}
