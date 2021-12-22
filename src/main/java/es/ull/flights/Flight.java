/*
 * ========================================================================
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ========================================================================
 */
package es.ull.flights;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.passengers.Passenger;

/**
 * @brief Clase Vuelo
 * @author Elena Rijo Garcia - alu0101265421
 */
public class Flight {

    private String flightNumber;
    private int seats;
    private Set<Passenger> passengers = new HashSet<>();

    private static String flightNumberRegex = "^[A-Z]{2}\\d{3,4}$";
    private static Pattern pattern = Pattern.compile(flightNumberRegex);

    /**
     * @brief Constructor de Vuelo
     * @Param flightNumber = identificador del vuelo
     * @Param seats = numero de asiento
     */
    public Flight(String flightNumber, int seats) {
        Matcher matcher = pattern.matcher(flightNumber);
        if (!matcher.matches()) {
            throw new RuntimeException("Invalid flight number");
        }
        this.flightNumber = flightNumber;
        this.seats = seats;
    }

    /**
     * @brief Getter del identificador del vuelo
     * @Return Devuelve el resultado de una string del identificador del vuelo
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @brief Getter del numero de pasajeros que hay
     * @Return Devuelve el resultado de una entero con la cantidad de pasajeros
     */
    public int getNumberOfPassengers() {
        return passengers.size();
    }

    /**
     * @brief Funcion para añadir pasajeros
     * @Param passenger = pasajero
     * @Return Devuelve el resultado de un booleano que comprueba si ha sido correcto añadirlo o no
     */
    public boolean addPassenger(Passenger passenger) {
        if (getNumberOfPassengers() >= seats) {
            throw new RuntimeException("Not enough seats for flight " + getFlightNumber());
        }
        passenger.setFlight(this);
        return passengers.add(passenger);
    }

    /**
     * @brief Funcion para eliminar a un pasajero
     * @Param passenger = pasajero
     * @Return Devuelve el resultado de un booleano para comoprobar si correcta funcionalidad
     */
    public boolean removePassenger(Passenger passenger) {
        passenger.setFlight(null);
        return passengers.remove(passenger);
    }

}
