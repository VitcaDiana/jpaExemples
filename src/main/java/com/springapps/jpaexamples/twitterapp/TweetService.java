package com.springapps.jpaexamples.twitterapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TweetService {
    TweetRepository tweetRepository;
    CommentRepository commentRepository;

    @Autowired
    public TweetService(TweetRepository tweetRepository, CommentRepository commentRepository) {
        this.tweetRepository = tweetRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public Comment addCommentToTweet1(Long tweetId, Comment comment) throws Exception {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new Exception("tweet not found"));
        ///ne salveaza comentariul fara tweet_id
        comment.setTweet(tweet);
        return commentRepository.save(comment);


    }

    @Transactional
    public Tweet addCommentToTweet2(Long tweetId, Comment comment) throws Exception {
        Tweet tweet = tweetRepository.findById(tweetId).orElseThrow(() -> new Exception("tweet not found"));
        comment.setTweet(tweet);
        tweet.getComments().add(comment);
        return tweetRepository.save(tweet);


    }

    public Tweet findByText(String text) {
        return tweetRepository.findByText(text);
    }
    public void deleteAllCommentFromTweet(Long tweetId){
        commentRepository.deleteAllByTweet_Id(tweetId);

    }
    public void deleteTweet(Long tweetId){
        tweetRepository.deleteById(tweetId);
    }



}
