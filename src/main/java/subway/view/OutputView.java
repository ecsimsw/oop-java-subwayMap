package subway.view;

public class OutputView {
    private OutputView(){}

    public static void printSectionManagement(){
        OutputView.printMsg(MenuRepository.sectionManagementMenu);
    }

    public static void printLineManagement(){
        OutputView.printMsg(MenuRepository.lineManagementMenu);
    }

    public static void printStationManagement(){
        OutputView.printMsg(MenuRepository.stationManagementMenu);
    }

    public static void printMainPage(){
        OutputView.printMsg(MenuRepository.mainMenu);
    }

    public static void printMsg(Object msg){
        System.out.print(msg);
    }
}
