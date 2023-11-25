package homework;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    public List<User> data = new ArrayList<>();

    /**
     * метод добавляет нового пользователя
     * 
     * @param user
     * @return true - пользователь успешно добавлен
     */
    public boolean addUser(User user) {
        if (findByName(user.getName()))
            return false; // такой пользователь уже есть!
        data.add(user);
        return true;
    }

    /**
     * метод проверяет существование пользователя с указанным именем
     * 
     * @param username
     * @return true - пользователь с таким именем существует
     */
    public boolean findByName(String username) {
        for (User user : data) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Метод разлогинивает всех пользователей кроме админов
     */
    public void closeAllButAdmins() {
        for (User user : data) {
            if (user.getIsAdmin())
                continue;
            user.logOut();
            ;
        }
    }

}