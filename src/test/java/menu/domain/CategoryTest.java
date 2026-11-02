package menu.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CategoryTest {
    @Test
    void 카테고리는_5개중에_고를수_있다() {
        assertThat(Category.from(5));
    }

    @Test
    void 카테고리_6은_예외가_발생한다() {

        assertThatThrownBy(() -> Category.from(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 카테고리 5개 중에 고를 수 있습니다.");

    }
}
