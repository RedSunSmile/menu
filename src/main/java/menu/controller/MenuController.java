package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.ui.InputView;
import menu.ui.OutputView;

import java.util.ArrayList;
import java.util.List;

public class MenuController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        String input = inputView.inputCoachNameOfSelectedLunchMenu();
        String[] names = input.split(",");
        List<Coach> coachList = new ArrayList<>();

        readKindsOfAvoidLunchMenus(names, coachList);

        Coaches coaches = new Coaches(coachList);
        MenuRecommender menuRecommender = new MenuRecommender();
        List<Category> menus = menuRecommender.commandMenusAboutFiveDays(coaches);
        outputView.resultCommandMenus(menus);
        outputView.resultFavoriteMenusOfCoaches(coaches);
    }

    private void readKindsOfAvoidLunchMenus(String[] names, List<Coach> coachList) {
        for (String each : names) {
            String coachName = each.trim();
            List<String> bannedMenus = inputView.inputKindsOfNotSelectedLunchMenu(coachName);
            Coach coach = new Coach(coachName, bannedMenus);
            coachList.add(coach);
        }
    }

}
