package org.codeforcoffee.littlebitscloudbitremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {

    private Button mGetStartedBtn;
    private Intent mSettingsIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mSettingsIntent = new Intent(this, CloudBitListActivity.class);
        mGetStartedBtn = (Button) findViewById(R.id.splash_btn_get_started);
        mGetStartedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(mSettingsIntent);
            }
        });

    }
}
