package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CategoryGenerator {
    private static final int CATEGORY_COUNT = 5;
    private static final int MIN_SAME_CATEGORY = 2;

    public List<Category> generateCategories() {
        List<Category> categories = new ArrayList<>();
        while (categories.size() < CATEGORY_COUNT) {
            int result = Randoms.pickNumberInRange(1, 5);
            Category category = Category.from(result);
            addCategoryUnderLimit(categories, category);
        }
        return categories;
    }

    private void addCategoryUnderLimit(List<Category> categories, Category category) {
        if (Collections.frequency(categories, category) < MIN_SAME_CATEGORY) {
            categories.add(category);
        }
    }

    public String pickMenuAboutCategory(Category category) {
        return Randoms.shuffle(category.takeMenus()).get(0);
    }
}
