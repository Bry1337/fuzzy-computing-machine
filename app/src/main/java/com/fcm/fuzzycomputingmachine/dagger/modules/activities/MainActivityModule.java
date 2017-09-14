/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.modules.activities;

import com.fcm.fuzzycomputingmachine.ui.activities.MainActivity;
import com.fcm.fuzzycomputingmachine.dagger.scopes.UserScope;
import dagger.Module;
import dagger.Provides;

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
}
