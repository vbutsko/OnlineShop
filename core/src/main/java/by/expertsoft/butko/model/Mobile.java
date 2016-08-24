package by.expertsoft.butko.model;

/**
 * Created by wladek on 09.08.16.
 */
public class Mobile{
    private int id;
    private String name;
    private double cost;
    private Producer producer;

    public Mobile(){

    }

    public Mobile(int id, String name, double cost, Producer producer){
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
