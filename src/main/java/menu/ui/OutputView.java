package menu.ui;

import menu.domain.*;

import java.util.List;

public class OutputView {

    public void resultCommandMenus(List<Category> menus) {
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");
        for (Category category : menus) {
            System.out.print(" | " + category);
        }
        System.out.print(" ]");
        System.out.println();
    }

    public void resultFavoriteMenusOfCoaches(Coaches coaches) {
        for (Coach coach : coaches.takeCoaches()) {
            System.out.print("[ " + coach.takeName());
            for (String menu : coach.takeDigestedMenus()) {
                System.out.print(" | " + menu);
            }
            System.out.println(" ]");
        }
    }
}