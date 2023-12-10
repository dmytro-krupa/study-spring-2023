package com.lpnu.airport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/*

    resolve conflicts:

    given: master and feature branches. PR feature -> master has some conflict

    0. you are on feature branch
    1. git checkout master
    2. git pull // або через кнопочку
    3. git checkout feature
    4. git pull // або через кнопочку
    ==== на цьому етапі ви маєте найновіші дані на двох бренчах що мерджаться
    5. git merge
    5.1 (ЯКЩО ТРЕБА ЗУПИНИТ МЕРДЖ) git merge --abort
    6. git commit -m "ваш меседж"
    7. git push origin feature // або через кнопочку
    ==== на цьому етамі конфлікту у ПР нема

    Викинути коміт є два способи:

    soft: git reset --soft HEAD~1
    hard: git reset --hard HEAD~1 (ТРЕБА ПЕРЕВІРИТИ) (НІКОЛИ НЕ ВИКОРИСТОВУВАТИ БЕЗ СУПЕР НАГАЛЬНОЇ ПОТРЕБИ)


    Андрій Будай "Паттерни просто як двері"

    іммютабл
    багатопотоковість
    оптимізація
    патерни - вступ

quartz - ліба для роботи із scheduled джобами
  */