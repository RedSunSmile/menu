package menu.domain;


import java.util.List;

public class MenuRecommender {

    private final CategoryGenerator categoryGenerator;

    public MenuRecommender(CategoryGenerator categoryGenerator) {
        this.categoryGenerator = categoryGenerator;
    }

    public List<Category> recommendMenuOfFiveDay(Coaches coaches) {
        List<Category> categories = categoryGenerator.generateCategories();

        for (Category category : categories) {
            selectMenusOfDay(coaches, category);
        }
        return categories;
    }

    private void selectMenusOfDay(Coaches coaches, Category category) {
        for (Coach coach : coaches.takeCoaches()) {
            String menu = categoryGenerator.pickMenuAboutCategory(category);
            while (!coach.canEat(menu)) {
                menu = categoryGenerator.pickMenuAboutCategory(category);
            }
            coach.addDigestedMenu(menu);
        }
    }
}
