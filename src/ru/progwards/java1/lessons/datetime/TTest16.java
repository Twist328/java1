package ru.progwards.java1.lessons.datetime;

public class TTest16 {
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }
    public static void main(String[] args) {
        SessionManager manager = new SessionManager(3);
        manager.sessionValid = 3;
        UserSession one = new UserSession("one");
        if (manager.find("one") == null) manager.add(one);
        System.out.println(manager.get(one.getSessionHandle()));
        System.out.println(manager.get(one.getSessionHandle()));
        System.out.println(manager.get(one.getSessionHandle()));
        sleep(1600);
        System.out.println(manager.get(one.getSessionHandle()));
        sleep(1600);
        System.out.println("null=" + manager.get(one.getSessionHandle()));
        UserSession two = new UserSession("two");
        manager.add(two);
        System.out.println(manager);
        sleep(1600);
        UserSession three = new UserSession("three");
        manager.add(three);
        System.out.println(manager);
        sleep(1600);
        System.out.println(manager);
        manager.deleteExpired();
        System.out.println("deleteExpired()");
        System.out.println(manager);
        manager.delete(three.getSessionHandle());
        System.out.println(manager);
    }
}

