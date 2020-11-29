package ru.progwards.java1.lessons.sets;

import java.util.List;
import java.util.Set;

public class Product {

    private String code;

    public String getCode() {
        return code;
    }

    public Product(String code) {
        this.code = code;
    }

    class Shop {

        private List<Product> products;

        public Shop(List<Product> products) {
            this.products = products;
        }

        public List<Product> getProducts() {
            return products;
        }

        class ProductAnalytics {
            private List<Shop> shops;
            private List<Product> products;

            public ProductAnalytics(List<Product> products, List<Shop> shops) {
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
    }
}


