package books;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
    private List<Book> books;
    private BookService bookService;
    private BookRepository bookRepositoryMock;

    @BeforeEach
    public void setup() {
        // #region создадим коллекцию книг
        books = new ArrayList<>();
        books.add(new Book("someId1", "BookTitle1", "Autor1"));
        books.add(new Book("someId2", "BookTitle2", "Autor2"));
        books.add(new Book("someId3", "BookTitle3", "Autor3"));
        books.add(new Book("someId4", "BookTitle4", "Autor4"));
        // #endregion

        bookRepositoryMock = mock(BookRepository.class); // создаем класс - заглушку
        bookService = new BookService(bookRepositoryMock); // создаем сервис и передаем туда заглушку интерфейса BookRepository
    }

    @AfterEach
    public void teardown() {
        books = null;
        bookRepositoryMock = null;
        bookService = null;
    }

    @Test
    @DisplayName("Проверка метода BookService.findBookById(string)")
    public void BookService_findBookByIdTest1(){

        when(bookRepositoryMock.findById("someId1")).thenReturn(books.get(0)); //имитируем поведение метода findById()
        
        assertEquals(books.get(0), bookService.findBookById("someId1")); // проверим корректность 

        // проверим что метод Repository.findById(string) был вызван с ожидаемым аргументом "someId1"
        verify(bookRepositoryMock).findById("someId1");       
    }

    @Test
    @DisplayName("Проверка метода BookService.findAll()")
    public void BookService_findAllTest(){
        //имитируем поведение метода BookRepository.findAll() взвращая всю коллекцию книг
        when(bookRepositoryMock.findAll()).thenReturn(books);

        assertEquals(books, bookService.findAllBooks()); // проверим корректность     
     
        // проверим что метод Repository.findAll() был вызван
        verify(bookRepositoryMock).findAll();               
    }

}

