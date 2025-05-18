package com.candlenaturals.service;

import com.candlenaturals.model.*;
import java.util.List;
import java.util.stream.Collectors;

public class PeajeService {

    // Registra el paso del vehículo y retorna el valor del peaje
    public double procesarPeaje(EstacionPeaje peaje, Vehiculo vehiculo) {
        return peaje.registrarPaso(vehiculo);
    }

    // Devuelve los vehículos de un conductor que son de tipo CAMION y con carga > 10t
    public List<Camion> obtenerCamionesPesados(Conductor conductor) {
        return conductor.vehiculosPorTipo(TipoVehiculo.CAMION).stream()
                .map(v -> (Camion) v)
                .filter(c -> c.getCapacidadCargaToneladas() > 10)
                .collect(Collectors.toList());
    }

    // Devuelve los recaudadores encontrados por nombre completo
    public Recaudador buscarRecaudadorPorNombre(EstacionPeaje peaje, String nombreCompleto) {
        return peaje.buscarRecaudador(nombreCompleto);
    }

    // Imprime un resumen de todos los vehículos que pasaron por el peaje
    public void imprimirResumenPeaje(EstacionPeaje peaje) {
        peaje.imprimirResumen();
    }
}
