package Bot2;

public class Check {

    Sets sets;
    GreatSmartBot bot;

    Check(GreatSmartBot bot, Sets sets) {
        this.bot = bot;
        this.sets = sets;
        int maxGroup = 0;
        //for (Food m : sets.foods) if (m.group > maxGroup) maxGroup = m.group;
        int group[] = new int[maxGroup + 1];
    }

    int getUserData(Integer userid, String dataName) {
        Integer result = 0;
        String str = bot.getUserData(userid, dataName);
        if (str != null)
            result = Integer.parseInt(str);
        return result;
    }
    int setUserData(Integer userid, String dataName, int increment) {
        Integer result = getUserData(userid, dataName);
        if (result > 0) {
            result += increment;
            bot.setUserData(userid, dataName, result.toString());
        }
        return result;
    }


    void add(Integer userid, Food meal, int increment) {
        setUserData(userid, bot.groupKey + "[" + meal.group + "]", increment);
        setUserData(userid, bot.checkKey + "[" + meal.index + "]", increment);
        setUserData(userid, bot.checkKey, increment);
    }
    void add(Integer userid, Food meal) {
        add(userid, meal, 1);
    }
    void del(Integer userid, Food meal) {
        add(userid, meal, -1);
    }

    int countMeal(Integer userid, Food meal) {
        int result = 0;
        getUserData(userid, bot.checkKey + "[" + meal.index + "]");
        return result;
    }
    int countGroup(Integer userid, int group) {
        int result = 0;
        for (Food m : sets.foods)
            if (m.group == group)
                result += getUserData(userid, bot.groupKey + "[" + m.index + "]");
        return result;
    }
}
