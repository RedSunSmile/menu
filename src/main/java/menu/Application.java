package menu;

import menu.domain.Coach;
import menu.ui.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView=new InputView();
        String input=inputView.inputCoachNameOfSelectedLunchMenu();
        String[] names=input.split(",");

        for(String each:names) {
          String coachName=each.trim();
            List<String> banned=inputView.inputKindsOfNotSelectedLunchMenu(coachName);
            Coach coach=new Coach(coachName,banned.size());
        }
    }
}
