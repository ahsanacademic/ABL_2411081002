package com.asan.pelanggan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.asan.pelanggan.entity.Pelanggan;
import com.asan.pelanggan.repository.PelangganRepository;

@Service
public class PelangganService {

  @Autowired
  private PelangganRepository pelangganRepository;

  public List<Pelanggan> getAllPelanggan() {
    return pelangganRepository.findAll();
  }

  public Pelanggan savePelanggan(Pelanggan pelanggan) {
    return pelangganRepository.save(pelanggan);
  }

  public Pelanggan getPelangganById(Long id) {
    return pelangganRepository.findById(id).orElse(null);
  }

  public void deletePelanggan(Long id) {
    pelangganRepository.deleteById(id);
  }
}
