package Goon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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

class ProductAnalytics {
    private List<Shop> shops; //список магазинов
    private List<Product> bestproducts; //список всех товаров

    public ProductAnalytics(List<Product> products, List<Shop> shops) {
        this.shops = shops;
        this.bestproducts = products;
    }

    public Set<Product> existInAll() {     //товары из products, которые имеются во всех магазинах
        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<Product>();
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Set<Product> res = new HashSet<Product>(bestproducts);
        Iterator iter = shops.iterator();
        while (iter.hasNext()) {
            res.retainAll(new HashSet<Product>(((Shop) iter.next()).getProducts())); // удаляет элементы, не принадлежащие переданному товару
        }
        return res;
    }

    public Set<Product> existAtListInOne() {     //товары из products, которые имеются хотя бы в одном магазине
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Iterator iter = shops.iterator();
        Set<Product> products = new HashSet<Product>(((Shop) iter.next()).getProducts());
        while (iter.hasNext()) {
            products.addAll(((Shop) iter.next()).getProducts());
        }
        products.retainAll(products);
        return products;

    }

    public Set<Product> notExistInShops() {//товары из products, которых нет ни в одном магазине
        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<>();
        Set<Product> res = new HashSet<Product>(bestproducts);
        if (shops == null || shops.size() == 0) return res;
        Iterator iter = shops.iterator();
        while (iter.hasNext()) {
            res.removeAll(new HashSet<Product>(((Shop) iter.next()).getProducts()));
        }
        return res;
    }

    public Set<Product> existOnlyInOne() {   //товары из products, которые есть только в одном магазине

        Set<Product> products = new HashSet<Product>();
        if (bestproducts == null || bestproducts.size() == 0) return products;
        if (shops == null || shops.size() == 0) return products;
        for (int i = 0; i < shops.size(); i++) {
            Set<Product> res1 = new HashSet<Product>();
            Set<Product> res2;
            Set<Product> res3 = new HashSet<Product>();
            Iterator iterator = shops.iterator();
            for (int j = 0; j < shops.size(); j++) {
                res2 = new HashSet<Product>(((Shop) iterator.next()).getProducts());
                res2.retainAll(bestproducts);
                if (j < i) {
                    res3.addAll(res2);
                } else if (j == i) {
                    res1 = res2;
                    res1.removeAll(res3);
                } else {
                    res1.removeAll(res2);
                }

            }
            products.addAll(res1);
        }
        return products;
    }
}
