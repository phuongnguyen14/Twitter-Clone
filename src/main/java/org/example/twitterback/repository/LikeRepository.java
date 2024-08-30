package org.example.twitterback.repository;

import org.example.twitterback.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Query("SELECT L FROM Like L WHERE L.user.id = :userId AND L.twit.id = :twitId")
    public Like isLikeExist(@Param("userId") Long userId, @Param("twitId") Long twitId);

    @Query("SELECT L FROM Like L WHERE L.twit.id = :twitId")
    public List<Like> findByTwitId(@Param("twitId") Long twitId);


}
