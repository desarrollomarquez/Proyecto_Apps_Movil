package com.nytimes.articles.view.activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.Nullable;

import com.nytimes.articles.R;
import com.nytimes.articles.databinding.ActivityMainBinding;
import com.nytimes.articles.utils.FragmentUtils;
import com.nytimes.articles.view.base.BaseActivity;
import com.nytimes.articles.view.fragment.ArticleListFragment;

import static com.nytimes.articles.utils.FragmentUtils.TRANSITION_NONE;

/**
 * Main Activity
 * <p>
 * Author: Diego Marquez
 *  * Created: 17/03/2020
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentUtils.replaceFragment(this, ArticleListFragment.newInstance(), R.id.fragContainer, false, TRANSITION_NONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
