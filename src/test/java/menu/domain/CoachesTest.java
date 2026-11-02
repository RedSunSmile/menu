package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CoachesTest {

    @Test
    void 코치들은_최소2명에서_최대5명이하로_식사_가능하다() {
        String name = "포비,왼손,니익,쭈운,크라운";
        String[] values = name.split(",");
        List<Coach> coachesList = new ArrayList<>(Arrays.stream(values).map(Coach::new).toList());
        Coaches coaches = new Coaches(coachesList);
        assertThat(coaches.takeCoaches().size()).isEqualTo(5);
    }

    @Test
    void 코치가_최소1명이면_예외가_발생한다() {
        String name = "포비";
        String[] values = name.split(",");
        List<Coach> coachesList = new ArrayList<>(Arrays.stream(values).map(Coach::new).toList());

        assertThatThrownBy(() -> new Coaches(coachesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치들은 최소 2명에서 최대 5명이하로 함께 식사 가능합니다.");
    }

    @Test
    void 코치들은_최대6명이면_예외가_발생한다() {
        String name = "포비,그루밍,포코,제이슨,왼손,네오";
        String[] values = name.split(",");
        List<Coach> coachesList = new ArrayList<>(Arrays.stream(values).map(Coach::new).toList());

        assertThatThrownBy(() -> new Coaches(coachesList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 코치들은 최소 2명에서 최대 5명이하로 함께 식사 가능합니다.");
    }

}

