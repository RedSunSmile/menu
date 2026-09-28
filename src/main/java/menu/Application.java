package menu;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.ui.InputView;
import menu.ui.OutputView;

import javax.xml.catalog.Catalog;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String input = inputView.inputCoachNameOfSelectedLunchMenu();
        String[] names = input.split(",");
        List<Coach> coachList = new ArrayList<>();
        for (String each : names) {
            String coachName = each.trim();
            List<String> bannedMenus = inputView.inputKindsOfNotSelectedLunchMenu(coachName);
            Coach coach = new Coach(coachName, bannedMenus);
            coachList.add(coach);
        }

        Coaches coaches = new Coaches(coachList);
        MenuRecommender menuRecommender = new MenuRecommender();
        List<Category> menus = menuRecommender.commandMenusAboutFiveDays(coaches);
        OutputView outputView = new OutputView();
        outputView.resultCommandMenus(menus);
        outputView.resultFavoriteMenusOfCoaches(coaches);
    }
}
