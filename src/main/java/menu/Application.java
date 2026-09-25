package menu;

import menu.domain.Coach;
import menu.domain.Coaches;
import menu.ui.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView=new InputView();
        String input=inputView.inputCoachNameOfSelectedLunchMenu();
        String[] names=input.split(",");
        List<Coach> coach1=new ArrayList<>();
        for(String each:names) {
          String coachName=each.trim();
            List<String> bannedMenus=inputView.inputKindsOfNotSelectedLunchMenu(coachName);
            Coach coach=new Coach(coachName,bannedMenus);
            coach1.add(coach);
        }
        Coaches coaches=new Coaches(coach1);


    }
}
