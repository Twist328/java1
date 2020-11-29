package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;

public  class ProductAnalytics {
    private List<Product.Shop> shops;
    private List<Product> products;

    public ProductAnalytics(List<Product> products, List<Product.Shop> shops) {
        this.products = products;
        this.shops = shops;
    }


    public Set<Product> existInAll() {
        return existInAll() ;
    }
    public Set<Product> existAtListInOne(){

        return existAtListInOne();
    }
    public Set<Product> notExistInShops(){

        return notExistInShops();
    }
    public Set<Product> existOnlyInOne(){

        return existOnlyInOne();
    }
}


