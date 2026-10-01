package menu.domain;

import java.util.List;

public class MenuRecommender {
    private final CategoryGenerator categoryGenerator;

    public MenuRecommender() {
        this.categoryGenerator = new CategoryGenerator();
    }

    private void selectMenusOfEachDay(Coaches coaches, Category category) {
        for (Coach coach : coaches.takeCoaches()) {
            String menu = categoryGenerator.pickMenuAboutCategory(category);
            while (!coach.canEat(menu)) {
                menu = categoryGenerator.pickMenuAboutCategory(category);
            }
            coach.addDigestedMenu(menu);
        }
    }

    public List<Category> recommendMenusAboutFiveDays(Coaches coaches) {
        List<Category> categories = categoryGenerator.generateCategories();

        for (Category category : categories) {
            selectMenusOfEachDay(coaches, category);
        }
        return categories;
    }
}
