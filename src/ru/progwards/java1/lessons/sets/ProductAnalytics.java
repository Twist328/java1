package ru.progwards.java1.lessons.sets;


import java.util.*;

class Product {

    private String code; //уникальный артикул товара
    public Product(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return code;
    }
}
class Shop {

    private List<Product> products; //товары имеющиеся в магазине
    public Shop(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
}

public class ProductAnalytics {

    private List<Shop> shops; //список магазинов

    private List<Product> products; //список всех товаров

    public ProductAnalytics(List<Product> products, List<Shop> shops) {

        this.shops = shops;
        this.products = products;

    }

    public  Set<Product> existInAll() {//товары  которые имеются во всех магазинах

        if (products == null || products.size() == 0) return new HashSet<>();

        if (shops == null || shops.size() == 0) return new HashSet<>();

        Set<Product> shops = new HashSet<Product>(products);//*

        Iterator it = shops.iterator();

        while (it.hasNext()) {

            products.retainAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        return shops;

    }

    public Set<Product> existAtLeastInOne() {//товары из products, которые имеются хотя бы в одном магазине

        return existAtListInOne();

    }

    public Set<Product> existAtListInOne() {

        if (shops == null || shops.size() == 0) return new HashSet<>();

        Iterator it = shops.iterator();

        Set<Product> products = new HashSet<Product>(((Shop) it.next()).getProducts());

        while (it.hasNext()) {

            products.addAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        products.retainAll(products);

        return products;

    }

    public  Set<Product> notExistInShops() {//товары из products, которых нет ни в одном магазине


        if (products == null || products.size() == 0) return new HashSet<>();

        Set<Product> shops= new HashSet<Product>(products);//*

        if (shops == null || shops.size() == 0) return shops;

        Iterator it = shops.iterator();

        while (it.hasNext()) {

            products.removeAll(new HashSet<Product>(((Shop) it.next()).getProducts()));

        }

        return shops;

    }

    public Set<Product> existOnlyInOne() {

        Set<Product> products = new HashSet<Product>();

        if (products == null || products.size() == 0) return products;

        if (shops == null || shops.size() == 0) return products;

        for (int i = 0; i < shops.size(); i++) {

            Set<Product> productsBefore = new HashSet<Product>();

            Set<Product> products1 = new HashSet<Product>();

            Set<Product> productsNow;

            Iterator it = shops.iterator();

            for (int k = 0; k < shops.size(); k++) {

                productsNow = new HashSet<Product>(((Shop) it.next()).getProducts());

                productsNow.retainAll(products);

                if (k < i) {

                    productsBefore.addAll(productsNow);

                } else if (k == i) {

                    products1 = productsNow;

                    products1.removeAll(productsBefore);

                } else {

                    products1.removeAll(productsNow);

                }

            }

            products.addAll(products1);

        }
        return products;

    }

    public static void main(String[] args) {

        Set<Product> products = new HashSet<Product>();


       // System.out.println(existInAll());
       // System.out.println(notExistInShops());

    }
}