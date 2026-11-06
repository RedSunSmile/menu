package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRecommenderTest {

    @Test
    void 추천된_5일치에_대한_메뉴를_선택한다() {
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        MenuRecommender menuRecommender = new MenuRecommender(categoryGenerator);
        String name = "포비,스칼라,제이,브라운,니익";
        String[] names = name.split(",");

        List<Coach> coachesList = Arrays.stream(names)
                .map(Coach::new)
                .toList();
        Coaches coaches = new Coaches(coachesList);
        List<Category> categories = menuRecommender.recommendMenuOfFiveDay(coaches);

        assertThat(categories).hasSize(5);
        for (Coach coach : coaches.takeCoaches()) {
            assertThat(coach.takeDigestedMenu()).hasSize(5);
            assertThat(coach.takeDigestedMenu()).doesNotHaveDuplicates();
        }
    }
}
