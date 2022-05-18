package ru.netology.repository;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.exeptions.AlreadyExistsException;
import ru.netology.exeptions.NotFoundException;
import ru.netology.product.Book;
import ru.netology.product.Product;
import ru.netology.product.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    private Book firstBook = new Book(1, "Дневник охотника за ошибками. Путешествие через джунгли проблем безопасности программного обеспечения", 300, "Тобиас Клейн");
    private Book secondBook = new Book(2, "Тестирование программного обеспечения. Базовый курс", 550, "Святослав Куликов");
    private Book thirdBook = new Book(3, "Джоэл о программировании", 690, "Джоэл Спольски");
    private Book fourthBook = new Book(4, "Не заставляйте меня думать", 815, "Стив Круг");
    private Book fifthBook = new Book(5, "Джоэл. И снова о программировании", 950, "Джоэл Спольски");
    private Smartphone firstSmartphone = new Smartphone(6, "Xiaomi 11 Lite 5G NE 6/128 ГБ RU, зеленый", 26000, "Xiaomi");
    private Smartphone secondSmartphone = new Smartphone(7, "Xiaomi 12X 8/128 ГБ RU, фиолетовый", 46000, "Xiaomi");
    private Smartphone thirdSmartphone = new Smartphone(8, "Samsung Galaxy A53 5G 6/128 ГБ, белый", 39000, "Samsung");
    private Smartphone fourthSmartphone = new Smartphone(9, "Xiaomi Redmi 9T NFC 4/64 ГБ RU, синие сумерки", 17000, "Xiaomi");
    private Smartphone fifthSmartphone = new Smartphone(10, "Apple iPhone 12 64 ГБ, фиолетовый", 55000, "Apple");

    @BeforeEach
    public void setUp() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.save(thirdBook);
        repository.save(fourthBook);
        repository.save(fifthBook);
        repository.save(firstSmartphone);
        repository.save(secondSmartphone);
        repository.save(thirdSmartphone);
        repository.save(fourthSmartphone);
        repository.save(fifthSmartphone);
    }

    @Test
    void shouldRemoveById() {

        repository.removeById(2);

        Product[] actual = repository.findAll();
        Product[] expected = {firstBook, secondBook, thirdBook, fourthBook, fifthBook, firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone, fifthSmartphone};

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldNotRemoveByIdIfNotExist() {
        int removeId = 11;
        assertThrows(NotFoundException.class, () -> repository.removeById(removeId));
    }

    @Test
    void shouldAddNewProduct() {

        Product[] actual = repository.findAll();
        Product[] expected = {firstBook, secondBook, thirdBook, fourthBook, fifthBook, firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone, fifthSmartphone};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGenerateAlreadyExistsException() {


        assertThrows(AlreadyExistsException.class, () -> {
            repository.save(firstBook);
        });
    }

}