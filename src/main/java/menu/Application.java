package menu;

import menu.ui.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView=new InputView();
        String coach1=inputView.inputCoachNameOfSelectedLunchMenu();
        String[] coaches=coach1.split(",");
        for(String coach2:coaches) {
            inputView.inputKindsOfNotSelectedLunchMenu(coach2.trim());
        }
    }
}
