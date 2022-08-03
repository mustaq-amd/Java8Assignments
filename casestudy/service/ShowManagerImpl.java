package casestudy.service;

import casestudy.exception.InvalidShowTimeException;
import casestudy.exception.SeatsNotAvailableException;
import casestudy.exception.UnknownShowException;
import casestudy.model.Show;
import com.java8.assignments.day2.Question1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShowManagerImpl implements ShowManager{

    private List<Show> showList = new ArrayList<>();

    public List<Show> getShowList() {
        return showList;
    }

    public void setShowList(List<Show> showList) {
        this.showList = showList;
    }

    @Override
    public List<Show> populate(String fileName) throws IOException, ClassNotFoundException {

        FileReader fr=new FileReader(fileName);
        BufferedReader br=new BufferedReader(fr);

      br.lines().forEach(e-> {
            String[] arr = e.split(",");
            Show show = new Show();

            show.setShowName(arr[0].trim());
            show.setShowTime(arr[1].trim());
            show.setSeatsAvailable(Integer.parseInt(arr[2].trim()));

            showList.add(show);

        });

        return showList;
    }

    @Override
    public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats) throws UnknownShowException, InvalidShowTimeException, SeatsNotAvailableException {

        boolean isShowNamePresent = showList.stream().anyMatch(show->show.getShowName().equalsIgnoreCase(showName));
        boolean isShowTimePresent = showList.stream().anyMatch(show->show.getShowTime().equals(show_time));


        Predicate<Show> predicate1 = item -> item.getShowName().equalsIgnoreCase(showName);
        Predicate<Show> predicate2 = item -> item.getShowTime().equalsIgnoreCase(show_time);

        int noOfSeatsAvailable = getNoOfSeatsAvailable(predicate2.and(predicate1),showList);

        int availableSeats = noOfSeatsAvailable-noOfSeats;



        if(!isShowNamePresent){
            throw new UnknownShowException("Show Not Available");
        }else if(!isShowTimePresent){
            throw new InvalidShowTimeException("Show Time Not Available");
        }else if(availableSeats<0){
            throw new SeatsNotAvailableException("Available seats are "+noOfSeatsAvailable);
        }else{
            System.out.println("Congrats for the booking of "+showName+"Movie at "+show_time);
        }

    }

    public static int getNoOfSeatsAvailable(Predicate<Show> p,List<Show> showList){

        int seatsAvailable =0;
        for(Show show : showList){
            if(p.test(show)){
                seatsAvailable = show.getSeatsAvailable();
            }
        }

        return seatsAvailable;
    }

    public static void manageSeats(Show show){

    }
}
