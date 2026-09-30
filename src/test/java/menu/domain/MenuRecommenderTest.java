package menu.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuRecommenderTest {
    @Test
    void 코치마다_먹은_메뉴는_5개이다() {
        MenuRecommender menuRecommender = new MenuRecommender();
        List<Coach> coachList = List.of(
                new Coach("왼손"),
                new Coach("포비")
        );
        Coaches coaches = new Coaches(coachList);
        menuRecommender.commandMenusAboutFiveDays(coaches);
        for (Coach coach : coaches.takeCoaches()) {
            assertThat(coach.takeDigestedMenus()).hasSize(5);
        }
    }

    @Test
    void 먹은_메뉴에_중복이_없다() {
        MenuRecommender menuRecommender = new MenuRecommender();
        List<Coach> coachList = List.of(
                new Coach("제이슨"),
                new Coach("네오")
        );
        Coaches coaches = new Coaches(coachList);
        menuRecommender.commandMenusAboutFiveDays(coaches);
        for (Coach coach : coaches.takeCoaches()) {
            assertThat(coach.takeDigestedMenus()).doesNotHaveDuplicates();
        }
    }

    @Test
    void 못_먹는_메뉴는_추천되지_않는다() {
        MenuRecommender menuRecommender = new MenuRecommender();
        Coach jason = new Coach("제이슨");
        jason.addAvoidMenu(List.of("똠얌꿍"));
        Coach neo = new Coach("네오");
        neo.addAvoidMenu(List.of("나시고렝"));
        List<Coach> coachList = List.of(jason, neo);
        Coaches coaches = new Coaches(coachList);
        menuRecommender.commandMenusAboutFiveDays(coaches);

        assertThat(jason.takeDigestedMenus()).doesNotContain("똠얌꿍");
        assertThat(neo.takeDigestedMenus()).doesNotContain("나시고렝");
    }
}
