package cl.pingon.technicalvisits.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.logging.Handler;

import cl.pingon.technicalvisits.R;
import cl.pingon.technicalvisits.data.Queries;
import cl.pingon.technicalvisits.models.Visit;

public class VisitsAdapter extends RecyclerView.Adapter<VisitsAdapter.ViewHolder> {

    private List<Visit> visits = new Queries().visits();

    private VisitClickListener listener;

    public VisitsAdapter(VisitClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public VisitsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_visits, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final VisitsAdapter.ViewHolder holder, int position) {

        final Visit visit = visits.get(position);
        holder.clientTv.setText(visit.getClient());
        holder.projectTv.setText(visit.getProject());
        holder.directionTv.setText(visit.getDirection());
        holder.visitedCb.setChecked(visit.isVisited());

        holder.visitedCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    new android.os.Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            int auxPosition = holder.getAdapterPosition();
                            Visit auxVisit = visits.get(auxPosition);
                            auxVisit.setVisited(true);
                            auxVisit.save();
                       //     visits.remove(auxPosition);
                       //     notifyItemMoved(auxPosition);
                        }
                    }, 400);
                }

            }
        });

        holder.clientTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Visit auxVisit = visits.get(holder.getAdapterPosition());
                listener.clikedID(auxVisit.getId());

            }
        });

        holder.projectTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Visit auxVisit = visits.get(holder.getAdapterPosition());
                listener.clikedID(auxVisit.getId());

            }
        });

        holder.directionTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Visit auxVisit = visits.get(holder.getAdapterPosition());
                listener.clikedID(auxVisit.getId());

            }
        });





    }


    @Override
    public int getItemCount() {
        return visits.size();
    }

    public void update(Visit visit) {
        visits.add(visit);
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox visitedCb;
        private TextView clientTv;
        private TextView projectTv;
        private TextView directionTv;

        public ViewHolder(View itemView) {
            super(itemView);

            visitedCb = itemView.findViewById(R.id.visitedCb);
            clientTv = itemView.findViewById(R.id.clientTv);
            projectTv = itemView.findViewById(R.id.projectTv);
            directionTv = itemView.findViewById(R.id.directionTv);
        }

    }

}
