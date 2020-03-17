package com.nytimes.articles.data.local.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.nytimes.articles.data.local.entity.ArticleEntity;

import java.util.List;

/**
 * DAO Articulo
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
@Dao
public interface ArticleDao {
    @Query("SELECT * FROM articles")
    LiveData<List<ArticleEntity>> loadPopularArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveArticles(List<ArticleEntity> articleEntities);

}
