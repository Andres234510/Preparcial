package com.candlenaturals;

import com.candlenaturals.model.*;
import java.time.LocalDate;
import com.candlenaturals.service.PeajeService;
import com.candlenaturals.util.Normalizador;

public class Main {
    public static void main(String[] args) {
        PeajeService peajeService = new PeajeService();

        // Crear estación de peaje
        EstacionPeaje peaje = new EstacionPeaje("Peaje Quimbaya", "Quindío");

        // Crear recaudador y agregarlo
        Recaudador recaudador = new Recaudador("Carlos", "López", "12345", LocalDate.of(1990, 3, 15), 2500000);
        peaje.agregarRecaudador(recaudador);

        // Crear conductor
        Conductor conductor = new Conductor("Ana", "Martínez", "67890", LocalDate.of(1985, 7, 20));

        // Crear vehículos
        Carro carro = new Carro("ABC123", true, true); // eléctrico y público
        Moto moto = new Moto("XYZ789", 250); // cilindraje > 200
        Camion camion = new Camion("TRK456", 4, 12); // 4 ejes, > 10 toneladas

        // Asignar vehículos al conductor
        conductor.asignarVehiculo(carro);
        conductor.asignarVehiculo(moto);
        conductor.asignarVehiculo(camion);

        // Registrar el paso de los vehículos usando el servicio
        peajeService.procesarPeaje(peaje, carro);
        peajeService.procesarPeaje(peaje, moto);
        peajeService.procesarPeaje(peaje, camion);

        // Imprimir resumen de peajes
        System.out.println("\\n--- Resumen del Peaje ---");
        peajeService.imprimirResumenPeaje(peaje);

        // Buscar recaudador por nombre completo normalizado
        String nombreBuscado = "  CARLOS    lopez ";
        Recaudador encontrado = peajeService.buscarRecaudadorPorNombre(peaje, nombreBuscado);
        System.out.println("\\nRecaudador encontrado: " + (encontrado != null ? "Sí" : "No"));

        // Consultar si el conductor tiene camiones con alta carga
        boolean tienePesado = peajeService.obtenerCamionesPesados(conductor).size() > 0;
        System.out.println("¿Conductor tiene camión de alta carga? " + tienePesado);

        // Consultar total de peajes pagados por sus vehículos
        System.out.println("Total de peajes pagados por el conductor: $" + conductor.totalPeajesPagados());
    }
}