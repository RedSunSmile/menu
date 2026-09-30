package menu.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CoachTest {

    @Test
    void 코치이름길이의_범위가_최소범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Coach("가"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");

    }

    @Test
    void 코치이름길이의_범위가_최대범위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Coach("남궁궁뎅이"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치 이름은 2~4글자 사이여야 합니다.");

    }

    @Test
    void 코치이름길이의_범위는_최소2글자와_최대4글자이다() {
        Coach coach1 = new Coach("짱구");
        Coach coach2 = new Coach("김서방네");

        assertThat(coach1.takeName().length()).isEqualTo(2);
        assertThat(coach2.takeName().length()).isEqualTo(4);
    }

    @Test
    void 못먹는_메뉴는_최대2개이다() {
        Coach coach = new Coach("김서방");
        List<String> values = new ArrayList<>();
        values.add("우동");
        values.add("뇨끼");
        coach.addAvoidMenu(values);
        assertThat(coach.takeCounts()).hasSize(2);
    }

    @Test
    void 못먹는_메뉴가_3개라면_예외가_발생한다() {
        Coach coach = new Coach("김서방");
        List<String> values = new ArrayList<>();
        values.add("우동");
        values.add("뇨끼");
        values.add("나시고렝");
        assertThatThrownBy(() -> coach.addAvoidMenu(values))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 각 코치는 최대 2개까지 못 먹는 메뉴가 있습니다.");
    }

    @Test
    void 이미_먹은후의_메뉴는_먹을_수_없다() {
        Coach coach = new Coach("박짱구");
        coach.addDigestedMenu("김밥");
        assertThat(coach.canEat("김밥")).isFalse();
    }

    @Test
    void 못먹는_메뉴는_먹을수_없다(){
        Coach coach = new Coach("김봉팔");
        coach.addAvoidMenu(List.of("뇨끼"));
        assertThat(coach.canEat("뇨끼")).isFalse();
    }

    @Test
    void 처음_먹는_메뉴는_먹을_수_있다() {
        Coach coach = new Coach("박짱구");
        assertThat(coach.canEat("김치찌개")).isTrue();
    }


}
