package com.cmed.prescription.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Prescription {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Prescription date is required")
    private LocalDate prescriptionDate;

    @NotBlank(message = "Patient name is required")
    private String patientName;

    @NotNull(message = "Age is required")
    @Min(0) @Max(150)
    private Integer patientAge;

    @NotBlank(message = "Gender is required")
    private String patientGender;

    @Column(length = 2000)
    private String diagnosis;

    @Column(length = 2000)
    private String medicines;

    private LocalDate nextVisitDate;

    public Prescription() {}

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getPrescriptionDate() { return prescriptionDate; }
    public void setPrescriptionDate(LocalDate prescriptionDate) { this.prescriptionDate = prescriptionDate; }
    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }
    public Integer getPatientAge() { return patientAge; }
    public void setPatientAge(Integer patientAge) { this.patientAge = patientAge; }
    public String getPatientGender() { return patientGender; }
    public void setPatientGender(String patientGender) { this.patientGender = patientGender; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public String getMedicines() { return medicines; }
    public void setMedicines(String medicines) { this.medicines = medicines; }
    public LocalDate getNextVisitDate() { return nextVisitDate; }
    public void setNextVisitDate(LocalDate nextVisitDate) { this.nextVisitDate = nextVisitDate; }
}
