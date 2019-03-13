package com.web.start.model;

import org.springframework.stereotype.Component;

/**
 * Created by kun
 */
@Component
public class HostHolder {
    private static ThreadLocal<User> users = new ThreadLocal<User>();//每个线程都可以访问，线程本地变量

    public User getUser() {
        return users.get();
    }

    public void setUser(User user) {
        users.set(user);
    }

    public void clear() {
        users.remove();;
    }
}
