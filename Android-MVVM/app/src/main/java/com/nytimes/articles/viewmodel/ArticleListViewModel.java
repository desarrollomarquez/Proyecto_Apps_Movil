package com.nytimes.articles.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.nytimes.articles.data.local.entity.ArticleEntity;
import com.nytimes.articles.data.remote.Resource;
import com.nytimes.articles.data.remote.repository.ArticleRepository;

import java.util.List;

import javax.inject.Inject;


/**
 * Article List view model
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public class ArticleListViewModel extends ViewModel {
    private final LiveData<Resource<List<ArticleEntity>>> popularArticles;

    @Inject
    public ArticleListViewModel(ArticleRepository articleRepository) {
        popularArticles = articleRepository.loadPopularArticles(7);
    }

    public LiveData<Resource<List<ArticleEntity>>> getPopularArticles() {
        return popularArticles;
    }
}
