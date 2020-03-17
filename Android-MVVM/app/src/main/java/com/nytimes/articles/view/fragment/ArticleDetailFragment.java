package com.nytimes.articles.view.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.nytimes.articles.R;
import com.nytimes.articles.common.Constants;

import com.nytimes.articles.databinding.FragmentArticleDetailsBinding;
import com.nytimes.articles.view.base.BaseFragment;
import com.nytimes.articles.viewmodel.ArticleDetailsViewModel;


/**
 * The article list fragment which is responsible for showing the article details
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public class ArticleDetailFragment extends BaseFragment<ArticleDetailsViewModel, FragmentArticleDetailsBinding> {
    @Override
    protected Class<ArticleDetailsViewModel> getViewModel() {
        return ArticleDetailsViewModel.class;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_article_details;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle args = getArguments();
        if(null != args) {
            viewModel.setUrl(args.getString(Constants.BUNDLE_KEY_ARTICLE_URL));
            viewModel.loadArticleDetails();
        }
        viewModel.getArticleEntityMutableLiveData().observe(this, articleEntity -> {
            if(null != articleEntity && null != args) {
                dataBinding.textTitle.setText(articleEntity.getTitle());
                dataBinding.textContent.setText(articleEntity.getContent());
                dataBinding.textPublishedDate.setText(args.getString(Constants.BUNDLE_KEY_ARTICLE_PUBLISHED_DATE));
                dataBinding.loadingProgress.setVisibility(View.GONE);
            }
        });

        viewModel.getErrorMessageRecieved().observe(this, message ->{
            dataBinding.loadingProgress.setVisibility(View.GONE);
            dataBinding.textContent.setText(getActivity().getString(R.string.networkError));
        });
    }
}
