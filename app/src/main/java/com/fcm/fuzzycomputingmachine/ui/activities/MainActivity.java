/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities;

import com.fcm.fuzzycomputingmachine.R;

public class MainActivity extends ToolBarBaseActivity {

  @Override protected void setupActivityLayout() {
    setContentView(R.layout.activity_main);
  }

  @Override protected void setupViewElements() {

  }

  @Override protected boolean isActionBarBackButtonEnabled() {
    return false;
  }

  @Override protected void injectDaggerComponent() {

  }
}
