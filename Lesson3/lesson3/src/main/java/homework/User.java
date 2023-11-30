package homework;

public class User {
// немного улучшим класс (сделаем приватные поля, добавим gettеры...)
    private String name;    
    public String getName() {
        return name;
    }

    private String password;    
    public String getPassword() {
        return password;
    }

    private boolean isAdmin;
    public boolean getIsAdmin(){
        return isAdmin;
    }

    private boolean isAuthenticate = false;
    public boolean getIsAuthenticate(){
        return isAuthenticate;
    }

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * Авторизация пользователя
     * @param name
     * @param password
     * @return true - пользователь успешно авторизован
     */
    public boolean authenticate(String name, String password) {
        isAuthenticate = this.name == name && this.password == password;
        return isAuthenticate;
    }

    /**
     * Метод завершения сеанса пользователя
     */
    public void logOut(){
        isAuthenticate = false;
    }

}