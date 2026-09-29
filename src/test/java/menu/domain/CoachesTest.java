package menu.domain;

import menu.domain.Coach;
import menu.domain.Coaches;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoachesTest {

    @Test
    void 코치가_1명이면_예외가_발생한다() {
        List<Coach> coachList = List.of(new Coach("네오"));

        assertThatThrownBy(() -> new Coaches(coachList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치는 2명 이상 5명 이하여야 합니다.");
    }

    @Test
    void 식사를_함께_할수있는_코치범위는_최대5명이다() {
        List<Coach> coachList = List.of(
                new Coach("왼손"),
                new Coach("포비"),
                new Coach("제이슨"),
                new Coach("토미"),
                new Coach("네오"));
        Coaches coaches = new Coaches(coachList);
        assertThat(coaches.takeCoaches()).hasSize(5);
    }

    @Test
    void 코치범위가_6명이면_예외가_발생한다() {
        List<Coach> coachList = List.of(
                new Coach("왼손"),
                new Coach("포비"),
                new Coach("제이슨"),
                new Coach("토미"),
                new Coach("네오"),
                new Coach("오른발")
        );
        assertThatThrownBy(() -> new Coaches(coachList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치는 2명 이상 5명 이하여야 합니다.");
    }
    @Test
    void 식사를_함께_할수있는_최소범위는_2명이다() {
        List<Coach> coachList = List.of(
                new Coach("왼손"),
                new Coach("포비")
        );

        Coaches coaches = new Coaches(coachList);
        assertThat(coaches.takeCoaches()).hasSize(2);
    }
}
