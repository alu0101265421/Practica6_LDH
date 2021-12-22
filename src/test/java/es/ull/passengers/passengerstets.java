package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Passengers Test")
public class passengerstets {

    private Passenger elena, ana;

    @BeforeEach
    void setUp() {
        elena = new Passenger("id1", "Elena", "ES");
        ana = new Passenger("id2", "Ana", "ES");
    }

    @Test
    @DisplayName("Comprobando el funcionamiento del getter")
    void testGettersPasajeros() {
        assertAll("Verificar los atributos del pasajero Elena",
                () -> assertEquals("id1", elena.getIdentifier(), "Identificacion del pasajero"),
                () -> assertEquals("Elena", elena.getName(), "Nombre pasajero"),
                () -> assertEquals("ES", elena.getCountryCode(), "Pais pasajero"),
                () -> assertEquals("Passenger Elena with identifier: id1 from ES" , elena.toString())
        );
        assertAll("Verificar los atributos del pasajero Ana",
                () -> assertEquals("id2", ana.getIdentifier(), "Identificacion del pasajero"),
                () -> assertEquals("Ana", ana.getName(), "Nombre pasajero"),
                () -> assertEquals("ES", ana.getCountryCode(), "Pais pasajero"),
                () -> assertEquals("Passenger Ana with identifier: id2 from ES" , ana.toString())
        );
    }

    @Test
    @DisplayName("Comprobando que se puede anadir pasajero al vuelo")
    public void testAnadirPasajero() {
        Flight vuelo = new Flight("BA2490", 3);
        Flight vuelo2 = new Flight("BA2491", 0);


        assertAll("Vericar que nos ponemos unir al vuelo",
                () -> assertEquals("BA2490", elena.getFlight().getFlightNumber(), "Configuracion correcta del vuelo y pasajero"),
                () -> assertThrows(RuntimeException.class, () -> ana.joinFlight(vuelo2), "No se puede unir al vuelo")
        );
    }

}
