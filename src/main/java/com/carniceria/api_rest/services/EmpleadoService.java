package com.carniceria.api_rest.services;

import com.carniceria.api_rest.model.dto.Empleadodto;
import com.carniceria.api_rest.model.entity.Empleado;

public interface EmpleadoService {
    Empleado Save(Empleadodto empleado);

    Empleado FindbyID(Integer id);

    void delete(Empleado empleado);

}
