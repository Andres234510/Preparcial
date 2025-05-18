package com.candlenaturals.model;

public class Camion extends Vehiculo {
    private int numeroEjes;
    private double capacidadCargaToneladas;

    public Camion(String placa, int numeroEjes, double capacidadCargaToneladas) {
        super(placa, TipoVehiculo.CAMION);
        this.numeroEjes = numeroEjes;
        this.capacidadCargaToneladas = capacidadCargaToneladas;
    }

    @Override
    public double calcularPeaje() {
        double valor = numeroEjes * 7000;
        if (capacidadCargaToneladas > 10) valor *= 1.1;
        return valor;
    }

    @Override
    public String descripcion() {
        return "Camion - Placa: " + placa + ", Ejes: " + numeroEjes + ", Carga: " + capacidadCargaToneladas + "t";
    }

    public double getCapacidadCargaToneladas() {
        return capacidadCargaToneladas;
    }
}
