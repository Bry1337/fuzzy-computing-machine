/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.api.manager;

import com.fcm.fuzzycomputingmachine.BuildConfig;
import com.fcm.fuzzycomputingmachine.api.responses.ArticleResponse;
import com.fcm.fuzzycomputingmachine.api.service.ApiService;
import com.fcm.fuzzycomputingmachine.managers.AppConstants;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class ApiManager {

  private final ApiService apiService;

  public ApiManager(ApiService apiService) {
    this.apiService = apiService;
  }

  public Observable<ArticleResponse> getNews() {
    return apiService.getNews(AppConstants.SOURCE_VALUE, AppConstants.SORT_BY_VALUE, BuildConfig.NEWS_API_KEY)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread());
  }
}
