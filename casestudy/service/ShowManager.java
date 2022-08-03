package casestudy.service;

import casestudy.exception.InvalidShowTimeException;
import casestudy.exception.SeatsNotAvailableException;
import casestudy.exception.UnknownShowException;
import casestudy.model.Show;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ShowManager {

    public List<Show> populate(String fileName) throws IOException, ClassNotFoundException;
    public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws UnknownShowException, InvalidShowTimeException, SeatsNotAvailableException;

}
