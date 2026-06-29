package com.utp.cochera.controller;

import com.utp.cochera.dto.PlacaRequest;
import com.utp.cochera.model.RegistroEstacionamiento;
import com.utp.cochera.service.CocheraService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/cochera")
@CrossOrigin(origins = "*")
public class CocheraController {
    private final CocheraService cocheraService;

    public CocheraController(CocheraService cocheraService) {
        this.cocheraService = cocheraService;
    }

    @PostMapping("/entrada")
    public RegistroEstacionamiento registrarEntrada(@RequestBody PlacaRequest request) {
        return cocheraService.registrarEntrada(request.getPlaca());
    }

    @PostMapping("/salida")
    public RegistroEstacionamiento registrarSalida(@RequestBody PlacaRequest request) {
        return cocheraService.registrarSalida(request.getPlaca());
    }

    @GetMapping("/registros")
    public List<RegistroEstacionamiento> listarRegistros() {
        return cocheraService.listarRegistros();
    }

    @GetMapping("/promocion/{placa}")
    public Map<String, String> obtenerPromocion(@PathVariable String placa) {
        return Map.of("mensaje", cocheraService.obtenerPromocion(placa));
    }
}
