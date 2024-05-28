package com.carniceria.api_rest.model.dao;

import com.carniceria.api_rest.model.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDAO extends CrudRepository<Empleado, Integer> {

}
