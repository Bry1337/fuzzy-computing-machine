/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities.main;

import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import com.fcm.fuzzycomputingmachine.api.manager.ApiManager;
import com.fcm.fuzzycomputingmachine.api.responses.ArticleResponse;
import com.fcm.fuzzycomputingmachine.api.utils.RetrofitException;
import com.fcm.fuzzycomputingmachine.api.utils.SimpleObserver;
import com.fcm.fuzzycomputingmachine.ui.activities.BasePresenter;
import rx.Subscription;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class MainActivityPresenter extends BasePresenter {

  private final MainActivity activity;
  private final ApiManager apiManager;

  public MainActivityPresenter(MainActivity mainActivity, ApiManager apiManager) {
    this.activity = mainActivity;
    this.apiManager = apiManager;
  }

  Subscription getNews() {
    showHideProgressBar(true);
    return apiManager.getNews().subscribe(new SimpleObserver<ArticleResponse>() {
      @Override public void onNext(ArticleResponse articleResponse) {
        showHideProgressBar(false);
        activity.displayNews(articleResponse.getArticleList());
      }

      @Override public void onError(Throwable e) {
        showHideProgressBar(false);
        activity.handleHttpError((RetrofitException) e);
      }
    });
  }

  @Override public Activity getActivity() {
    return activity;
  }

  @Override public AlertDialog getAlertDialog() {
    return activity.alertDialog;
  }

  private void showHideProgressBar(boolean isVisible) {
    activity.pbNews.setVisibility(isVisible ? View.VISIBLE : View.GONE);
  }
}
