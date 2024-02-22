package Assignment_6;

import java.util.List;

public interface Observer {
    // обработчик события привязываем к подписчику
    public void handleEvent (List<String> vacancies);
}
