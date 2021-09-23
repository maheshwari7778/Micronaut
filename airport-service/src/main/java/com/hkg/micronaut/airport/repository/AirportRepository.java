package com.hkg.micronaut.airport.repository;

import com.hkg.micronaut.airport.entity.Airport;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long>{

    @Executable
    Airport findByAirportCode(String airportCode);


}