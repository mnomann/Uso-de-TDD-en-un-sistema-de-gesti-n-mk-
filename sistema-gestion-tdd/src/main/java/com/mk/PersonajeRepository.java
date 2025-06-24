package com.mk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonajeRepository {
    private final Map<Long, Personaje> personajes = new HashMap<>();

    public void agregar(Personaje p) {
        personajes.put(p.getId(), p);
    }

    public Optional<Personaje> obtener(long id) {
        return Optional.ofNullable(personajes.get(id));
    }

    public void eliminar(long id) {
        personajes.remove(id);
    }

    public Collection<Personaje> listarTodos() {
        return personajes.values();
    }
}
