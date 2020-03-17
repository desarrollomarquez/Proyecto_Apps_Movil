package com.nytimes.articles.view.callbacks;

import com.nytimes.articles.data.local.entity.ArticleEntity;


/**
 * List Callback
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public interface ArticleListCallback {
    void onArticleClicked(ArticleEntity articleEntity);
}

