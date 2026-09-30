package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryGeneratorTest {

    @Test
    void 메뉴에_대한_날짜범위는_5일이다() {
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        assertThat(categoryGenerator.generateScopeDateOfMenus()).hasSize(5);
    }

    @Test
    void 메뉴선택에_대한_같은_카테고리는_2번_이하다() {
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        List<Category> categories = categoryGenerator.generateScopeDateOfMenus();
        for (Category category : categories) {
            assertThat(Collections.frequency(categories, category)).isLessThanOrEqualTo(2);
        }
    }

    @Test
    void 돌려준_메뉴는_카테고리_메뉴_안에_있다() {
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        String menu = categoryGenerator.calculateAboutCategory(Category.한식);
        assertThat(menu).isIn(Category.한식.takeMenus());
    }
}
