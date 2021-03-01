package Bot2;

import java.util.Scanner;


import org.telegram.telegrambots.ApiContextInitializer;

import ru.progwards.java1.telegrambot.ProgwardsTelegramBot;

    public class GreatSmartBot extends ProgwardsTelegramBot {

        static Sets sets;
        static Check check;


        private final String setsStr = "У нас есть роллы, напитки и десерт, а еще для поднятия духа смешной анекдот...";

        static final String groupKey = "group";
        static final String checkKey = "check";
        static final String addressKey = "address";

        private boolean stop = false;

        // Пердложить группы блюд
        // спросить адрес доставки
        String finishCheck(Integer userid) {
            // проверить что все 5 групп  в заказе
            // если какой-то группы нет && бот не предлагал
            // то предложить и учтановить ключ, что бы не предлагать 2 раза

            // спросить адрес доставки
            // проверить что заказ не пуст
            if (getUserData(userid, addressKey) == null ) {
                setUserData(userid, addressKey, "*");
                return "Укажите, пожалуйста, адрес доставки";
            }
            stop = false;
            // если заказ пуст выдать другое сообщение
            return "Спасибо за заказ.";
        }

        // сохранить в заказ
        void saveOrderItem(Integer userid, FoundTags tags, String text) {
            Food foods = sets.getFood(tags);
            check.add(userid, foods);

            //check.add(userid, jokes);
            // ключи - check1, check2
            // данные - getLastFound(tags)

            // дополнительно 1
            // проверить связанные покупки
            // если он заказывает картошку, то предложить соус, если не предлагали

        }

        String getCheck(Integer userid) {
            // считать количество

            // в цикле по каждому элементу вывести содержимое
            // ключ checkKey + номер
            return "Ваш заказ";
        }

        /**
         * Метод, который возвращает ответ бота
         * @return ответ
         */
        @Override
        public String processMessage(Integer userid, String text) {
            // проверяем, спрашивали ли адрес доставки
            if (getUserData(userid, addressKey) != null && getUserData(userid, addressKey).equals("*")) {
                setUserData(userid, addressKey, text);
                return finishCheck(userid);
            }
            // сброс всех данных для пользователя - полезно для тестирования
            if (text.equals("/reset"))
                cleartUserData(userid);

            // ищем подходящие тэги под запрос из заданных через addTags
            FoundTags tags = checkTags(text);
            // если найдено всего один вариант
            if (foundCount(tags) == 1) {
                if (checkLastFound(tags, "привет"))
                    return "Добрый день, Дорогой Гость!\nЧто вы хотели бы отведать сегодня? " + setsStr;
                if (checkLastFound(tags, "конец"))
                    return finishCheck(userid);
                if (checkLastFound(tags, "дурак"))
                    return "О дорогой. Прости конечно, Но у нас так не принято! Просто спроси по-другому";
                if (checkLastFound(tags, "нет"))
                    return "На нет, и суда нет";
                if (checkLastFound(tags, "заказ"))
                    return getCheck(userid);
                // Добавить связанные предложения, например если он заказывает картошку, то предложить соус,
                // если отказывается - сохранить флажок, что бы бесконечно не предлагать
                // дополнительно 2
                // реализовать отмену позиции заказа

                saveOrderItem(userid, tags, text);
                return "Отлично, добавляю в заказ " + getLastFound(tags) + " Желаешь что-то еще?";
            }
            if (foundCount(tags) > 1)
                return "Под твой запрос подходит: \n" + extract(tags) + "Выбери что-то одно, и я добавлю это в заказ.";
            return "Я не понял, возможно у нас этого нет, попробуй сказать по другому. " + setsStr;
        }

        public static void main(String[] args) throws NullPointerException {
            /*System.getProperties().put("proxySet", "true"); // Tor Browser proxy params
            System.getProperties().put("socksProxyHost", "127.0.0.1");
            System.getProperties().put("socksProxyPort", "9150");*/

            System.out.println("Hello bot!");
            ApiContextInitializer.init();

            // инициализируем бота
            GreatSmartBot bot = new GreatSmartBot();
            bot.username = "SmartyKomBot";
            bot.token = "1646881099:AAFbUeLTpwokLtWjJk0xQlFuxhVdzEantPU";

            // наполняем тэгами
            bot.addTags("привет", "привет, здасьте, здравствуйте, добр, день, вечер, утро, hi, hello");
            bot.addTags("конец", "конец, все, стоп, нет, хватит, хорош, спасибо");
            bot.addTags("дурак", "дурак, идиот, тупой");

            // добавлено
            bot.addTags("заказ", "заказ");
            bot.addTags("нет", "нет");

            sets = new Sets(bot);
            Food f1 = sets.add("Тянь шань 360р.", "ролл,еда, шань, еды,тянь, снежный краб, краб, огурец, сливочный сыр, угорь, лосось", 1, 360);
            Food f2 = sets.add("Филадельфия Классик 360р.", "ролл,еда, еды,классик, филадельф, сливочный сыр, лосось", 1, 360);
            Food f3 = sets.add("Спайси краб 280р.", "ролл, спайси, снежный краб,еда, еды,краб, икра лосося, спайси соус", 1, 280);
            Food f4 = sets.add("Унаги филадельфия 360р.", "ролл, унаги, филадельф, еда,угорь, еды,сливочный сыр, лосось, соус унаги", 1, 360);
            Food f5 = sets.add("Самурай 320р.", "ролл, самурай, креветка тигр,еды, лосос, еда,томат", 1, 320);
            Food f6 = sets.add("Аляска 270р.", "ролл, аляск, сливочный сыр, креветк,еды, огурец,еда, укроп, икра", 1, 270);
            Food f7 = sets.add("Горячая тортилья 270р.", "ролл, тортил, говя, сливочный сыр,еды, помид, еда,огур, лук", 1, 270);

            Food m1 = sets.add("Больше Имбиря 20р.", "добавк, приправ, имбир", 2, 20);
            m1.linkTo(new Food[]{f1, f2, f4, f5});
            Food m2 = sets.add("Больше Васаби 20р.", "добавк, приправ, васаб", 2, 20);
            m2.linkTo(new Food[]{f2, f3, f4, f5, f6});
            Food m3 = sets.add("Больше Соевого соуса 20р.", "добавк, соус, соев, приправ, васаб", 2, 20);
            m3.linkTo(new Food[]{f5, f6, f7});

            sets.add("Торт тирамису, 110р.", "десерт, Тирамису, маскарпоне, бисквит", 3, 110);
            sets.add("Торт медовик, 80р.", "десерт, мед, бисквит", 3, 80);
            sets.add("Эклеры, 70р.", "десерт, заварной, крем, тесто", 3, 70);

            sets.add("Имбирный компот 1л. 140р.", "напит, компот", 4, 140);
            sets.add("Кола, 80р.", "напит, пить, кола", 4, 80);
            sets.add("Холодный чай, 70р.", "напит, пить, чай, липтон, лимон", 4, 70);
            sets.add("Сок Яблочный 60р.", "напит, пить, сок", 4, 60);
            sets.add("Сок Манго 60р.", "напит, пить, сок, манго", 4, 60);
            sets.add("Кофе Капучино, 160р.", "напит, пить, кофе, Капучино, взбитые сливки, сахар", 4, 160);
            sets.add("Кофе Эспрессо, 160р.", "напит, пить, кофе,  Эспрессо", 4, 160 );
            sets.add("Кофе Американо, 160р.", "напит, пить, кофе,  Американо", 4, 160 );

            sets.add("Анекдот про Брежнева, 160оч.", "Брежнева, анекдот, смешно,  расскажи", 5, 2 );
            sets.add("Анекдот про Охотника , 160оч.", "Охотник-добытчик, анекдот, смешно,  расскажи", 5, 1 );
            sets.fillTags();
            check = new Check(bot, sets);
            bot.start();
            bot.test();
        }
        void test() {
            Scanner in = new Scanner(System.in);
            String str;
            do {
                str = in.nextLine();

                System.out.println(processMessage(5, str));
            } while (!stop);
            in.close();
        }

        @Override
        public String toString() {
            return "GreatSmartBot{" +
                    "sets='" + sets + '\'' +
                    ", stop=" + stop +
                    '}';
        }
    }