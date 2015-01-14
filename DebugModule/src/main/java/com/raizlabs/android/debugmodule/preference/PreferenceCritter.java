package com.raizlabs.android.debugmodule.preference;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.raizlabs.android.debugmodule.Critter;
import com.raizlabs.android.debugmodule.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: Provides a basic UI and operations for changing specified preferences on the fly.
 */
public class PreferenceCritter implements Critter {

    private List<PreferenceBuilder> mPreferences = new ArrayList<>();

    /**
     * Adds this {@link com.raizlabs.android.debugmodule.preference.PreferenceBuilder} to the list of manipulated preferences.
     *
     * @return This instance
     */
    public PreferenceCritter addPreference(PreferenceBuilder preferenceBuilder) {
        if (!mPreferences.contains(preferenceBuilder)) {
            mPreferences.add(preferenceBuilder);
        }
        return this;
    }


    @Override
    public int getLayoutResId() {
        return R.layout.view_debug_module_preferences;
    }

    @Override
    public void handleView(View view) {
        ListView listView = (ListView) view.findViewById(R.id.view_debug_module_preferences_listView);
        listView.setAdapter(new PreferenceAdapter());
    }

    private class PreferenceAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mPreferences.size();
        }

        @Override
        public PreferenceBuilder getItem(int position) {
            return mPreferences.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}