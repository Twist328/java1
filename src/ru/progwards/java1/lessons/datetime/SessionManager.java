package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class SessionManager {

    List<UserSession> sessions; // список сессий пользователей по sessionHanle (т.к. есть setSessionHanle, нет гарантий, что не изменят его)

    Hashtable<Integer, UserSession> hashSessions; // поиск сессии по sessionHanle

    int sessionValid; // период валидности сессии в секундах

    SessionManager(int sessionValid) {
        sessions = new ArrayList<UserSession>();
        hashSessions = new Hashtable<Integer, UserSession>();
        this.sessionValid = sessionValid;
    }

    // добавляет новую сессию пользователя
    public void add(UserSession userSession) {
        if (get(userSession.getSessionHandle()) != null) return; // проверка на уникальность по хэшу сессии
        // основное действие
        userSession.setSessionManager(this);
        sessions.add(userSession);
        hashSessions.put(userSession.getSessionHandle(), userSession);

    }

    // проверяет наличие существующей сессии по userName. Если срок валидности истек, или такой нет, возвращает null
    public UserSession find(String userName) {
        LocalDateTime ldt = LocalDateTime.now();
        for (UserSession us : sessions) {
            if (us.getUserName().equals(userName)) {

                if (us.isValid(sessionValid, ldt)) return us;// нашли по имени пользователя, проверим на валидность
            }
        }
        return null;
    }

    // проверяет наличие существующей сессии по хендлу. Если срок валидности истек, или такой нет, возвращает null
    public UserSession get(int sessionHandle) {
        UserSession us = hashSessions.get(sessionHandle);
        if (us != null && us.isValid(sessionValid, LocalDateTime.now())) {
            us.refreshLastAccess();
            return us;
        } else {
            return null;
        }
    }

    // удаляет указанную сессию пользователя
    public void delete(int sessionHandle) {
        UserSession userSession = hashSessions.get(sessionHandle);
        if (userSession != null) {
            hashSessions.remove(sessionHandle);
            sessions.remove(userSession);
        }
    }

    // удаляет все сессии с истекшим сроком годности.
    public void deleteExpired() {
        LocalDateTime ldt = LocalDateTime.now();
        Iterator iter = sessions.listIterator();
        while (iter.hasNext()) {
            UserSession us = (UserSession) iter.next();
            if (us.isValid(sessionValid, ldt)) {

                iter.remove();
            }
        }
    }

    @Override
    public String toString() {
        return "Manager{" + sessions + '}';
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        SessionManager manager = new SessionManager(3);
        manager.sessionValid = 3;
        String s = "one";
        UserSession one = new UserSession(s);
        if (manager.find(s) == null) manager.add(one);
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

