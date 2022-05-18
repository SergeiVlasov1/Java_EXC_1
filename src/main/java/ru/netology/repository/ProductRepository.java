package ru.netology.repository;

import ru.netology.exeptions.AlreadyExistsException;
import ru.netology.exeptions.NotFoundException;
import ru.netology.product.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) throws NotFoundException {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    public void save(Product product) throws AlreadyExistsException {
        for (Product product : products) {
            if (existing) {
                throw new AlreadyExistsException("Element with id: " + id + " already exists");
            }
        }
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;
    }

    public void removeById(int id) throws NotFoundException {

        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
