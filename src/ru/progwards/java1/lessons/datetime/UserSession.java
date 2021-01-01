package ru.progwards.java1.lessons.datetime;

import java.time.LocalDateTime;
import java.util.*;

class UserSession {
    static private int handleNextNum = 0;
    private int sessionHandle;
    private String userName;
    private LocalDateTime lastAccess;
    private SessionManager sessionManager;

    // создать сессию пользователя
    UserSession(String userName) {
       // Random rand = new Random();
        //this.sessionHanle = (int)(Math.random()*Integer.MAX_VALUE);// по заданию
        this.sessionHandle = handleNextNum++;
        this.userName = userName;
        refreshLastAccess();
    }

    public void setSessionManager(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    public void setSessionHandle(int sessionHanle) {
        this.sessionHandle = sessionHanle;
    }

    public int getSessionHandle() {
        return sessionHandle;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void refreshLastAccess() {
        this.lastAccess = LocalDateTime.now();
    }

    public void setLastAccess(LocalDateTime lastAccess) {
        this.lastAccess = lastAccess;
    }

    public LocalDateTime getLastAccess() {
        return lastAccess;
    }

    public boolean isValid(int sessionValid, LocalDateTime now) {// sessionValid-период валидности сессии в секундах
        return lastAccess.plusSeconds(sessionValid).isAfter(now);
    }

    @Override
    public String toString() {
        return "Session{" + "h=" + sessionHandle + ",u='" + userName + '}';
    }
}

