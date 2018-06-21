package cl.pingon.technicalvisits.views.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import cl.pingon.technicalvisits.R;
import cl.pingon.technicalvisits.models.Visit;

public class MainActivity extends AppCompatActivity {

    private VisitsFragment visitsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        visitsFragment = (VisitsFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_visit);

                ImageButton button = dialog.findViewById(R.id.saveBtn);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        EditText clientEt = dialog.findViewById(R.id.clientEt);
                        String client = clientEt.getText().toString();

                        EditText projectEt = dialog.findViewById(R.id.projectEt);

                        String project = projectEt.getText().toString();

                        EditText directionEt = dialog.findViewById(R.id.directionEt);

                        String direction = directionEt.getText().toString();

                        if (client.trim().length() > 0 && project.trim().length() > 0 && direction.trim().length() > 0) {
                            Visit visit = new Visit();
                            visit.setClient(client);
                            visit.setProject(project);
                            visit.setDirection(direction);
                            visit.setVisited(false);
                            visit.save();
                            visitsFragment.updateList(visit);
                        } else {
                            Toast.makeText(MainActivity.this, "Debe completar los 3 campos", Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();

                    }
                });


                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
