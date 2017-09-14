/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.application;

import android.content.Context;
import com.fcm.fuzzycomputingmachine.dagger.component.DaggerApplicationComponent;
import com.fcm.fuzzycomputingmachine.ui.activities.MainActivity;
import com.fcm.fuzzycomputingmachine.dagger.component.ApplicationComponent;
import com.fcm.fuzzycomputingmachine.dagger.component.activities.MainActivityComponent;
import com.fcm.fuzzycomputingmachine.dagger.modules.ApplicationModule;
import com.fcm.fuzzycomputingmachine.dagger.modules.activities.MainActivityModule;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public class MainApplication extends BaseApplication {

  private ApplicationComponent applicationComponent;
  private MainActivityComponent mainActivityComponent;

  public static MainApplication get(Context context) {
    return (MainApplication) context.getApplicationContext();
  }

  @Override public void onCreate() {
    super.onCreate();
    initAppComponent();
  }

  private void initAppComponent() {
    applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
  }

  public MainActivityComponent createMainActivityComponent(final MainActivity mainActivity) {
    mainActivityComponent = applicationComponent.plus(new MainActivityModule(mainActivity));
    return mainActivityComponent;
  }

  public void releaseMainActivityComponent() {
    mainActivityComponent = null;
  }
}
