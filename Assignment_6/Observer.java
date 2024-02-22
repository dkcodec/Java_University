package Assignment_6;

import java.util.List;

public interface Observer {
    // обработчик события
    public void handleEvent (List<String> vacancies);
}
