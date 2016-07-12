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

package com.sample.HelloLiveUpdate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.worklight.ibmmobilefirstplatformfoundationliveupdate.LiveUpdateManager;
import com.worklight.ibmmobilefirstplatformfoundationliveupdate.api.Configuration;
import com.worklight.ibmmobilefirstplatformfoundationliveupdate.api.ConfigurationListener;
import com.worklight.wlclient.api.WLClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private String countryCode = "US";
    private ImageButton selectedCountry;
    private TextView helloTextView;
    private ImageView mapImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WLClient.createInstance(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        selectedCountry = (ImageButton) findViewById(R.id.us);
        helloTextView = (TextView) findViewById(R.id.helloText);
        mapImageView = (ImageView) findViewById(R.id.mapImageView);
        selectCountry (selectedCountry);
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

        LiveUpdateManager.getInstance().obtainConfiguration(countryCode, new ConfigurationListener() {
            @Override
            public void onSuccess(final Configuration configuration) {
                String mapUrl = configuration.getProperty("mapUrl");
                if (configuration.isFeatureEnabled("includeMap") && mapUrl != null) {
                    try {
                        URL url = new URL(mapUrl);
                        final Bitmap bmpMapImage = BitmapFactory.decodeStream(url.openConnection().getInputStream());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mapImageView.setImageBitmap(bmpMapImage);
                            }
                        });
                    } catch (Exception e) {
                        Log.e("Hello Live Update", "Cannot fetch the map image. URL: " + mapUrl + " Error: " + e.getMessage(), e);
                    }
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mapImageView.setImageResource(android.R.color.transparent);
                        }
                    });
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        helloTextView.setText(configuration.getProperty("helloText"));
                    }
                });
            }

            @Override
            public void onFailure(com.worklight.wlclient.api.WLFailResponse wlFailResponse) {
                Log.e("Hello Live Update", wlFailResponse.getErrorMsg());
            }
        });
    }
}
