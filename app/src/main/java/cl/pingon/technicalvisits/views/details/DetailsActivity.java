package cl.pingon.technicalvisits.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import cl.pingon.technicalvisits.R;
import cl.pingon.technicalvisits.data.Queries;
import cl.pingon.technicalvisits.models.Visit;
import cl.pingon.technicalvisits.views.main.VisitsFragment;

public class DetailsActivity extends AppCompatActivity {

    private long visit_id;;
    private Visit visit;
    EditText heightEt;
    EditText lenghtEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        visit_id = getIntent().getLongExtra(VisitsFragment.VISIT_ID, 0);

        visit = new Queries().byId(visit_id);

        getSupportActionBar().setTitle(visit.getClient());


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        String client = visit.getClient();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
