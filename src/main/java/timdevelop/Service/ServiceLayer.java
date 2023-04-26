package timdevelop.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import timdevelop.DB.Product;
import timdevelop.DAO.*;

@Service
public class ServiceLayer {

    @Autowired
    DAOlayer userRepository;

    public List<Product> getDB() {
        return userRepository.findAll();
    }

    public Integer getDbSize() {
        return userRepository.findAll().size();
    }

    public String getId(Integer num) {
        return userRepository.findAll().get(num).getId();
    }

    public String getName(Integer num) {
        return userRepository.findAll().get(num).getName();
    }

    public Integer getPrice(Integer num) {
        return userRepository.findAll().get(num).getPrice();
    }

    public Product getProduct(Integer num) {
        return userRepository.findAll().get(num);
    }

    public void addProduct(Product product) {
        userRepository.save(product);
    }

    public void removeProduct(int num) {
        userRepository.deleteById(userRepository.findAll().get(num).getId());
    }

    // @PostConstruct
    // public void initDB() {
    //     System.out.println("---initialize database---");
    //     userRepository.save(new Product("B0001", "Android Development (Java)", 380));
    //     userRepository.save(new Product("B0002", "Android Development (Kotlin)", 420));
    //     userRepository.save(new Product("B0003", "Data Structure (Java)", 250));
    //     userRepository.save(new Product("B0004", "Finance Management", 450));
    //     userRepository.save(new Product("B0005", "Human Resource Management", 330));
    // }

}
