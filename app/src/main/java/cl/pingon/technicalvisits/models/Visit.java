package cl.pingon.technicalvisits.models;

import com.orm.SugarRecord;

public class Visit extends SugarRecord {

    private String client, project, direction;
    private boolean visited;

    public Visit() {
    }

    public Visit(String client, String project, String direction, boolean visited) {
        this.client = client;
        this.project = project;
        this.direction = direction;
        this.visited = visited;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
