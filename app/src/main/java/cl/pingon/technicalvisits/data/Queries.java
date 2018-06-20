package cl.pingon.technicalvisits.data;

import java.util.ArrayList;
import java.util.List;

import cl.pingon.technicalvisits.models.Visit;

public class Queries {

    public List<Visit> visits() {

        List<Visit> visits = new ArrayList<>();
        List<Visit> visitList = Visit.find(Visit.class, "visited = 0");
        if (visitList != null && visitList.size() > 0) {
            visits.addAll(visitList);
        }

        return visits;

    }

    public Visit byId(long idvisit) {
        Visit visit;
        visit = Visit.findById(Visit.class, idvisit);
        return visit;

    }

}
