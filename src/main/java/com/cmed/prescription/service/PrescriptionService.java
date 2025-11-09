package com.cmed.prescription.service;

import com.cmed.prescription.model.Prescription;
import com.cmed.prescription.repository.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrescriptionService {
    private final PrescriptionRepository repo;

    public PrescriptionService(PrescriptionRepository repo) {
        this.repo = repo;
    }

    public Prescription save(Prescription p) { return repo.save(p); }
    public List<Prescription> listBetween(LocalDate start, LocalDate end) { return repo.findByPrescriptionDateBetween(start, end); }
    public List<Object[]> dayWiseCount(LocalDate start, LocalDate end) { return repo.countDayWise(start, end); }
    public Prescription findById(Long id) { return repo.findById(id).orElse(null); }
    public void delete(Long id) { repo.deleteById(id); }
    public List<Prescription> findAll() { return repo.findAll(); }
}
