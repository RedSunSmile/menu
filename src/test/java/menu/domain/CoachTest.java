package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoachTest {

    @Test
    void 코치이름_길이는_최소2글자와_4글자_사이를_초과하면_예외가_발생한다() {
        assertThatThrownBy(() -> new Coach("제이브라운"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치이름 길이는 최소 2글자에서 최대 4글자입니다.");
    }

    @Test
    void 코치이름_길이는_최소2글자와_최대4글자_사이이다() {
        Coach coach = new Coach("포코");
        assertThat(coach.takeName().length()).isEqualTo(2);
    }

    @Test
    void 각코치는_최대3개_못먹는_메뉴를_고르면_예외가_발생한다() {
        Coach coach = new Coach("포비");
        assertThatThrownBy(() -> coach.addAvoidMenu(List.of("똠양꿍", "뇨끼", "반미")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 최대 2개 못먹는 메뉴를 고를 수 있습니다.");
    }

    @Test
    void 각_코치는_최대2개_못먹는_메뉴를_고를수_있다() {
        Coach coach = new Coach("제이슨");
        coach.addAvoidMenu(List.of("똠양꿍", "끼슈"));
        assertThat(coach.takeAvoidMenu().size()).isEqualTo(2);

    }

    @Test
    void 코치는_못먹는_메뉴도_아니고_시도하지_않은_메뉴를_고를수_있다() {
        Coach coach1 = new Coach("네오");
        coach1.addAvoidMenu(List.of("똠양꿍", "끼슈"));
        coach1.addDigestedMenu("김밥");

        assertThat(coach1.canEat("똠양꿍")).isFalse();
        assertThat(coach1.canEat("김밥")).isFalse();
        assertThat(coach1.canEat("반미")).isTrue();
    }
}
