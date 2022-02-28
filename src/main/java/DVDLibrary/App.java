package DVDLibrary;

import DVDLibrary.controller.DVDLibController;
import DVDLibrary.dao.DVDLibDao;
import DVDLibrary.dao.DVDLibDaoImpl;
import DVDLibrary.ui.DVDLibView;
import DVDLibrary.ui.UserIO;
import DVDLibrary.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO io = new UserIOConsoleImpl();
        DVDLibView view = new DVDLibView(io);
        DVDLibDao dao = new DVDLibDaoImpl();
        DVDLibController controller = new DVDLibController(dao, view);

        controller.run();
    }
}