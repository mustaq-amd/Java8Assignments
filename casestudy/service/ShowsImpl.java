package casestudy.service;

import casestudy.model.Show;

import java.util.List;

public class ShowsImpl implements Shows {
    ShowManagerImpl showManager = new ShowManagerImpl();
    @Override
    public void displayAllShows(List<Show> showList) {

        System.out.println("Show Name Show Time  Seats Available");
        System.out.println("====================================");
        showList.stream().forEach(show -> {
            System.out.println(show.getShowName()+" "+show.getShowTime()+" "+show.getSeatsAvailable());
        });

    }
}
