package DVDLibrary.dao;

import DVDLibrary.dto.DVD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public DVD searchForDVD(String searchTerm) {
        return null;
    }
}
