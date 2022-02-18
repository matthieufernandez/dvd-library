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
                    editDVD();
                    break;
                case 6:
                    searchForDVD();
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
        int choice = view.getConfirmYN();
        if (choice != 2) {
            dao.removeDVD(title);
            view.printSuccessBanner();
        } else {
            view.printCancel();
        }
    }

    private void editDVD() {
        view.printEditBanner();
        String title = view.getDvdTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
        int editMenuSelection = view.printEditMenu();

        switch(editMenuSelection) {
            case 1:
                String newTitle = view.printEditTitle();
                dvd.setTitle(newTitle);
                dao.addDVD(newTitle, dvd);
                dao.removeDVD(title);
                view.printSuccessBanner();
                break;

            case 2:
                String newDate = view.printEditDate();
                dvd.setDate(newDate);
                view.printSuccessBanner();
                break;

            case 3:
                String newRating = view.printEditRating();
                dvd.setRating(newRating);
                view.printSuccessBanner();
                break;

            case 4:
                String newDirector = view.printEditDirector();
                dvd.setDirector(newDirector);
                view.printSuccessBanner();
                break;

            case 5:
                String newStudio = view.printEditStudio();
                dvd.setStudio(newStudio);
                view.printSuccessBanner();
                break;

            case 6:
                String newNotes = view.printEditNotes();
                dvd.setNotes(newNotes);
                view.printSuccessBanner();
                break;

            case 7:
                view.printCancel();
                break;

            default:
                view.printUnknownCommandMessage();
        }
    }

    private void searchForDVD() {
        view.printSearchBanner();
        String searchTerm = String.format("%S", view.getSearchTerm());
        List<DVD> DVDsList = dao.searchForDVD(searchTerm);
        view.displayAllDVDs(DVDsList);

    }

    private void unknownMessage() {
        view.printUnknownCommandMessage();
    }

    private void exitMessage() {
        view.printExitMessage();
    }
}
