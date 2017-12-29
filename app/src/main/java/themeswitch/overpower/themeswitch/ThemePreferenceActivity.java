package themeswitch.overpower.themeswitch;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.Preference.OnPreferenceChangeListener;

import static themeswitch.overpower.themeswitch.R.xml.preferences;

public class ThemePreferenceActivity extends PreferenceActivity {
    public static final int RESULT_CODE_THEME_UPDATED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(preferences);
        findPreference("theme").setOnPreferenceChangeListener(new RefershActivityOnPreferenceChangeListener(RESULT_CODE_THEME_UPDATED));
    }

    private class RefershActivityOnPreferenceChangeListener implements OnPreferenceChangeListener {
        private final int resultCode;
        public RefershActivityOnPreferenceChangeListener(int resultCode) {
            this.resultCode = resultCode;
        }

        @Override
        public boolean onPreferenceChange(Preference p, Object newValue) {
            setResult(resultCode);
            return true;
        }
    }
}