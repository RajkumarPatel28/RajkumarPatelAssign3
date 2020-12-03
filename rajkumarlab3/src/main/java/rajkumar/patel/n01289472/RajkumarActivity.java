package rajkumar.patel.n01289472;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//Name: Rajkumar Patel
//Student ID: N01289472
//Section: RNA

public class RajkumarActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rajkumar);
        Toolbar toolbar = findViewById(R.id.rajToolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.rajDrawerLayout);
        NavigationView navigationView = findViewById(R.id.rajNavView);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.rajNavHome, R.id.rajNavFirstname, R.id.rajNavLastname, R.id.rajNavSettings)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.rajNavHostFragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void callIntent(MenuItem item) {
        Intent intent = null;
        intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(getString(R.string.humber_link)));
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.rajNavHostFragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setMessage(getString(R.string.dialog_message));
        dialog.setCancelable(false);
        dialog.setPositiveButton(getString(R.string.dialog_yes), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                RajkumarActivity.this.finish();
            }
        });
        dialog.setNegativeButton(getString(R.string.dialog_no), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialogMessage = dialog.create();
        dialogMessage.setTitle(getString(R.string.dialog_exit));
        dialogMessage.setIcon(R.drawable.question_mark);
        dialogMessage.show();
    }
}