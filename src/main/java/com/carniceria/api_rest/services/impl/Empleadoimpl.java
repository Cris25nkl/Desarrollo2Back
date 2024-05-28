package com.carniceria.api_rest.services.impl;

import com.carniceria.api_rest.model.dao.EmpleadoDAO;
import com.carniceria.api_rest.model.dto.Empleadodto;
import com.carniceria.api_rest.model.entity.Empleado;
import com.carniceria.api_rest.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Empleadoimpl implements EmpleadoService {


    @Autowired
    private EmpleadoDAO empleadoDAO;

    @Transactional
    @Override
    public Empleado Save(Empleadodto empleadodto) {
        Empleado  empleado = Empleado.builder().id(empleadodto.getId())
                .nombre(empleadodto.getNombre())
                .apellido(empleadodto.getApellido())
                .telefono(empleadodto.getTelefono())
                .direccion(empleadodto.getDireccion())
                .cargo(empleadodto.getCargo())
                .password(empleadodto.getPassword())
                .build();
        return empleadoDAO.save(empleado);
    }

    @Transactional(readOnly = true)
    @Override
    public Empleado FindbyID(Integer id) {
        return empleadoDAO.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Empleado empleado) {
        empleadoDAO.delete(empleado);
    }
}
