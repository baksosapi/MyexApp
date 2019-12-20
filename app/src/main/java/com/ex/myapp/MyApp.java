package com.ex.myapp;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

public class MyApp extends Application {

    private static final String TAG = MyApp.class.getSimpleName();

    public static final String MY_PREFERENCES = "my_preferences";

    private SharedPreferences.Editor settingsEditor;
    private SharedPreferences settings;

    @Override
    public void onCreate() {
        super.onCreate();

        this.settings = getSharedPreferences(MY_PREFERENCES, 0);
        this.settingsEditor = this.settings.edit();

        initPreferences();

    }

    private void initPreferences() {
        PreferenceManager.setDefaultValues(this, R.xml.preferences, true);
        Log.d(TAG, "initPreferences: ");
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(this).edit();
        getSettingsEditor().apply();
        edit.apply();

    }

    public SharedPreferences.Editor getSettingsEditor() {
        return this.settingsEditor;
    }
}
