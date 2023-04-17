package timdevelop.DAO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import timdevelop.DB.Product;

@Repository
public interface DAOlayer extends MongoRepository<Product, String> {

}
