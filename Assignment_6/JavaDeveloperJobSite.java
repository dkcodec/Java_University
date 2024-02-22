package Assignment_6;

import java.util.ArrayList;
import java.util.List;

public class JavaDeveloperJobSite implements Observed{

    List<String> vacancies = new ArrayList<>();
    List<Observer> subscribers = new ArrayList<>();

    public void addVacancy(String vacancy){
        this.vacancies.add(vacancy);
        notifyObservers();
    }

    public void removeVacancy(String vacancy){
        this.vacancies.remove(vacancy);
        notifyObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscribers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscribers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer sub: subscribers){
            sub.handleEvent(this.vacancies);
        }
    }
}
