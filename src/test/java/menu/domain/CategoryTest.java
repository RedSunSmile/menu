package menu.domain;

import menu.domain.Category;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CategoryTest {

    @Test
    void 없는_카테고리_번호면_예외가_발생한다(){
        assertThatThrownBy(()-> Category.from(6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 존재하지 않는 카테고리입니다.");
    }
}
