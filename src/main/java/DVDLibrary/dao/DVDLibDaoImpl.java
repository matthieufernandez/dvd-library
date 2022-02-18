package DVDLibrary.dao;

import DVDLibrary.dto.DVD;

import java.util.*;

public class DVDLibDaoImpl implements DVDLibDao {
    private Map<String, DVD> DVDs = new HashMap<>();
    public static final String DVD_FILE = "DVDcollection.txt";
    public static final String DELIMETER = "::";

    @Override
    public DVD addDVD(String title, DVD dvd) {
        DVD prevDVD = DVDs.put(title, dvd);
        return prevDVD;
    }

    @Override
    public List<DVD> getAllDVDs() {
        return new ArrayList<DVD>(DVDs.values());
    }

    @Override
    public DVD getDVD(String title) {
        return DVDs.get(title);
    }

    @Override
    public DVD removeDVD(String title) {
        return DVDs.remove(title);
    }

    // TODO use searchTerm to look through values and find a match in the Object parameters
    @Override
    public List<DVD> searchForDVD(String searchTerm) {
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
