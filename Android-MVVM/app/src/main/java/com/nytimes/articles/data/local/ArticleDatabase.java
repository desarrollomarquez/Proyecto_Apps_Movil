package com.nytimes.articles.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.nytimes.articles.data.local.dao.ArticleDao;
import com.nytimes.articles.data.local.entity.ArticleEntity;

/**
 * Entity ArticuloDatabase
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
@Database(entities = {ArticleEntity.class}, version = 2, exportSchema = false)
public abstract class ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}