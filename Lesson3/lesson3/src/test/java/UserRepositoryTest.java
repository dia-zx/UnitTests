
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import homework.User;
import homework.UserRepository;

public class UserRepositoryTest {
    private UserRepository repository;
    
    @BeforeEach // метод будет выполняться каждый раз перед каждым тестом
    public void setup() {
        repository = new UserRepository(); // создадим экземпляр класса UserRepository методы которого будем тестировать
    }

    @AfterEach // метод будет выполняться каждый раз после каждого теста
    public void teardown() {
        repository = null; // убираем указатель с экземпляра класса UserRepository
    }    

    @Test
    @DisplayName("проверка метода UserRepository.closeAllButAdmins() на произвольных пользователях")
    public void closeAllButAdmins_AllAdminsTest(){
        // repository = new UserRepository();
        //#region создадим пользователей
        User user;
        user = new User("Pers1", "1", false); user.authenticate("Pers1", "1");
        repository.addUser(user);

        user = new User("Pers2", "1", true); user.authenticate("Pers2", "1");
        repository.addUser(user);

        user = new User("Pers3", "1", false);
        repository.addUser(user);        

        user = new User("Pers4", "1", true); user.authenticate("Pers4", "1");
        repository.addUser(user);

        user = new User("Pers5", "1", false); user.authenticate("Pers5", "1");
        repository.addUser(user);
        
        user = new User("Pers6", "1", true); 
        repository.addUser(user);
        //#endregion

        repository.closeAllButAdmins();

        assertEquals(false, repository.data.get(0).getIsAuthenticate());
        assertEquals(true, repository.data.get(1).getIsAuthenticate());
        assertEquals(false, repository.data.get(2).getIsAuthenticate());
        assertEquals(true, repository.data.get(3).getIsAuthenticate());
        assertEquals(false, repository.data.get(4).getIsAuthenticate());
        assertEquals(false, repository.data.get(5).getIsAuthenticate());
    }

}
