package com.xi.liuliu.topnews.dialog;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xi.liuliu.topnews.R;
import com.xi.liuliu.topnews.constants.Constants;
import com.xi.liuliu.topnews.event.LoginResultEvent;
import com.xi.liuliu.topnews.utils.SharedPrefUtil;

import de.greenrobot.event.EventBus;

/**
 * Created by liuliu on 2017/6/28.
 */

public class LogoutDialog implements View.OnClickListener {
    private DialogView mDialogView;
    private TextView mCancle;
    private TextView mQuit;
    private Activity mSettinsActivity;

    public LogoutDialog(Activity activity) {
        mSettinsActivity = activity;
        init();
    }

    private void init() {
        View view = LayoutInflater.from(mSettinsActivity).inflate(R.layout.dialog_log_out, null);
        mCancle = (TextView) view.findViewById(R.id.dialog_log_out_cancle);
        mCancle.setOnClickListener(this);
        mQuit = (TextView) view.findViewById(R.id.dialog_log_out_quit);
        mQuit.setOnClickListener(this);
        mDialogView = new DialogView(mSettinsActivity, view);
        mDialogView.setGravity(Gravity.CENTER);
        mDialogView.setCanceledOnTouchOutside(false);
        mDialogView.setCancelable(false);
        mDialogView.setDimBehind(true);
        mDialogView.setFullScreen(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_log_out_cancle:
                dismiss();
                break;
            case R.id.dialog_log_out_quit:
                logout();
        }
    }

    private void logout() {
        SharedPrefUtil.getInstance(mSettinsActivity).putBoolean(Constants.LOGIN_SP_KEY, false);
        SharedPrefUtil.getInstance(mSettinsActivity).putString(Constants.USER_PHONE_NUMBER_SP_KEY, null);
        EventBus.getDefault().post(new LoginResultEvent(false));
        dismiss();
        if (mSettinsActivity != null) {
            mSettinsActivity.finish();
        }
        Toast toast = Toast.makeText(mSettinsActivity.getApplicationContext(), R.string.settings_toast_log_out_success, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void show() {
        if (mDialogView != null) {
            mDialogView.showDialog();
        }
    }

    public void dismiss() {
        if (mDialogView != null) {
            mDialogView.dismissDialog();
        }
    }
}