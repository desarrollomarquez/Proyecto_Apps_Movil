package com.nytimes.articles.di.builder;

import com.nytimes.articles.view.fragment.ArticleDetailFragment;
import com.nytimes.articles.view.fragment.ArticleListFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;


/**
 * This builder provides android injector service to fragments
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
@Module
public abstract class FragmentBuilderModule {

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ArticleListFragment contributeArticleListFragment();

    @SuppressWarnings("unused")
    @ContributesAndroidInjector
    abstract ArticleDetailFragment contributeArticleDetailFragment();

}
