package Assignment_6;

public class JobSearch {
    public static void main(String[] args) {
        // Создаю веб сайт
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        // Добавляю Вакансии на сайт
        jobSite.addVacancy("First Java position");
        jobSite.addVacancy("Second Java position");

        // Созадаю 2х подписчиков
        Observer firstSubscriber = new Subscriber("Dmitriy Kairgeldin");
        Observer secondSubscriber = new Subscriber("Ayanat Zhunis");

        // Добавляю их на сайт
        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        // Добавляю вакансию, происходит уведомление всех подписчиков!(главная идея Observer pattern соблюдена)
        jobSite.addVacancy("Third Java position");

        // Удаляю вакансию и получаю уведомление о изменении списка вакансий.
        jobSite.removeVacancy("First Java position");
    }
}
