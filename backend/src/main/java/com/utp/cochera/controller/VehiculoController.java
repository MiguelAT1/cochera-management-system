package com.utp.cochera.controller;

import com.utp.cochera.model.Vehiculo;
import com.utp.cochera.service.VehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {
    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public List<Vehiculo> listar() { return vehiculoService.listar(); }

    @GetMapping("/{id}")
    public Vehiculo buscar(@PathVariable Long id) { return vehiculoService.buscarPorId(id); }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehiculo crear(@RequestBody Vehiculo vehiculo) { return vehiculoService.crear(vehiculo); }

    @PutMapping("/{id}")
    public Vehiculo actualizar(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return vehiculoService.actualizar(id, vehiculo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) { vehiculoService.eliminar(id); }
}
