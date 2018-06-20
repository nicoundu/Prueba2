package cl.pingon.technicalvisits.views.main;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.pingon.technicalvisits.R;
import cl.pingon.technicalvisits.adapters.VisitClickListener;
import cl.pingon.technicalvisits.adapters.VisitsAdapter;
import cl.pingon.technicalvisits.models.Visit;
import cl.pingon.technicalvisits.views.details.DetailsActivity;

public class VisitsFragment extends Fragment implements VisitClickListener{

    private VisitsAdapter adapter;

    public static final String VISIT_ID = "cl.pingon.technicalvisits.views.main.KEY.VISIT_ID";

    public VisitsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.visitRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new VisitsAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Visit visit) {
        adapter.update(visit);
    }

    @Override
    public void clikedID(long id) {
        Intent intent = new Intent(getContext(), DetailsActivity.class);
        intent.putExtra(VISIT_ID, id);
        startActivity(intent);


    }
}
