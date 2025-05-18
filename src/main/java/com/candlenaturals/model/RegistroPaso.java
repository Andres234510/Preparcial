package com.candlenaturals.model;

import java.time.LocalDateTime;

public class RegistroPaso {
    private Vehiculo vehiculo;
    private double montoPagado;
    private LocalDateTime fechaHora;

    public RegistroPaso(Vehiculo vehiculo, double montoPagado) {
        this.vehiculo = vehiculo;
        this.montoPagado = montoPagado;
        this.fechaHora = LocalDateTime.now();
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}