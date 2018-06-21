package cl.pingon.technicalvisits.views.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import cl.pingon.technicalvisits.R;
import cl.pingon.technicalvisits.data.Queries;
import cl.pingon.technicalvisits.models.Visit;
import cl.pingon.technicalvisits.views.main.VisitsFragment;

public class DetailsActivity extends AppCompatActivity {

    private long visit_id;
    ;
    private Visit visit;
    EditText heightEt;
    EditText lenghtEt;
    EditText observationEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        visit_id = getIntent().getLongExtra(VisitsFragment.VISIT_ID, 0);

        visit = new Queries().byId(visit_id);

        getSupportActionBar().setTitle(visit.getClient());

        heightEt = findViewById(R.id.heightEt);
        lenghtEt = findViewById(R.id.lengthEt);
        observationEt = findViewById(R.id.observationEt);


    }

    @Override
    protected void onResume() {
        super.onResume();

        String height = visit.getHeight();
        String lenght = visit.getLength();
        String observation = visit.getObservation();

        if (height != null && lenght != null && observation != null) {
            heightEt.setText(height);
            lenghtEt.setText(lenght);
            observationEt.setText(observation);
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        String height;
        String lenght;
        String observation;
        height = heightEt.getText().toString();
        lenght = lenghtEt.getText().toString();
        observation = observationEt.getText().toString();
        visit.setHeight(height);
        visit.setLength(lenght);
        visit.setObservation(observation);
        visit.save();

    }
}
