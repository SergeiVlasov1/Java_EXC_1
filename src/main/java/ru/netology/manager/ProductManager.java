package ru.netology.manager;


import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.product.Product;
import ru.netology.repository.ProductRepository;

@Data
@NoArgsConstructor
public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product,text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName()
                .contains(search)) {
            return product.getName()
                    .contains(search);
        }
        return false;
    }
}
