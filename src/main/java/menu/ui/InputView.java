package menu.ui;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.Category;
import menu.domain.Coach;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String inputRecommenderMenuOfCoach() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        return Console.readLine();
    }

    public List<String> inputAvoidMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        if (input.isBlank()) {
            return List.of();
        }
        String split[] = input.split(",");
        List<String> avoidMenu = new ArrayList<>();
        for (String each : split) {
            avoidMenu.add(each.trim());

        }
        return avoidMenu;
    }
}
