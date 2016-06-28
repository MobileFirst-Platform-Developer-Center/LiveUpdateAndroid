/**
 * Copyright 2016 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sample.HelloLiveUpdateSwift;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.worklight.ibmmobilefirstplatformfoundationliveupdate.LiveUpdateManager;
import com.worklight.ibmmobilefirstplatformfoundationliveupdate.api.Configuration;
import com.worklight.ibmmobilefirstplatformfoundationliveupdate.api.ConfigurationListener;
import com.worklight.wlclient.api.WLClient;

public class MainActivity extends AppCompatActivity {
    private String countryCode = "US";
    ImageButton selectedCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WLClient.createInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedCountry = (ImageButton) findViewById(R.id.us);
        selectCountry (selectedCountry);
    }

    public void helloLiveUpdate (View v){
        LiveUpdateManager.getInstance().obtainConfiguration(countryCode, new ConfigurationListener() {
            @Override
            public void onSuccess(final Configuration configuration) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showAlertDialog (configuration.getProperty("helloText"));
                    }
                });
            }

            @Override
            public void onFailure(com.worklight.wlclient.api.WLFailResponse wlFailResponse) {
                Log.e("Hello Live Update", wlFailResponse.getErrorMsg());
            }
        });
    }

    public void showAlertDialog (String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Hello Live Update");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void selectCountry(View v) {
        //Restore last
        selectedCountry.getDrawable().setAlpha(255);
        selectedCountry.setClickable(true);
        selectedCountry.setEnabled(true);

        //Set button disabled
        selectedCountry = (ImageButton) v;
        selectedCountry.setClickable(false);
        selectedCountry.setEnabled(false);
        countryCode = (String) selectedCountry.getTag();
        selectedCountry.getDrawable().setAlpha(90);
    }
}
