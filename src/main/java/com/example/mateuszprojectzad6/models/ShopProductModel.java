package com.example.mateuszprojectzad6.models;

import javax.enterprise.inject.Model;
import java.util.List;

@Model
public class ShopProductModel
{

    private List<ShopProduct> shopProducts;

    public List<ShopProduct> findAll() {
        return this.shopProducts;
    }

    public ShopProduct find(String id) {
        for (ShopProduct shopProduct : this.shopProducts) {
            if (shopProduct.getId().equalsIgnoreCase(id)) {
                return shopProduct;
            }
        }
        return null;
    }

}
