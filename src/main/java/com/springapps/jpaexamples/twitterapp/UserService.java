package com.springapps.jpaexamples.twitterapp;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepository userRepository;
    TweetRepository tweetRepository;
    CommentRepository commentRepository;

    public UserService(UserRepository userRepository, TweetRepository tweetRepository,CommentRepository commentRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public Tweet addTweetToUser1(Long userId, Tweet tweet) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        //v1
//        tweet.setUser(user);
//        user.getTweets().add(tweet);
//        Tweet dbTweet = tweetRepository.save(tweet);
//
//        List<Tweet> tweets = user.getTweets();
//        return dbTweet;
        //v2
//        System.out.println(user.getTweets());
//        return tweetRepository.save(tweet);
        //v3
        tweet.setUser(user);
        return tweetRepository.save(tweet);
    }

    @Transactional
    public User addTweetToUser2(Long userId, Tweet tweet) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        tweet.setUser(user);
        user.getTweets().add(tweet);
        return userRepository.save(user);
    }

    @Transactional
    public void deleteAllTweetsFromUser1(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
//        for (Tweet tweet : user.getTweets()) {
//            tweetRepository.delete(tweet);
//        }
        tweetRepository.deleteAllInBatch(user.getTweets());
    }

    @Transactional
    public User deleteAllTweetsFromUser2(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        user.getTweets().clear();
        return userRepository.save(user);

    }
    @Transactional
    public void deleteAllTweetsFromUser3(Long userId) throws Exception {
        tweetRepository.deleteAllByUser_Id(userId);

    }

    public void deleteUser(Long userId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
        userRepository.delete(user);
    }

    public List<Tweet> findAllTweetsFromUser(Long userId){
        return tweetRepository.findAllByUser_Id(userId);

    }
@Transactional
    public List<Comment> findAllCommentsByUser1(Long userId) throws Exception {
        //pasul 1- obtinem lista de tweet-uri a utilizatorului cu userId
    //var 1- apelam metoda de mai sus care foloseste un derived query declarat de noi in repository
    List<Tweet> tweets = findAllTweetsFromUser(userId);
    //var 2- cautam user-ul si prin lazy loading ii accesam tweet-urile

    User user = userRepository.findById(userId).orElseThrow(() -> new Exception("user not found"));
    user.getTweets();
    //pasul 2- procesam tweet-urile gasite astfel incat sa obtinem o lista de comentarii adunata de la fiecare tweet
       //var 1- java 8-stream pe twwets si flatMap
    return tweets.stream()
            .flatMap(t -> t.getComments().stream())
            .collect(Collectors.toList());
       //var 2- parcurgere clasica si adaugarea elementelor intr-un array list
//        List<Comment> result = new ArrayList<>();
//        for (Tweet tweet : tweets){
//            result.addAll(tweet.getComments());
//        }
//        return result;

}


@Transactional
    public List<Comment> findAllCommentsByUser2(Long userId) {
        return commentRepository.findAllByTweet_User_Id(userId);
    }

    @Transactional
    public List<Comment> findAllCommentsByUser3(Long userId) {
        List<Comment> comments = commentRepository.findAll();
//        List<Comment> result = new ArrayList<>();
//        for (Comment comment : comments){
//            if (comment.getTweet().getUser().getId().equals(userId)){
//                result.add(comment);
//
//            }
//        }
//        return result;

        return comments.stream()
                .filter(c ->c.getTweet().getUser().getId().equals(userId))
                .collect(Collectors.toList());


    }

    }
