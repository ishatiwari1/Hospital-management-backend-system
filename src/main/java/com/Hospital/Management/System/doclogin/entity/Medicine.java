package com.Hospital.Management.System.doclogin.entity;


import jakarta.persistence.*;

@Entity
@Table(name="Medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    public Medicine() {
    }
    @Column(name = "medicine_name")
    private String medicineName;

    private String stock;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public Medicine(long id, String medicineName, String stock) {
        this.id = id;
        this.medicineName = medicineName;
        this.stock = stock;

    }

    public Object getDrugName() {
        return null;
    }

    public void setDrugName(Object drugName) {
    }
}
