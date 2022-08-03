package casestudy.service;

import casestudy.model.Show;

import java.util.List;

@FunctionalInterface
public interface Shows {

    public void displayAllShows(List<Show> showList);
}
