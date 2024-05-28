package com.carniceria.api_rest.controller;


import com.carniceria.api_rest.model.dto.Empleadodto;
import com.carniceria.api_rest.model.entity.Empleado;
import com.carniceria.api_rest.services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @PostMapping("empleado")
    public Empleadodto create(@RequestBody Empleadodto empleadodto) {
        Empleado empleadoSave = empleadoService.Save(empleadodto);
        return Empleadodto.builder()
                .id(empleadoSave.getId())
                .nombre(empleadoSave.getNombre())
                .apellido(empleadoSave.getApellido())
                .telefono(empleadoSave.getTelefono())
                .direccion(empleadoSave.getDireccion())
                .cargo(empleadoSave.getCargo())
                .password(empleadodto.getPassword())
                .build();
    }

    @PutMapping("empleado")
    public Empleadodto update(@RequestBody Empleadodto empleadodto) {
        Empleado empleadoUpdate = empleadoService.Save(empleadodto);
        return Empleadodto.builder()
                .id(empleadoUpdate.getId())
                .nombre(empleadoUpdate.getNombre())
                .apellido(empleadoUpdate.getApellido())
                .telefono(empleadoUpdate.getTelefono())
                .direccion(empleadoUpdate.getDireccion())
                .cargo(empleadoUpdate.getCargo())
                .password(empleadodto.getPassword())
                .build();
    }

    @DeleteMapping("empleado/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Empleado empleadoDelete = empleadoService.FindbyID(id);
            empleadoService.delete(empleadoDelete);
            return new ResponseEntity<>(empleadoDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            response.put("mensaje", exDt.getMessage());
            response.put("cliente", null);
            return  new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

}

    }
    @GetMapping("empleado/{id}")

    public Empleadodto ShowByID (@PathVariable Integer id){
        Empleado empleado = empleadoService.FindbyID(id);
        return Empleadodto.builder()
                .id(empleado.getId())
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .telefono(empleado.getTelefono())
                .direccion(empleado.getDireccion())
                .cargo(empleado.getCargo())
                .password(empleado.getPassword())
                .build();
    }
}
