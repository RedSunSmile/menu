package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryGeneratorTest {
    @Test
    void 카테고리추천은_평일_5일_단위로_생성된다() {
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        assertThat(categoryGenerator.generateCategories().size()).isEqualTo(5);
    }

    @Test
    void 같은_카테고리메뉴는_최대2개까지_나온다() {
        CategoryGenerator generator = new CategoryGenerator();
        List<Category> categories = generator.generateCategories();
        for (Category category : Category.values())
            assertThat(Collections.frequency(categories, category)).isLessThanOrEqualTo(2);
    }
}
