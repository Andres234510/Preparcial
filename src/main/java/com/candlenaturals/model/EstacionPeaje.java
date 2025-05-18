package com.candlenaturals.model;

import java.util.*;

public class EstacionPeaje {
    private String nombre;
    private String departamento;
    private double totalRecaudado;
    private List<RegistroPaso> registros;
    private List<Recaudador> recaudadores;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.registros = new ArrayList<>();
        this.recaudadores = new ArrayList<>();
    }

    public double registrarPaso(Vehiculo v) {
        double valor = v.calcularPeaje();
        totalRecaudado += valor;
        registros.add(new RegistroPaso(v, valor));
        return valor;
    }

    public void imprimirResumen() {
        registros.forEach(r -> {
            System.out.println(r.getVehiculo().descripcion() + " - Pagó: $" + r.getMontoPagado());
        });
        System.out.println("Total recaudado: $" + totalRecaudado);
    }

    public void agregarRecaudador(Recaudador r) {
        recaudadores.add(r);
    }

    public Recaudador buscarRecaudador(String nombreCompleto) {
        String normalizado = nombreCompleto.toLowerCase().replaceAll("\\s+", "");
        return recaudadores.stream()
                .filter(r -> r.getNombreCompletoNormalizado().equals(normalizado))
                .findFirst()
                .orElse(null);
    }
}
