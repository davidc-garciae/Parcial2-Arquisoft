package com.udea.parcial.controller;

import com.udea.parcial.model.Pedido;
import com.udea.parcial.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/v2/pedidos")
public class PedidoControllerV2 {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Pedido>> getPedido(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);
        if (pedido.isPresent()) {
            EntityModel<Pedido> resource = EntityModel.of(pedido.get());
            WebMvcLinkBuilder linkToPedidos = linkTo(methodOn(this.getClass()).getAllPedidos());
            resource.add(linkToPedidos.withRel("all-pedidos"));
            return ResponseEntity.ok(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        return ResponseEntity.ok(pedidoService.getAllPedidos());
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido savedPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.ok(savedPedido);
    }
}