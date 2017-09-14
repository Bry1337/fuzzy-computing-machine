/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.api.manager;

import com.fcm.fuzzycomputingmachine.api.service.ApiService;

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
}
