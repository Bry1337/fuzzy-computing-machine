/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.api.service;

import com.fcm.fuzzycomputingmachine.api.responses.ArticleResponse;
import com.fcm.fuzzycomputingmachine.managers.AppConstants;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@SuppressWarnings("PMD") public interface ApiService {

  @GET(AppConstants.ARTICLES) Observable<ArticleResponse> getNews(@Query(AppConstants.SOURCE_KEY) String source,
      @Query(AppConstants.SORT_BY_KEY) String sortBy, @Query(AppConstants.API_KEY) String apiKey);
}
