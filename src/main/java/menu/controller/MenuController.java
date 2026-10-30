package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;
import menu.domain.MenuRecommender;
import menu.ui.InputView;
import menu.ui.OutputView;

import java.util.Arrays;
import java.util.List;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printStart();

        Coaches coaches = readValidCoaches();
        readKindsOfAvoidLunchMenu(coaches);

        MenuRecommender menuRecommender = new MenuRecommender();
        List<Category> categories = menuRecommender.recommendMenuAboutFiveDay(coaches);
        outputView.resultRecommendedCategories(categories);
        outputView.resultSuggestedMenuOfCoaches(coaches);
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
        List<Coach> coachList = Arrays.stream(input.split(","))
                .map(each -> new Coach(each.trim()))
                .toList();
        return new Coaches(coachList);
    }

    private void readKindsOfAvoidLunchMenu(Coaches coaches) {
        for (Coach coach : coaches.takeCoaches()) {
            readValidAvoidMenu(coach);
        }
    }

    private void readValidAvoidMenu(Coach coach) {
        while (true) {
            try {
                List<String> avoidMenu = inputView.inputKindsOfAvoidLunchMenu(coach.takeName());
                coach.addAvoidMenu(avoidMenu);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
