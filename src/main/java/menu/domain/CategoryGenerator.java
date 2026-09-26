package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryGenerator {

    public List<Category> generateScopeDateOfMenus() {
        List<Category> categories = new ArrayList<>();
        int max = 5;
        int result = 0;
        while (categories.size() < max) {
            result = Randoms.pickNumberInRange(1, 5);
            Category category = Category.from(result);
            addCategoryUnderLimit(categories, category);
        }
        return categories;
    }

    private static void addCategoryUnderLimit(List<Category> categories, Category category) {
        if (Collections.frequency(categories, category) < 2) {
            categories.add(category);
        }
    }

    public String calculateAboutCategory(Category category){
        String menu=Randoms.shuffle(category.getMenus()).get(0);
        return menu;
    }
}
