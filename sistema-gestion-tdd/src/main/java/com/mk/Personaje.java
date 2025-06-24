package com.mk;

import java.util.List;

public class Personaje {
    private static long contador = 0;
    private final long id;
    private String nombre;
    private int saludMaxima;
    private NivelPoder nivel;
    private List<String> movimientos;

    public Personaje(String nombre, int saludMaxima, NivelPoder nivel, List<String> movimientos) {
        this.id = ++contador;
        this.nombre = nombre;
        this.saludMaxima = saludMaxima;
        this.nivel = nivel;
        this.movimientos = movimientos;
    }

    public long getId() { 
        return id;
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public int getSaludMaxima() { 
        return saludMaxima; 
    }
    public void setSaludMaxima(int saludMaxima) { 
        this.saludMaxima = saludMaxima; 
    }

    public NivelPoder getNivel() { 
        return nivel; 
    }
    public void setNivel(NivelPoder nivel) { 
        this.nivel = nivel; 
    }

    public List<String> getMovimientos() { 
        return movimientos; 
    }
    public void setMovimientos(List<String> movimientos) { 
        this.movimientos = movimientos; 
    }
}
