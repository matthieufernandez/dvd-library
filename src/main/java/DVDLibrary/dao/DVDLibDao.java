package DVDLibrary.dao;

import DVDLibrary.dto.DVD;

import java.util.List;

public interface DVDLibDao {
        DVD addDVD(String title, DVD dvd);

        List<DVD> getAllDVDs();

        DVD getDVD(String title);

        DVD removeDVD(String title);

        DVD searchForDVD(String searchTerm);

    }

