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
package es.ull.passengers;

import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.ull.flights.Flight;

/**
 * @brief Clase pasajeros
 * @author Elena Rijo Garcia - alu0101265421
 */
public class Passenger {

    private String identifier;
    private String name;
    private String countryCode;
    private Flight flight;

    /**
     * @brief Constructor de pasajeros
     * @Param identifier = identificador del pasajero
     * @Param name = nombre del pasajero
     * @Param countryCode = ciudad del pasajero
     */
    public Passenger(String identifier, String name, String countryCode) {
        if (!Arrays.asList(Locale.getISOCountries()).contains(countryCode)) {
            throw new RuntimeException("Invalid country code");
        }

        this.identifier = identifier;
        this.name = name;
        this.countryCode = countryCode;
    }

    /**
     * @brief Getter del identificador
     * @Return Devuelve el resultado de una string del identificador
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @brief Getter del nombre
     * @Return Devuelve el resultado de una string del nombre
     */
    public String getName() {
        return name;
    }

    /**
     * @brief Getter del pais
     * @Return Devuelve el resultado de una string del pais
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @brief Getter del vuelo
     * @Return Devuelve el resultado del vuelo al que pertenece
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @brief Funcion para unir un pasajero al vuelo
     */
    public void joinFlight(Flight flight) {
        Flight previousFlight = this.flight;
        if (null != previousFlight) {
            if (!previousFlight.removePassenger(this)) {
                throw new RuntimeException("Cannot remove passenger");
            }
        }
        setFlight(flight);
        if (null != flight) {
            if (!flight.addPassenger(this)) {
                throw new RuntimeException("Cannot add passenger");
            }
        }
    }

    /**
     * @brief Setter del vuelo
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * @brief Funcion para pasar a string los parametros del pasajero
     * @Return Devuelve el resultado de pasar la cadena a string
     */
    @Override
    public String toString() {
        return "Passenger " + getName() + " with identifier: " + getIdentifier() + " from " + getCountryCode();
    }
}
