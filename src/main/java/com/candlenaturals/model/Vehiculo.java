package com.candlenaturals.model;

public abstract class Vehiculo implements Descriptible {
    protected String placa;
    protected int peajesPagados;
    protected TipoVehiculo tipo;
    protected Conductor conductor;

    public Vehiculo(String placa, TipoVehiculo tipo) {
        this.placa = placa;
        this.tipo = tipo;
        this.peajesPagados = 0;
    }

    public abstract double calcularPeaje();

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void asignarConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Conductor getConductor() {
        return conductor;
    }
}