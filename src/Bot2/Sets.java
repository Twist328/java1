package Bot2;

public class Sets {

    Food[] foods = {};
    GreatSmartBot bot;


    Sets(){}

    Sets(GreatSmartBot bot) {
        this.bot = bot;
    }

    int add(Food meal) {
        int len = foods.length;
        Food[] array = new Food[len + 1];
        System.arraycopy(foods, 0, array, 0, len);
        array[len] = meal;
        foods = array;
        return len;
    }
    Food add(String name, String tags, int group, int cost) {
        Food f1 = new Food("Тянь шань 360р.", "ролл, шань, тянь, снежный краб, краб, огурец, сливочный сыр, угорь, лосось", 1, 360, foods.length);
        Food f2 = new Food("Филадельфия Классик 360р.", "ролл, классик, филадельф, сливочный сыр, лосось", 1, 360, foods.length);
        Food f3 = new Food("Спайси краб 280р.", "ролл, спайси, снежный краб, краб, икра лосося, спайси соус", 1, 280, foods.length);
        Food f4 = new Food("Унаги филадельфия 360р.", "ролл, унаги, филадельф, угорь, сливочный сыр, лосось, соус унаги", 1, 360, foods.length);
        Food f5 = new Food("Самурай 320р.", "ролл, самурай, креветка тигр, лосос, томат", 1, 320, foods.length);
        Food f6 = new Food("Аляска 270р.", "ролл, аляск, сливочный сыр, креветк, огурец, укроп, икра", 1, 270, foods.length);
        Food f7 = new Food("Горячая тортилья 270р.", "ролл, тортил, говя, сливочный сыр, помид, огур, лук", 1, 270, foods.length);

        Food f8=new Food("Торт тирамису, 110р.", "десерт, маскарпоне, бисквит", 3, 110, foods.length);
        Food f9=new Food("Торт медовик, 80р.", "десерт, мед, бисквит", 3, 80, foods.length);
        Food f10=new Food("Эклеры, 70р.", "десерт, заварной, крем, тесто,эклер,Эклер", 3, 70, foods.length);

        Food f11=new Food("Имбирный компот 1л. 140р.", "напит, компот", 4, 140, foods.length);
        Food f12=new Food("Кола, 80р.", "напит, пить, кола", 4, 80, foods.length);
        Food f13=new Food("Холодный чай, 70р.", "напит, пить, чай, липтон, лимон", 4, 70, foods.length);
        Food f14=new Food("Сок, 60р.", "напит, пить, сок, апельсиноый, яблочный, вишневый", 4, 60, foods.length);
        Food f15=new Food("Кофе Капучино, 160р.", "напит, пить, кофе, Капучино, взбитые сливки, сахар", 4, 160, foods.length);
        Food f16=new Food("Кофе Эспрессо, 160р.", "напит, пить, кофе,  Эспрессо", 4, 160, foods.length);
        Food f17=new Food("Кофе Американо, 160р.", "напит, пить, кофе,  Амнрикано", 4, 160, foods.length );

        add(f1);add(f2);add(f3);add(f4);add(f5);add(f6);add(f7);add(f8);add(f9);add(f10);add(f11);add(f12);add(f13);add(f14);add(f15);
        add(f16); add(f17);

        return f17;
    }

    void del(int pos) {
        Food[] arr = new Food[foods.length - 1];
        System.arraycopy(foods, 0, arr, 0, pos);
        System.arraycopy(foods, pos + 1, arr, pos, foods.length - pos - 1);
        foods = arr;
    }

    void del(Food meal) {
        for (int i = 0; i < foods.length; i++) if (foods[i] == meal) { del(i); return; }
    }

    void fillTags() {
        for (Food m : foods) bot.addTags(m.name, m.tags);
    }

    Food getMeal(String name) {
        for (Food m : foods) if (m.name.compareTo(name) == 0) return m;
        return null;
    }
    Food getMeal(GreatSmartBot.FoundTags tags) {
        for (Food m : foods) if (bot.checkLastFound(tags, m.name)) return m;
        return null;
    }

}