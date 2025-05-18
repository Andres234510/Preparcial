package com.candlenaturals.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Conductor {
    private String nombre;
    private String apellidos;
    private String documento;
    private LocalDate fechaNacimiento;
    private List<Vehiculo> vehiculos;

    public Conductor(String nombre, String apellidos, String documento, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.documento = documento;
        this.fechaNacimiento = fechaNacimiento;
        this.vehiculos = new ArrayList<>();
    }

    public void asignarVehiculo(Vehiculo v) {
        vehiculos.add(v);
        v.asignarConductor(this);
    }

    public List<Vehiculo> vehiculosPorTipo(TipoVehiculo tipo) {
        return vehiculos.stream().filter(v -> v.getTipo() == tipo).collect(Collectors.toList());
    }

    public boolean tieneCamionConAltaCarga() {
        return vehiculos.stream().anyMatch(v -> v instanceof Camion && ((Camion)v).getCapacidadCargaToneladas() > 10);
    }

    public double totalPeajesPagados() {
        return vehiculos.stream().mapToDouble(Vehiculo::calcularPeaje).sum();
    }
}
