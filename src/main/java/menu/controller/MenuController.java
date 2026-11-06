package menu.controller;

import menu.domain.*;
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
        for (Coach coach : coaches.takeCoaches()) {
            readValidAvoidMenu(coach);
        }
        MenuRecommender menuRecommender = new MenuRecommender(new CategoryGenerator());
        List<Category> categories = menuRecommender.recommendMenuOfFiveDay(coaches);
        outputView.recommendCategory(categories);
        outputView.recommendMenuOfCoach(coaches);
        outputView.completeMessage();
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

    public Coaches readCoaches() {
        String input = inputView.inputRecommenderMenuOfCoach();
        String[] names = input.split(",");
        List<Coach> coachList = new ArrayList<>();
        for (String each : names) {
            coachList.add(new Coach(each.trim()));
        }
        return new Coaches(coachList);
    }

    private void readValidAvoidMenu(Coach coach) {
        while (true) {
            try {
                List<String> avoidMenu = inputView.inputAvoidMenu(coach.takeName());
                coach.addAvoidMenu(avoidMenu);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
