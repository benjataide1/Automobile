package org.myapp.automobile.logic;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity
public class Automovil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_Automovil;

    @Basic
    private String model;
    private String brand;
    private String motor;
    private String color;
    private String patente;
    private int countPuertas;


    public Automovil() {
    }

    public Automovil(String model, String brand, String motor, String color, String patente, int countPuertas) {
        this.model = model;
        this.brand = brand;
        this.motor = motor;
        this.color = color;
        this.patente = patente;
        this.countPuertas = countPuertas;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCountPuertas() {
        return countPuertas;
    }

    public void setCountPuertas(int countPuertas) {
        this.countPuertas = countPuertas;
    }

    public int getId_Automovil() {
        return this.id_Automovil;
    }

    public void setId_Automovil(int id_Automovil) {
        this.id_Automovil = id_Automovil;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Automovil{");
        sb.append("brand='").append(brand).append('\'');
        sb.append(", id_Automovil=").append(id_Automovil);
        sb.append(", model='").append(model).append('\'');
        sb.append(", motor='").append(motor).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", patente='").append(patente).append('\'');
        sb.append(", countPuertas=").append(countPuertas);
        sb.append('}');
        return sb.toString();
    }
}
