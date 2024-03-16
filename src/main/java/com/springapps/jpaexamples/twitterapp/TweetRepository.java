package com.springapps.jpaexamples.twitterapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet,Long> {

    public void deleteAllByUser_Id(Long userId);

    public Tweet findByText(String text);
    public List<Tweet> findAllByUser_Id(Long userId);
    //JPQL
    @Modifying
    @Query("DELETE FROM Tweet t WHERE t.user.id = : userId")
    public void deleteAllByUserId(@Param("userId") Long userId);
}
