package com.cmed.prescription.repository;

import com.cmed.prescription.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;

public interface PrescriptionRepository extends JpaRepository<Prescription, Long> {
    List<Prescription> findByPrescriptionDateBetween(LocalDate start, LocalDate end);

    @Query("select p.prescriptionDate, count(p) from Prescription p where p.prescriptionDate between ?1 and ?2 group by p.prescriptionDate order by p.prescriptionDate")
    List<Object[]> countDayWise(LocalDate start, LocalDate end);
}
