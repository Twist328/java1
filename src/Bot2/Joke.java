package Bot2;

/*public class Joke {
    String name;
    String tags;
    int group;
    int price;
    int index;
    Joke[] links = {};

    Joke(String name, String tags, int group, int price, int index) {
        this.name = name;
        this.tags = tags;
        this.group = group;
        this.price = price;
        this.index = index;
    }

    void linkTo(Joke[] jokes) {
        int len = links.length;
        Joke[] arr = new Joke[len + jokes.length];
        System.arraycopy(links, 0, arr, 0, len);
        System.arraycopy(jokes, 0, arr, len, jokes.length);
        links = arr;
    }

    void linkTo(Joke joke) {
        linkTo(new Joke[]{joke});
    }

    boolean isLinkedTo(Joke joke) {
        for (Joke j : links) if (j == joke) return true;
        return false;
    }


    Joke[] jokes = {};
    GreatSmartBot bot;

    Joke() {
    }

    public Joke(GreatSmartBot bot) {
        this.bot = bot;
    }

    int add(Joke joke) {
        int len = jokes.length;
        Joke[] array = new Joke[len + 1];
        System.arraycopy(jokes, 0, array, 0, len);
        array[len] = joke;
        jokes = array;
        return len;
    }

    void del(int pos) {
        Joke[] arr = new Joke[jokes.length - 1];
        System.arraycopy(jokes, 0, arr, 0, pos);
        System.arraycopy(jokes, pos + 1, arr, pos, jokes.length - pos - 1);
        jokes = arr;
    }

    void del(Joke joke) {
        for (int i = 0; i < jokes.length; i++)
            if (jokes[i] == joke) {
                del(i);
                return;
            }
    }

    void fillTags() {
        for (Joke j : jokes) bot.addTags(j.name, j.tags);
    }

    Joke getJoke(String name) {
        for (Joke j : jokes) if (j.name.equals(name)) return j;
        return null;
    }

    Joke getJoke(GreatSmartBot.FoundTags tags) {
        for (Joke j : jokes) if (bot.checkLastFound(tags, j.name)) return j;
        return null;
    }

    Joke add(String name, String tags, int group, int cost) {
        Joke j1=new Joke(" Анекдот про Брежнева: Выступление Брежнева по телевизору: — Товарищи! В последнее время распространились слухи,\n" +
                " что в автомобиле вместо меня возят чучело. Так вот, заявляю со всей ответственностью, что эти слухи — подлая клевета." +
              " На самом деле в автомобиле вместо чучела возят меня!","Анекдот,Брежнева, смешной", 5, 160, jokes.length);
        add(j1);
        return j1;
    }
}

// Food f18=new Food(" Анекдот про Брежнева: Выступление Брежнева по телевизору: — Товарищи! В последнее время распространились слухи,\n" +
//                " что в автомобиле вместо меня возят чучело. Так вот, заявляю со всей ответственностью, что эти слухи — подлая клевета." +
//                " На самом деле в автомобиле вместо чучела возят меня!","Анекдот,Брежнева, смешной", 5, 160, foods.length );*/