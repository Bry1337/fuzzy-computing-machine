/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.dagger.component;

import com.fcm.fuzzycomputingmachine.dagger.component.activities.MainActivityComponent;
import com.fcm.fuzzycomputingmachine.dagger.modules.ApplicationModule;
import com.fcm.fuzzycomputingmachine.dagger.modules.activities.MainActivityModule;
import com.fcm.fuzzycomputingmachine.dagger.modules.api.ApiModule;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by bry1337 on 13/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

@Singleton @Component(modules = { ApplicationModule.class, ApiModule.class }) public interface ApplicationComponent {

  MainActivityComponent plus(MainActivityModule mainActivityModule);
}
