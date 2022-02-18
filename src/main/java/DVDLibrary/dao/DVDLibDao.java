package DVDLibrary.dao;

import DVDLibrary.dto.DVD;

import java.util.List;

public interface DVDLibDao {
        DVD addDVD(String title, DVD dvd) throws DVDLibDaoException;

        List<DVD> getAllDVDs() throws DVDLibDaoException;

        DVD getDVD(String title) throws DVDLibDaoException;

        DVD removeDVD(String title) throws DVDLibDaoException;

        List<DVD> searchForDVD(String searchTerm) throws DVDLibDaoException;

    }

