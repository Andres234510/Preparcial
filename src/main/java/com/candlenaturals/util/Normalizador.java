package com.candlenaturals.util;

public class Normalizador {

    // Normaliza un nombre completo eliminando espacios y convirtiendo a minúsculas
    public static String normalizarNombreCompleto(String nombreCompleto) {
        return nombreCompleto.toLowerCase().replaceAll("\\s+", "");
    }
}