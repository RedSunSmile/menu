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
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStart();

        Coaches coaches = readValidCoaches();
        readKindsOfAvoidLunchMenus(coaches);

        MenuRecommender menuRecommender = new MenuRecommender();
        List<Category> categories = menuRecommender.recommendMenusAboutFiveDays(coaches);
        outputView.resultRecommendedCategories(categories);
        outputView.resultSuggestedMenusOfCoaches(coaches);
        outputView.printCompletion();
    }

    private Coaches readValidCoaches() {
        while (true) {
            try {
                return readCoaches();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Coaches readCoaches() {
        String input = inputView.inputCoachNames();
        String[] names = input.split(",");
        List<Coach> coachList = new ArrayList<>();

        for (String each : names) {
            Coach coach = new Coach(each.trim());
            coachList.add(coach);
        }
        return new Coaches(coachList);
    }

    private void readKindsOfAvoidLunchMenus(Coaches coaches) {
        for (Coach coach : coaches.takeCoaches()) {
            readValidAvoidMenus(coach);
        }
    }

    private void readValidAvoidMenus(Coach coach) {
        while (true) {
            try {
                List<String> bannedMenus = inputView.inputKindsOfAvoidLunchMenu(coach.takeName());
                coach.addAvoidMenus(bannedMenus);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
