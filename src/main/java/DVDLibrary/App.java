package DVDLibrary;

import DVDLibrary.controller.DVDLibController;

public class App {
    public static void main(String[] args) {
        DVDLibController controller = new DVDLibController();
        controller.run();
    }
}
