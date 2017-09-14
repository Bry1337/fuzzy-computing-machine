/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.modules.activities;

import android.support.v7.app.AlertDialog;
import com.fcm.fuzzycomputingmachine.api.manager.ApiManager;
import com.fcm.fuzzycomputingmachine.dagger.scopes.UserScope;
import com.fcm.fuzzycomputingmachine.ui.activities.main.MainActivity;
import com.fcm.fuzzycomputingmachine.ui.activities.main.MainActivityPresenter;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Module public class MainActivityModule {

  private final MainActivity mainActivity;

  public MainActivityModule(MainActivity mainActivity) {
    this.mainActivity = mainActivity;
  }

  @Provides @UserScope MainActivity provideMainActivity() {
    return mainActivity;
  }

  @Provides @UserScope MainActivityPresenter provideMainActivityPresenter(ApiManager apiManager) {
    return new MainActivityPresenter(mainActivity, apiManager);
  }

  @Provides @UserScope AlertDialog provideAlertDialog() {
    return new AlertDialog.Builder(mainActivity).create();
  }

  @Provides @UserScope CompositeSubscription provideCompositeSubscription() {
    return new CompositeSubscription();
  }
}
