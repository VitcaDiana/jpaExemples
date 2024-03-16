package com.springapps.jpaexamples.twitterapp;

import com.springapps.jpaexamples.orderapp.Order;
import com.springapps.jpaexamples.orderapp.OrderRepository;
import com.springapps.jpaexamples.orderapp.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class Runner implements CommandLineRunner {

    UserService userService;
    TweetService tweetService;

    public Runner(UserService userService,TweetService tweetService) {

        this.userService = userService;
        this.tweetService = tweetService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Costel");
        userService.saveUser(user);

        Tweet tweet = new Tweet("bitcoin is up");
        userService.addTweetToUser2(1L,tweet);
       // userService.deleteAllTweetsFromUser1(1l);
//        Tweet foundTweet = tweetService.findByText("bitcoin is up");
//        Comment comment = new Comment("super");
//        Comment comment1 = new Comment("hello");
//        tweetService.addCommentToTweet1(foundTweet.getId(),comment);
//        tweetService.addCommentToTweet1(foundTweet.getId(),comment1);
//        System.out.println(userService.findAllCommentsByUser3(1l));

        //userService.deleteUser(1l);
        //userService.deleteAllTweetsFromUser3(1l);

    }
}
