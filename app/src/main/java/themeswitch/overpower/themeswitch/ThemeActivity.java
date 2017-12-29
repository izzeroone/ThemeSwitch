package themeswitch.overpower.themeswitch;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class ThemeActivity extends AppCompatActivity {

    private int SETTINGS_ACTION = 1;

    public void onCreate(final Bundle savedInstanceState) {
        SharedPreferences pref = PreferenceManager
                .getDefaultSharedPreferences(this);
        String themeName = pref.getString("theme", "Theme1");
        switch (themeName)
        {
            case "Light Blue Theme":
                setTheme(R.style.Light_Blue_Theme);
                break;
            case "Light Green Theme":
                setTheme(R.style.Light_Green_Theme);
                break;
            case "Light Pink Theme":
                setTheme(R.style.Light_Pink_Theme);
                break;
            case "Dark Blue Theme":
                setTheme(R.style.Dark_Blue_Theme);
                break;
            case "Dark Green Theme":
                setTheme(R.style.Dark_Green_Theme);
                break;
            case "Dark Pink Theme":
                setTheme(R.style.Dark_Pink_Theme);
                break;
        }

        Toast.makeText(this, "Theme has been reset to " + themeName,
                Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.settings:
                startActivityForResult(new Intent(this,
                        ThemePreferenceActivity.class), SETTINGS_ACTION);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SETTINGS_ACTION) {
            if (resultCode == ThemePreferenceActivity.RESULT_CODE_THEME_UPDATED) {
                finish();
                startActivity(getIntent());
                return;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
