/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities.main;

import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import butterknife.BindView;
import com.fcm.fuzzycomputingmachine.R;
import com.fcm.fuzzycomputingmachine.dagger.application.MainApplication;
import com.fcm.fuzzycomputingmachine.models.Article;
import com.fcm.fuzzycomputingmachine.ui.activities.HttpToolBarBaseActivity;
import com.fcm.fuzzycomputingmachine.ui.activities.main.adapter.MainActivityAdapter;
import java.util.List;
import javax.inject.Inject;
import rx.subscriptions.CompositeSubscription;

public class MainActivity extends HttpToolBarBaseActivity {

  @Inject AlertDialog alertDialog;
  @Inject MainActivityPresenter mainActivityPresenter;
  @Inject CompositeSubscription compositeSubscription;
  @BindView(R.id.rvNews) RecyclerView rvNews;
  @BindView(R.id.pbNews) ProgressBar pbNews;

  MainActivityAdapter mainActivityAdapter;

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_main);
  }

  @Override protected void setupViewElements() {
    fetchNews();
  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return false;
  }

  @Override protected void injectDaggerComponent() {
    MainApplication.get(this).createMainActivityComponent(this).inject(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    MainApplication.get(this).releaseMainActivityComponent();
  }

  @Override public void onNetworkErrorFound(String message) {
    mainActivityPresenter.showAlertDialogError(message);
  }

  @Override public void onHttpErrorUnexpectedFound(String message) {
    mainActivityPresenter.showAlertDialogError(message);
  }

  @Override public void onApiErrorFound(String message) {
    mainActivityPresenter.showAlertDialogError(message);
  }

  @Override public CompositeSubscription getCompositeSubscription() {
    return compositeSubscription;
  }

  private void fetchNews() {
    compositeSubscription.add(mainActivityPresenter.getNews());
  }

  public void displayNews(List<Article> articleList) {
    mainActivityAdapter = new MainActivityAdapter(this, articleList);
    rvNews.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    rvNews.setAdapter(mainActivityAdapter);
  }
}
