package bsuir.model.pojo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class AcceptOrder implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date deadline;
    private int costDelivery;
    private int weight;
    private int enterpriseId;

    public AcceptOrder() {
    }

    public AcceptOrder(int id, String description, Date deadline, int costDelivery, int weight, int enterpriseId) {
        super();
        this.id = id;
        this.description = description;
        this.deadline = deadline;
        this.costDelivery = costDelivery;
        this.weight = weight;
        this.enterpriseId = enterpriseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public int getCostDelivery() {
        return costDelivery;
    }

    public void setCostDelivery(int costDelivery) {
        this.costDelivery = costDelivery;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

}
