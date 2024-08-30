package org.example.twitterback.repository;

import org.example.twitterback.model.Twit;
import org.example.twitterback.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TwitRepository extends JpaRepository<Twit, Long> {

    List<Twit> findAllByIsTwitTrueOrderByCreatedAtDesc();

    List<Twit> findByRetwitUserContainsOrUser_IdAndIsTwitTrueOrderByCreatedAtDesc(User user, Long userId);

    List<Twit> findByLikesContainingOrderByCreatedAtDesc(User user);

    @Query("SELECT t FROM Twit t JOIN t.likes L WHERE L.user.id = :userId")
    List<Twit> findByLikesUserId(Long userId);




}
