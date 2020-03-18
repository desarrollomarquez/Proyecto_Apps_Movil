package com.dataentropia.androidmvvm.local.dao;
import com.dataentropia.androidmvvm.local.entity.Movie_DB;
import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @SuppressWarnings("unchecked")
    @Insert
     void addMovieItems(Movie_DB movieDb);

    @SuppressWarnings("unchecked")
    @Query("DELETE FROM MovieDB")
     void deleteAllMovieItems();

    @SuppressWarnings("unchecked")
    @Query("select * from MovieDB")
    List<Movie_DB> getAllMovieItems();


    @SuppressWarnings("unchecked")
    @Delete
     void deleteItems(Movie_DB movie_db);
}
