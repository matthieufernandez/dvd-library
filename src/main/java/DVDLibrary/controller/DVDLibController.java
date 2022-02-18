package DVDLibrary.controller;

import DVDLibrary.dao.DVDLibDao;
import DVDLibrary.dao.DVDLibDaoImpl;
import DVDLibrary.dto.DVD;
import DVDLibrary.ui.DVDLibView;
import DVDLibrary.ui.UserIO;
import DVDLibrary.ui.UserIOConsoleImpl;

import java.util.List;

public class DVDLibController {
    private UserIO io = new UserIOConsoleImpl();
    private DVDLibView view = new DVDLibView();
    private DVDLibDao dao = new DVDLibDaoImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    viewAllDVDs();
                    break;
                case 2:
                    createDVD();
                    break;
                case 3:
                    removeDVD();
                    break;
                case 4:
                    getDVD();
                    break;
                case 5:
                    io.print("5. edit a dvd");
                    break;
                case 6:
                    io.print("6. search a dvd");
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    unknownMessage();
            }
        }
        exitMessage();
    }


    private int getMenuSelection() {
        return view.printMenuSelection();
    }

    private void createDVD() {
        view.printCreateDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.printSuccessBanner();
    }

    private void viewAllDVDs() {
        view.printViewAllBanner();
        List<DVD> DVDsList = dao.getAllDVDs();
        view.displayAllDVDs(DVDsList);
    }

    private void getDVD() {
        view.printViewBanner();
        String title = view.getDvdTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
    }

    private void removeDVD() {
        view.printDeleteBanner();
        String title = view.getDvdTitleChoice();
        DVD dvd = dao.removeDVD(title);
        view.printSuccessBanner();
    }

    private void unknownMessage() {
        view.printUnknownCommandMessage();
    }

    private void exitMessage() {
        view.printExitMessage();
    }
}
