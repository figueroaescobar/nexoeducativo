package com.nigmacode.apiREST.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargo")
public class cargo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_CARGO")
    private int IDCARGO;

    @Column(name="NOMBRE_CARGO")
    private String NOMBRE_CARGO;

    public cargo(){}

    public cargo(int ID_CARGO, String NOMBRE_CARGO){
        this.IDCARGO = ID_CARGO;
        this.NOMBRE_CARGO = NOMBRE_CARGO;
    }

    public int getID_CARGO() {
        return IDCARGO;
    }

    public void setID_CARGO(int iD_CARGO) {
        this.IDCARGO = iD_CARGO;
    }

    public String getNOMBRE_CARGO() {
        return NOMBRE_CARGO;
    }

    public void setNOMBRE_CARGO(String NOMBRE_CARGO) {
        this.NOMBRE_CARGO = NOMBRE_CARGO;
    }
    
    @Override
    public String toString(){
        return "cargo [ID_CARGO=" + IDCARGO
               + ", NOMBRE_CARGO=" + NOMBRE_CARGO + "]";
    }
}
