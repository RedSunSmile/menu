package menu.ui;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Coaches;

import java.util.List;

public class OutputView {
    public void printStart(){
        System.out.println("점심 메뉴 추천을 시작합니다.");
        System.out.println();
    }
    public void recommendCategory(List<Category> categories){
        System.out.println("메뉴 추천 결과입니다.");
        System.out.println("[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]");
        System.out.print("[ 카테고리");

        for(Category category:categories){
            System.out.print(" | "+category);
        }
        System.out.println(" ]");
    }

    public void recommendMenuOfCoaches(Coaches coaches){
        for(Coach coach:coaches.takeCoaches()){
            System.out.print("[ "+coach.takeName());
            for(String menu:coach.takeDigestedMenu()){
                System.out.print(" | "+menu);
            }
            System.out.println(" ]");
        }
    }

    public void completeMessage(){
        System.out.println();
        System.out.println("추천을 완료했습니다.");
    }
}
