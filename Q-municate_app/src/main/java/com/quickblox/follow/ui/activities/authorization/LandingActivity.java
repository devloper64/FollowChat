package com.quickblox.follow.ui.activities.authorization;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.quickblox.follow.R;
import com.quickblox.follow.utils.StringObfuscator;
import com.quickblox.q_municate_core.models.LoginType;

import butterknife.Bind;
import butterknife.OnClick;

public class LandingActivity extends BaseAuthActivity {

    @Bind(R.id.app_version_textview)
    TextView appVersionTextView;

    @Bind(R.id.phone_number_connect_button)
    Button phoneNumberConnectButton;

    public static void start(Context context) {
        Intent intent = new Intent(context, LandingActivity.class);
        context.startActivity(intent);
    }

    public static void start(Context context, Intent intent) {
        context.startActivity(intent);
    }

    @Override
    protected int getContentResId() {
        return R.layout.activity_landing;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVersionName();
    }

    @OnClick(R.id.facebook_connect_button)
    void login(View view) {
        if (checkNetworkAvailableWithError()) {
            loginType = LoginType.FACEBOOK;
            startSocialLogin();
        }
    }

    @OnClick(R.id.phone_number_connect_button)
    void phoneNumberConnect(View view) {
        if (checkNetworkAvailableWithError()) {
            loginType = LoginType.FIREBASE_PHONE;
            startSocialLogin();
        }
    }

    @Override
    public void checkShowingConnectionError() {
        // nothing. Toolbar is missing.
    }



    private void initVersionName() {
        appVersionTextView.setText(StringObfuscator.getAppVersionName());
    }
}