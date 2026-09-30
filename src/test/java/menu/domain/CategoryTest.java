package menu.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CategoryTest {

    @Test
    void 없는_카테고리_번호가_0이면_예외가_발생한다() {
        assertThatThrownBy(() -> Category.from(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 존재하지 않는 카테고리입니다.");
    }

    @Test
    void 없는_카테고리_번호면_음수면_예외가_발생한다() {
        assertThatThrownBy(() -> Category.from(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 존재하지 않는 카테고리입니다.");
    }

    @Test
    void 없는_카테고리_번호가_6이면_예외가_발생한다() {
        assertThatThrownBy(() -> Category.from(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 존재하지 않는 카테고리입니다.");
    }

    @Test
    void 카테고리_번호가_1에서_5사이면_예외가_발생하지_않는다() {
        assertThatCode(() -> Category.from(1))
                .doesNotThrowAnyException();
        assertThatCode(() -> Category.from(2))
                .doesNotThrowAnyException();
        assertThatCode(() -> Category.from(3))
                .doesNotThrowAnyException();
        assertThatCode(() -> Category.from(4))
                .doesNotThrowAnyException();
        assertThatCode(() -> Category.from(5))
                .doesNotThrowAnyException();
    }

    @Test
    void 카테고리_종류가_5개이다() {
        Category[] categories = Category.values();
        assertThat(categories).hasSize(5);
    }


}


