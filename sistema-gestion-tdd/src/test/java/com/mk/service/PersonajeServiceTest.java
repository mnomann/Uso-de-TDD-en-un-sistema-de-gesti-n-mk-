package com.mk.service;

import java.util.List;

import com.mk.NivelPoder;
import com.mk.Personaje;
import com.mk.PersonajeRepository;
import com.mk.PersonajeService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;




public class PersonajeServiceTest {

    private PersonajeService service;

    @BeforeEach
    void init() {
        service = new PersonajeService(new PersonajeRepository());
    }

    @Test
    void agregarYObtenerPersonaje() {
        Personaje p = service.agregar("Scorpion", 100, NivelPoder.ALTO, java.util.Arrays.asList("Teleport", "Fire Punch"));
        assertTrue(service.obtener(p.getId()).isPresent());
    }

    @Test
    void editarPersonaje() {
        Personaje p = service.agregar("Sub-Zero", 90, NivelPoder.MEDIO, java.util.Arrays.asList("Ice Ball"));
        service.editar(p.getId(), "Sub-Zero Prime", 95, NivelPoder.ALTO, java.util.Arrays.asList("Slide"));
        assertEquals("Sub-Zero Prime", service.obtener(p.getId()).get().getNombre());
    }

    @Test
    void eliminarPersonaje() {
        Personaje p = service.agregar("Liu Kang", 100, NivelPoder.ALTO, java.util.Arrays.asList("Bicycle Kick"));
        service.eliminar(p.getId());
        assertTrue(!service.obtener(p.getId()).isPresent());
    }

    @Test
    void filtrarPorNivel() {
        service.agregar("Johnny", 85, NivelPoder.BAJO, java.util.Arrays.asList());
        service.agregar("Sonya", 95, NivelPoder.MEDIO, java.util.Arrays.asList());
        assertEquals(1, service.filtrarPorNivelMedioOAlto().size());
    }

    @Test
    void buscarPorNombre() {
        service.agregar("Kano", 80, NivelPoder.BAJO, java.util.Arrays.asList());
        assertEquals(1, service.buscarPorNombre("kano").size());
    }

    @Test
    void ordenarPorSalud() {
        service.agregar("A", 70, NivelPoder.MEDIO, java.util.Arrays.asList());
        service.agregar("B", 90, NivelPoder.ALTO, java.util.Arrays.asList());
        List<Personaje> ordenados = service.ordenarPorSaludDesc();
        assertEquals("B", ordenados.get(0).getNombre());
    }
}
