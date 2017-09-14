/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities;

import com.fcm.fuzzycomputingmachine.R;
import com.fcm.fuzzycomputingmachine.api.utils.HttpStatusCode;
import com.fcm.fuzzycomputingmachine.api.utils.RetrofitException;
import retrofit2.Response;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public abstract class HttpToolBarBaseActivity extends ToolBarBaseActivity {

  public abstract void onNetworkErrorFound(final String message);

  public abstract void onHttpErrorUnexpectedFound(final String message);

  public abstract void onApiErrorFound(final String message);

  public abstract CompositeSubscription getCompositeSubscription();

  public void handleHttpError(final RetrofitException e) {
    if (e.getKind().equals(RetrofitException.Kind.NETWORK)) {
      onNetworkErrorFound(getString(R.string.network_issue_found));
    } else if (e.getKind().equals(RetrofitException.Kind.HTTP)) {
      final Response response = e.getResponse();
      if (response != null) {
        if (response.code() == HttpStatusCode.UNAUTHORIZED) {
          //TODO Handle Unauthorized Error Here
        } else if (response.code() == HttpStatusCode.VERSION_MISMATCHED) {
          //TODO Handle Error Version Mismatch
        } else {
          onApiErrorFound(getErrorMessage(response));
        }
      }
    } else if (e.getKind().equals(RetrofitException.Kind.UNEXPECTED)) {
      onHttpErrorUnexpectedFound(getString(R.string.http_error_unexpected));
    }
  }

  public String getErrorMessage(final Response response) {
    return response.message();
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    if (getCompositeSubscription().hasSubscriptions()) {
      getCompositeSubscription().unsubscribe();
    }
  }
}
