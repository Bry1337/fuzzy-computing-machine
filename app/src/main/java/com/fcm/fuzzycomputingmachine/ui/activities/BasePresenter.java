/*
 * Copyright (c) 2017. Edward Bryan Abergas. All rights reserved.
 */

package com.fcm.fuzzycomputingmachine.ui.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import com.fcm.fuzzycomputingmachine.R;

/**
 * Created by bry1337 on 14/09/2017.
 *
 * @author edwardbryan.abergas@gmail.com
 */

public abstract class BasePresenter {

  public abstract Activity getActivity();

  public abstract AlertDialog getAlertDialog();

  public void showAlertDialogError(final String message) {
    getAlertDialog().setMessage(message);
    getAlertDialog().setCancelable(false);
    getAlertDialog().setButton(DialogInterface.BUTTON_POSITIVE, getActivity().getString(R.string.OK),
        (dialog, which) -> getAlertDialog().dismiss());
    getAlertDialog().show();
  }
}
