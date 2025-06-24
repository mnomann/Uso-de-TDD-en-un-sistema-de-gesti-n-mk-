package com.mk;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonajeService {
    
    private final PersonajeRepository repo;

    public PersonajeService(PersonajeRepository repo) {
        this.repo = repo;
    }

    public Personaje agregar(String nombre, int salud, NivelPoder nivel, List<String> movimientos) {
        Personaje p = new Personaje(nombre, salud, nivel, movimientos);
        repo.agregar(p);
        return p;
    }

    public Optional<Personaje> obtener(long id) {
        return repo.obtener(id);
    }

    public void editar(long id, String nombre, int salud, NivelPoder nivel, List<String> movimientos) {
        Optional<Personaje> op = repo.obtener(id);
        op.ifPresent(p -> {
            p.setNombre(nombre);
            p.setSaludMaxima(salud);
            p.setNivel(nivel);
            p.setMovimientos(movimientos);
        });
    }

    public void eliminar(long id) {
        repo.eliminar(id);
    }

    public List<Personaje> listarTodos() {
        return new ArrayList<>(repo.listarTodos());
    }

    public List<Personaje> buscarPorNombre(String filtro) {
        return repo.listarTodos().stream()
            .filter(p -> p.getNombre().toLowerCase().contains(filtro.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<Personaje> filtrarPorNivelMedioOAlto() {
        return repo.listarTodos().stream()
            .filter(p -> p.getNivel() == NivelPoder.MEDIO || p.getNivel() == NivelPoder.ALTO)
            .collect(Collectors.toList());
    }

    public List<Personaje> ordenarPorSaludDesc() {
        return repo.listarTodos().stream()
            .sorted((a, b) -> Integer.compare(b.getSaludMaxima(), a.getSaludMaxima()))
            .collect(Collectors.toList());
    }
}
