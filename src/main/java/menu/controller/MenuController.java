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
        //점심 메뉴 추천 시작 출력
        outputView.printStart();

//메뉴추천 받을 코치이름 입력 받기
        Coaches coaches = readCoaches();
        //코치가 못먹는 메뉴 입력
        readAvoidMenu(coaches);
        CategoryGenerator categoryGenerator = new CategoryGenerator();
        MenuRecommender recommender = new MenuRecommender(categoryGenerator);

        //메뉴추천 결과 출력
        List<Category> categories = recommender.recommendMenuOfFiveDay(coaches);
        outputView.recommendCategory(categories);
        outputView.recommendMenuOfCoach(coaches);
        outputView.completeMessage();
    }

    private void readAvoidMenu(Coaches coaches) {
        for (Coach coach : coaches.takeCoaches()) {
            List<String> avoidMenu = inputView.inputAvoidMenu(coach.takeName());
            coach.addAvoidMenu(avoidMenu);
        }
    }

    private Coaches readCoaches() {
        String inputName = inputView.inputRecommenderMenuOfCoach();
        List<Coach> coachList = new ArrayList<>();
        for (String name : inputName.split(",")) {
            coachList.add(new Coach(name.trim()));
        }
        Coaches result = new Coaches(coachList);
        return result;
    }
}
