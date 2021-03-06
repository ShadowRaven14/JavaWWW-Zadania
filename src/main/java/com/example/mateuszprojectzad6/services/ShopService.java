package com.example.mateuszprojectzad6.services;

import java.util.Optional;

import com.example.mateuszprojectzad6.models.ShopProduct;
import com.example.mateuszprojectzad6.repositories.ShopProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService
{

    @Autowired
    private ShopProductRepository shopProductRepository;

    //@Autowired
    //private ShopItemRepository shopItemRepository;


    public ShopProduct addShopProduct(ShopProduct product) {
        shopProductRepository.save(product);
        return product;
    }

    public java.util.List<ShopProduct> getShopProducts() {
        return shopProductRepository.findAll();
    }

    public void deleteShopProduct(Long id) throws NoSuchFieldException {
        if (shopProductRepository.findById(id).isEmpty()) {
            throw new NoSuchFieldException();
        }
        shopProductRepository.deleteById(id);
    }

    public ShopProduct getShopProductById(Long id) {
        Optional<ShopProduct> optional = shopProductRepository.findById(id);

        ShopProduct product = null;

        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Kategoria nie znaleziona dla szukanego id :: " + id);
        }
        return product;
    }

    /*
    public ShopItem getItem(int id)
    {
        return item;
    }

    public void addToCart(ShopItem shopItem2Add)
    {
    }

    public FetchProfile getCart()
    {

    }
     */
}
