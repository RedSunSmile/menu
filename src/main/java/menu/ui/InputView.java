package menu.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String inputCoachNameOfSelectedLunchMenu() {
        System.out.println("코치의 이름을 입력해 주세요. (, 로 구분)");
        String input = Console.readLine();
        System.out.println();
        return input;
    }

    public List<String> inputKindsOfNotSelectedLunchMenu(String name) {
        System.out.println(name + "(이)가 못 먹는 메뉴를 입력해 주세요.");
        String input = Console.readLine();
        System.out.println();
        if (input.isBlank()) {
            return List.of();
        }
        List<String> kinds = new ArrayList<>();
        String[] menus = input.split(",");
        for (String each : menus) {
            String menu = each.trim();
            kinds.add(menu);
        }
        return kinds;
    }

}