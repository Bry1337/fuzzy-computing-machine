/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.modules.api;

import com.fcm.fuzzycomputingmachine.api.manager.ApiManager;
import com.fcm.fuzzycomputingmachine.api.service.ApiService;
import com.fcm.fuzzycomputingmachine.dagger.scopes.UserScope;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class MainApiModule {

  @Provides @UserScope ApiService provideApiService(Retrofit retrofit) {
    return retrofit.create(ApiService.class);
  }

  @Provides @UserScope ApiManager provideApiManager(ApiService userApiService) {
    return new ApiManager(userApiService);
  }
}
