package com.tim.common.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @NotNull(message = "id cannot be null")
    private String id;

    private String name;

    private int price;

    // valid description
    @Valid
    private Description description;

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id=id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public Integer getPrice(){
        return this.price;
    }

    public void setPrice(Integer price){
        this.price=price;
    }
}
