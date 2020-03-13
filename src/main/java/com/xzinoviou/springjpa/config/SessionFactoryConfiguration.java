package com.xzinoviou.springjpa.config;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfiguration {

    public static SessionFactory buildFrom(String hibernateCfgUrl, Class<?>...classes) {
        Configuration configuration = new Configuration().configure(hibernateCfgUrl);

        for (Class<?> clazz : classes) {
            configuration.addAnnotatedClass(clazz);
        }

        return configuration.buildSessionFactory();
    }
}
