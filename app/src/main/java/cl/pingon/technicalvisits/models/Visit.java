package cl.pingon.technicalvisits.models;

import com.orm.SugarRecord;

public class Visit extends SugarRecord {

    private String client, project, direction, height, length, observation;
    private boolean visited;

    public Visit() {
    }

    public Visit(String client, String project, String direction, String height, String length, String observation, boolean visited) {
        this.client = client;
        this.project = project;
        this.direction = direction;
        this.visited = visited;
        this.height = height;
        this.length = length;
        this.observation = observation;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}
