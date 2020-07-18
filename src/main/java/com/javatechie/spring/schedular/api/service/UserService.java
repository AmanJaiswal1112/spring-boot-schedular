package com.javatechie.spring.schedular.api.service;

import com.javatechie.spring.schedular.api.model.User;
import com.javatechie.spring.schedular.api.repository.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService
{
    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserDao userDao;

    //schedule a job to  add object in database in every 5 sec

    @Scheduled(fixedRate = 5000)
    public void add2DBJob()
    {
        User user = new User();
        user.setName("user"+new Random().nextInt(374483));
        userDao.save(user);
        System.out.println("add service call"+new Date().toString());
    }

    @Scheduled(cron = "0/15 * * * * *")
    public void fechDBJob()
    {
        List<User> users = new ArrayList<>();
        users = userDao.findAll();
        System.out.println("fetch service call in "+ new Date().toString());
        System.out.println("no of record fetched ="+users.size());
        logger.info("users :{}", users);
    }

}
