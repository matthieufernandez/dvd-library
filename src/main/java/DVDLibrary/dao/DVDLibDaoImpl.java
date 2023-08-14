package DVDLibrary.dao;

import DVDLibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibDaoImpl implements DVDLibDao {
    private final Map<String, DVD> DVDs = new HashMap<>();
    public static final String DVD_FILE = "DVDcollection.txt";
    public static final String DELIMITER = "::";

    private DVD unmarshallDVDs(String DVDAsText) {
        String[] DVDIndex = DVDAsText.split(DELIMITER);
        String DVDTitle = DVDIndex[0];
        DVD FileDVD = new DVD(DVDTitle);

        FileDVD.setTitle(DVDIndex[0]);
        FileDVD.setDate(DVDIndex[1]);
        FileDVD.setRating(DVDIndex[2]);
        FileDVD.setDirector(DVDIndex[3]);
        FileDVD.setStudio(DVDIndex[4]);
        FileDVD.setNotes(DVDIndex[5]);

        return FileDVD;
    }

    private String marshallDVD(DVD aDVD) {
        String DVDAsText = aDVD.getTitle() + DELIMITER;

        DVDAsText += aDVD.getDate() + DELIMITER;
        DVDAsText += aDVD.getRating() + DELIMITER;
        DVDAsText += aDVD.getDirector() + DELIMITER;
        DVDAsText += aDVD.getStudio() + DELIMITER;
        DVDAsText += aDVD.getNotes() + DELIMITER;

        return DVDAsText;
    }

    private void loadDVDs() throws DVDLibDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibDaoException(
                    "!!! COULD NOT LOAD COLLECTION INTO MEMORY !!!", e);
        }

        String currentLine;

        DVD currentDVD;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVDs(currentLine);
            DVDs.put(currentDVD.getTitle(), currentDVD);
        }

        scanner.close();

    }

    public void writeDVD() throws DVDLibDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_FILE));
        } catch (IOException e) {
            throw new DVDLibDaoException (
                    "!!! COULD NOT SAVE DVD DATA !!!", e);
        }

        String DVDAsText;
        List<DVD> DVDsList = this.getAllDVDs();
        for (DVD currentDVD : DVDsList) {
            DVDAsText = marshallDVD(currentDVD);
            out.println(DVDAsText);
            out.flush();
        }
        out.close();
    }


    @Override
    public DVD addDVD(String title, DVD dvd) throws DVDLibDaoException {
        loadDVDs();
        DVD newDVD = DVDs.put(title, dvd);
        writeDVD();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs() throws DVDLibDaoException {
        loadDVDs();
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) throws DVDLibDaoException {
        loadDVDs();
        return DVDs.get(title);
    }

    @Override
    public DVD removeDVD(String title) throws DVDLibDaoException {
        loadDVDs();
        DVD removedDVD = DVDs.remove(title);
        writeDVD();
        return removedDVD;
    }

    // TODO use searchTerm to look through values and find a match in the Object parameters
    @Override
    public List<DVD> searchForDVD(String searchTerm) throws DVDLibDaoException {
        loadDVDs();
        List<DVD> returnList = new ArrayList<>();
        Set<String> titles = DVDs.keySet();
        for (String t: titles) {
            String formattedKey = String.format("%S", t);
            if (formattedKey.contains(searchTerm)) {
                DVD responseDVD = DVDs.get(t);
                returnList.add(responseDVD);

            }
        }
        return returnList;
    }
}
