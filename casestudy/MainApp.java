package casestudy;

import casestudy.exception.InvalidShowTimeException;
import casestudy.exception.SeatsNotAvailableException;
import casestudy.exception.UnknownShowException;
import casestudy.model.Show;
import casestudy.service.ShowManager;
import casestudy.service.ShowManagerImpl;
import casestudy.service.Shows;
import casestudy.service.ShowsImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ShowManager showManager = new ShowManagerImpl();
        Shows shows = new ShowsImpl();

        List<Show> showList = showManager.populate("C:\\MyJavaApps\\Practice\\src\\casestudy\\show.txt");
        shows.displayAllShows(showList);

        try {
                showManager.bookShow(showList,"RRR","12:00",10);
        } catch (UnknownShowException e) {
            e.printStackTrace();
        } catch (InvalidShowTimeException e) {
            e.printStackTrace();
        } catch (SeatsNotAvailableException e) {
            e.printStackTrace();
        }


    }
}
