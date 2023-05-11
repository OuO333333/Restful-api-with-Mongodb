package com.tim.dao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.tim.common.entity.Product;

public class ProductDAOMongoTemplate {
    @Autowired
    private MongoTemplate mongoTemplate;

    public Product insert(Product t) {
        if (t == null) {
            return t;
        }
        try {
            this.mongoTemplate.save(t);
        } catch (DuplicateKeyException e) {
            // log.error("db insert error, -{}", Utils.getErrorMsg(e));
            // Locale locale = LocaleContextHolder.getLocale();
            // String message = messageSource.getMessage("common.data.used", null, locale);
            // throw new ServiceException(DViewError.ErrorTag.INVALID_VALUE, message, "common.data.used", null);
        }

        return t;
    }

}
