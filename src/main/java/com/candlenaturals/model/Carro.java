package com.candlenaturals.model;

public class Carro extends Vehiculo {
    private boolean esElectrico;
    private boolean esServicioPublico;

    public Carro(String placa, boolean esElectrico, boolean esServicioPublico) {
        super(placa, TipoVehiculo.CARRO);
        this.esElectrico = esElectrico;
        this.esServicioPublico = esServicioPublico;
    }

    @Override
    public double calcularPeaje() {
        double valor = 10000;
        if (esElectrico) valor *= 0.8;
        if (esServicioPublico) valor *= 1.15;
        return valor;
    }

    @Override
    public String descripcion() {
        return "Carro - Placa: " + placa + ", Eléctrico: " + esElectrico + ", Servicio Público: " + esServicioPublico;
    }
}