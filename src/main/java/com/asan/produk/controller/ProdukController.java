package com.asan.produk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.asan.produk.entity.Produk;

@RestController 
@RequestMapping("api/produk")
public class ProdukController {

    // Simpan data produk secara dinamis di memory
    private final List<Produk> produkList = new ArrayList<>(List.of(
        new Produk(1, "Mouse", 100000, "Mouse gaming"),
        new Produk(2, "Keyboard", 150000, "Keyboard mechanical"),
        new Produk(3, "Monitor", 2000000, "Monitor gaming"),
        new Produk(4, "Headphone", 500000, "Headphone gaming"),
        new Produk(5, "Speaker", 250000, "Speaker gaming")
    ));

    // 1. GET ALL: Menampilkan semua produk secara dinamis
    @GetMapping
    public List<Produk> getAllProduk() {
        return produkList;
    }

    // 2. GET BY ID: Mencari produk berdasarkan ID secara dinamis
    @GetMapping("/{id}")
    public ResponseEntity<Produk> getProdukById(@PathVariable("id") int id) {
        return produkList.stream()
            .filter(p -> p.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // 3. POST: Menambahkan produk baru ke dalam list secara dinamis
    @PostMapping 
    public ResponseEntity<Produk> createProduk(@RequestBody Produk produk) {
        produkList.add(produk);
        return ResponseEntity.ok(produk);
    }
}
