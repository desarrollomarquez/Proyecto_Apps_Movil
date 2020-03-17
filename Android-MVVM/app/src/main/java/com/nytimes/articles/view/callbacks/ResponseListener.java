package com.nytimes.articles.view.callbacks;

import com.nytimes.articles.data.local.entity.ArticleEntity;

/**
 * Response Listener
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public interface ResponseListener {

    void onSuccess(ArticleEntity data);
    void onFailure(String message);
}
