package Bot2;

public class Food {

    String name;
    String tags;
    int group;
    int price;
    int index;
    Food[] links = {};

    Food(String name, String tags, int group, int price, int index) {
        this.name = name;
        this.tags = tags;
        this.group = group;
        this.price  = price;
        this.index = index;
    }

    void linkTo(Food[] meals) {
        int len = links.length;
        Food[] arr = new Food[len + meals.length];
        System.arraycopy(links, 0, arr, 0, len);
        System.arraycopy(meals, 0, arr, len, meals.length);
        links = arr;
    }
    void linkTo(Food meal) {
        linkTo(new Food[]{meal});
    }
    boolean isLinkedTo(Food meal) {
        for (Food m : links) if (m == meal) return true;
        return false;
    }
}
