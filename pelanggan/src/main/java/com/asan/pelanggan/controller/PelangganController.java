package com.asan.pelanggan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asan.pelanggan.entity.Pelanggan;
import com.asan.pelanggan.service.PelangganService;

@RestController
@RequestMapping("/api/pelanggan")
public class PelangganController {

  @Autowired
  private PelangganService pelangganService;

  @GetMapping
  public List<Pelanggan> getAllPelanggan() {
    return pelangganService.getAllPelanggan();
  }

  @PostMapping
  public ResponseEntity<Pelanggan> createPelanggan(@RequestBody Pelanggan pelanggan) {
    return ResponseEntity.ok(pelangganService.savePelanggan(pelanggan));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pelanggan> getPelangganById(@PathVariable("id") Long id) {
    return ResponseEntity.ok(pelangganService.getPelangganById(id));
  }

  @DeleteMapping("/{id}")
  public void deletePelanggan(@PathVariable("id") Long id) {
    pelangganService.deletePelanggan(id);
  }
}
