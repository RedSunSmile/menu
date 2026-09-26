package menu.domain;

import java.util.ArrayList;
import java.util.List;

public class MenuRecommender {
    private final CategoryGenerator categoryGenerator;

    public MenuRecommender() {
        this.categoryGenerator = new CategoryGenerator();
    }

    public List<String> selectMenusOfDays(Coaches coaches, Category category) {

        List<String> menus = new ArrayList<>();
        for (Coach coach : coaches.takeCoaches()) {
            String menu = categoryGenerator.calculateAboutCategory(category);
            while (!coach.canEat(menu)) {
                menu = categoryGenerator.calculateAboutCategory(category);
            }
            coach.addDigestedMenu(menu);
            menus.add(menu);
        }
        return menus;
    }

    public List<Category> commandMenusAboutFiveDays(Coaches coaches) {
        List<Category> categories = categoryGenerator.generateScopeDateOfMenus();

        for (Category category : categories) {
            selectMenusOfDays(coaches, category);

        }
        return categories;
    }

}
