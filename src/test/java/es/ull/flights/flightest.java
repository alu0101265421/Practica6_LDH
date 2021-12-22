package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Flight Test")
public class flightest {

    private Flight vuelo, vuelo2;
    private Passenger elena, ana;


    @BeforeEach
    void setUp() {
        vuelo = new Flight("BA2490", 1);
        vuelo2 = new Flight("BA2491", 10);
        elena = new Passenger("id1", "Elena", "ES");
        ana = new Passenger("id2", "Ana", "ES");
    }

    @Test
    @DisplayName("Anadir varios pasajeros")
    void testAnadirPasajeros() {
        assertAll("Agregar pasajeros si hay asientos disponibles",
                () -> assertTrue(vuelo.addPassenger(elena), "Pasajero añadido en el vuelo"),
                () -> assertThrows(RuntimeException.class, ()-> vuelo.addPassenger(ana), "No se peude anadir pasajeros. Vuelo lleno")
        );
    }

    @Test
    @DisplayName("Eliminar pasajeros")
    void testEliminarPasajeros() {
        assertAll("Comprobar que se pueden eliminar pasajeros",
                () -> assertTrue(vuelo2.addPassenger(elena), "Pasajero añadido en el vuelo"),
                () -> assertTrue(vuelo2.addPassenger(ana), "Pasajero añadido en el vuelo"),
                () -> assertTrue(vuelo2.removePassenger(ana), "Pasajero eliminado del vuelo"),
                () -> assertEquals(9, vuelo2.getNumberOfPassengers(), "Quedan 9 pasajeros en el vuelo")
        );
    }

}
