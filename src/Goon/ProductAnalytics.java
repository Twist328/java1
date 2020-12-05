package Goon;

import java.util.*;

class Product0 {

    private String code; //уникальный артикул товара

    public Product0(String code) {
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
    private List<Product0> products; //товары имеющиеся в магазине

    public Shop(List<Product0> products) {
        this.products = products;
    }

    public List<Product0> getProducts() {
        return products;
    }
}

public class ProductAnalytics {
    private List<Shop> shops; //список магазинов
    private List<Product0> bestproducts; //список всех товаров

    public ProductAnalytics(List<Product0> products, List<Shop> shops) {
        this.shops = shops;
        this.bestproducts = products;
    }

    public Set<Product0> existInAll() {     //товары из products, которые имеются во всех магазинах

        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<Product0>();
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Set<Product0> res = new HashSet<Product0>(bestproducts);
        Iterator iter = shops.iterator();
        while (iter.hasNext()) {
            res.retainAll(new HashSet<Product0>(((Shop) iter.next()).getProducts())); // удаляет элементы, не принадлежащие переданному товару
        }
        return res;
    }

    public Set<Product0> existAtListInOne() {     //товары из products, которые имеются хотя бы в одном магазине
        if (shops == null || shops.size() == 0) return new HashSet<>();
        Iterator iter = shops.iterator();
        Set<Product0> products = new HashSet<Product0>(((Shop) iter.next()).getProducts());
        while (iter.hasNext()) {
            products.addAll(((Shop) iter.next()).getProducts());
        }
        products.retainAll(products);
        return products;

    }

    public Set<Product0> notExistInShops() {//товары из products, которых нет ни в одном магазине
        if (bestproducts == null || bestproducts.size() == 0) return new HashSet<>();
        Set<Product0> res = new HashSet<Product0>(bestproducts);
        if (shops == null || shops.size() == 0) return res;
        Iterator iter = shops.iterator();
        while (iter.hasNext()) {
            res.removeAll(new HashSet<Product0>(((Shop) iter.next()).getProducts()));
        }
        return res;
    }

    public Set<Product0> existOnlyInOne() {   //товары из products, которые есть только в одном магазине

       Set<Product0>products=new HashSet<Product0>();
       if(bestproducts==null||bestproducts.size()==0)return products;
       if(shops==null||shops.size()==0)return products;

        for (int i = 0; i < shops.size(); i++) {

            Set<Product0>res1=new HashSet<Product0>();
            Set<Product0>res2;
            Set<Product0>res3=new HashSet<Product0>();

            Iterator iterator= shops.iterator();

            for (int j = 0; j < shops.size(); j++) {

                res2=new HashSet<Product0>(((Shop)iterator.next()).getProducts());
                res2.retainAll(bestproducts);

                if(j<i){
                    res3.addAll(res2);

                }else if(j==i){
                    res1=res2;
                    res1.removeAll(res3);

                }else {
                    res1.removeAll(res2);
                }
            }
            products.addAll(res1);
        }
        return products;
    }

    public static void main(String[] args) {

        Product0 products1 = new Product0("art-1");
        Product0 products2 = new Product0("art-2");
        Product0 products3 = new Product0("art-3");
        Product0 products4 = new Product0("art-4");
        Product0 products5 = new Product0("art-5");
        Product0 products6 = new Product0("art-6");
        Product0 products7 = new Product0("art-7");
        Product0 products8 = new Product0("art-8");
        Product0 products9 = new Product0("art-9");
        Product0 products10 = new Product0("art-10");

        Shop shops1 = new Shop(new ArrayList<Product0>(Arrays.asList(products2, products7, products10, products9)));
        Shop shops2 = new Shop(new ArrayList<Product0>(Arrays.asList(products1, products10, products6, products9)));
        Shop shops3 = new Shop(new ArrayList<Product0>(Arrays.asList(products1,products4, products5, products9)));
        List<Shop> shops = new ArrayList<Shop>(Arrays.asList(shops1, shops2, shops3));
        List<Product0> products = new ArrayList<Product0>(Arrays.asList(products10, products7, products8, products9));
        ProductAnalytics productAnalytics = new ProductAnalytics(products, shops);

        System.out.println(productAnalytics.existInAll());
        System.out.println(productAnalytics.existAtListInOne());
        System.out.println(productAnalytics.notExistInShops());
        System.out.println(productAnalytics.existOnlyInOne());

    }
}


