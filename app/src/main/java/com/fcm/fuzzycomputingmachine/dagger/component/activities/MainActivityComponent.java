/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.component.activities;

import com.fcm.fuzzycomputingmachine.dagger.modules.activities.MainActivityModule;
import com.fcm.fuzzycomputingmachine.dagger.modules.api.MainApiModule;
import com.fcm.fuzzycomputingmachine.dagger.scopes.UserScope;
import com.fcm.fuzzycomputingmachine.ui.activities.main.MainActivity;
import dagger.Subcomponent;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@UserScope @Subcomponent(modules = { MainActivityModule.class, MainApiModule.class })
public interface MainActivityComponent {
  MainActivity inject(MainActivity mainActivity);
}
