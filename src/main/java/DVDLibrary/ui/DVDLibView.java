package DVDLibrary.ui;

import DVDLibrary.dto.DVD;

import java.util.List;

public class DVDLibView {
    private UserIO io;

    public DVDLibView(UserIO io) {
        this.io = io;
    }

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
            String DVDInfo = String.format("===<>===<>=== %s ===<>===<>=== \nRelease date: [%s] - Rated: [%s] \nDirector: %s - Distributed: %s \nNotes: %s",
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
            String DVDInfo = String.format("===<>===<>=== %s ===<>===<>=== \nRelease date: [%s] - Rated: [%s] \nDirector: %s - Distributed: %s \nNotes: %s",
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

    public int printEditMenu() {
        io.print("EDIT MENU");
        io.print("1. Edit title");
        io.print("2. Edit release date");
        io.print("3. Edit MPAA rating");
        io.print("4. Edit director");
        io.print("5. Edit studio");
        io.print("6. Edit notes");
        io.print("7. Exit");

        return io.readInt("Please select a menu option", 1, 7);
    }


    // EDIT MENU SELECTIONS
    public String printEditTitle() { return io.readString("Please enter the new title");}

    public String printEditDate() { return io.readString("Please enter new release date");}

    public String printEditRating() {return io.readString("Please enter new rating");}

    public String printEditDirector() {return io.readString("Please enter new director");}

    public String printEditStudio() {return io.readString("Please enter new distributor");}

    public String printEditNotes() {return io.readString("Please enter new notes");}

    public String getSearchTerm() {return io.readString("Please enter search keyword");}

    // this is used for confirmation when a user wants to remove a DVD
    public int getConfirmYN() {
        return io.readInt("Confirm? 1. Yes / 2. No", 1, 2);
    }

    // this asks the user for the title of the movie that will be displayed by displayDVD: sent to DAO in controller
    public String getDvdTitleChoice() {
        return io.readString("Please enter the title of a DVD");
    }


    //MISC banners for menu elements

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
        io.readString("Press enter to continue"); // ensures the user sees their operation was successful
    }

    public void printUnknownCommandMessage() {
        io.print("!!! UNKNOWN COMMAND !!!");
    }

    public void printExitMessage() {
        io.print("--- THANK YOU ---");
    }

    public void printCancel() { io.readString(" --- CANCELING OPERATION ---"); }

    public void displayErrorMessage(String errorMsg) {
        io.print("!!! ERROR !!!");
        io.print(errorMsg);
    }

}
