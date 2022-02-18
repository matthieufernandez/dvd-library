package DVDLibrary.ui;

import DVDLibrary.dto.DVD;

import java.util.List;

public class DVDLibView {
    private UserIO io = (UserIO) new UserIOConsoleImpl();

    public int printMenuSelection() {
        io.print("MAIN MENU");
        io.print("1. List all DVDs");
        io.print("2. Enter a DVD");
        io.print("3. Remove a DVD");
        io.print("4. View a DVD entry");
        io.print("5. Edit a DVD");
        io.print("6. Search for a DVD");
        io.print("7. Exit");

        return io.readInt("please choose an option", 1, 7);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("What is the title of the film?");
        String date = io.readString("What was the release date?");
        String rating = io.readString("What is the MPAA rating?");
        String director = io.readString("Who is the director of the film?");
        String studio = io.readString("What studio distributes the film?");
        String notes = io.readString("Please enter personal review or note");
        DVD currentDVD = new DVD(title);
        currentDVD.setDate(date);
        currentDVD.setRating(rating);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setNotes(notes);
        return currentDVD;

    }

    public void displayAllDVDs(List<DVD> DVDsList) {
        for (DVD currentDVD : DVDsList) {
            String DVDInfo = String.format("-- %s -- \nRelease date: [%s] - Rated: [%s] \nDirector: %s - Distributed: %s \nNotes: %s",
                    currentDVD.getTitle(),
                    currentDVD.getDate(),
                    currentDVD.getRating(),
                    currentDVD.getDirector(),
                    currentDVD.getStudio(),
                    currentDVD.getNotes());
            io.print(DVDInfo);
        }
        io.readString("Please hit enter to continue");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            String DVDInfo = String.format("-- %s -- \nRelease date: [%s] - Rated: [%s] \nDirector: %s - Distributed: %s \nNotes: %s",
                    dvd.getTitle(),
                    dvd.getDate(),
                    dvd.getRating(),
                    dvd.getDirector(),
                    dvd.getStudio(),
                    dvd.getNotes());
            io.print(DVDInfo);
            io.readString("Please press enter to continue");
        } else {
            io.print("No such DVD");
        }
    }

    //TODO Create menu for user to choose what property of the DVD object a user wants to modify
    //TODO Get the user to return 'Y' or 'N' for confirmation methods (must be added to delete method in controller)
    //TODO Create a method that updates the DVD object as specified by user
    //TODO Create a method which searches the DVD list for a particular title. Use .contains String method.

    //TODO Later Add Exceptions and File persistence

    // this asks the user for the title of the movie that will be displayed by displayDVD: sent to DAO in controller
    public String getDvdTitleChoice() {
        return io.readString("Please enter the title of a DVD");
    }

    public void printCreateDVDBanner() {
        io.print("<<< CREATING A NEW DVD >>>");
    }

    public void printViewAllBanner() {
        io.print("<<< VIEW ALL DVDs >>>");
    }

    public void printDeleteBanner() {
        io.print("<<< DELETE A DVD >>>");
    }

    public void printViewBanner() {
        io.print("<<< VIEW A DVD >>>");
    }

    public void printEditBanner() {
        io.print("<<< EDIT A DVD FILE >>>");
    }

    public void printSearchBanner() {
        io.print("<<< SEARCH FOR A DVD >>>");
    }

    public void printSuccessBanner() {
        io.print("<<< SUCCESS >>>");
    }

    public void printUnknownCommandMessage() {
        io.print("!!! UNKNOWN COMMAND !!!");
    }

    public void printExitMessage() {
        io.print("--- THANK YOU ---");
    }

}
