package com.Hospital.Management.System.controller;

import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    private PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {

        this.patientRepository = patientRepository;
    }
@PostMapping("/insert")
    public Patient createPatient(@RequestBody Patient patient){

        return patientRepository.save(patient);

    }

    @GetMapping("/patients/{id}")
    public List<Patient> getAllPatients(){

        return patientRepository.findAll();
    }
    @GetMapping("/patients/(id)")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Patient Not Found with id" + id));
    return  ResponseEntity.ok().body(patient);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Map<String, Boolean>>deletePatientById(@PathVariable long id) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow (() -> new AttributeNotFoundException("Patient not found with id " + id));
        patientRepository.delete(patient);
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/patients/{id}")
    public ResponseEntity<Patient> updatePatientById(@PathVariable long id, @RequestBody Patient patientDetails) throws AttributeNotFoundException {
        Patient patient = patientRepository.findById(id).orElseThrow (() -> new AttributeNotFoundException("Patient not found with id " + id));
         patient.setAge(patientDetails.getAge());
         patient.setName(patientDetails.getName());
         patient.setBlood(patientDetails.getBlood());
        patient.setDose(patientDetails.getDose());
        patient.setFee(patientDetails.getFee());
        patient.setPrescription(patientDetails.getPrescription());
        patient.setUrgency(patientDetails.getUrgency());
        Patient savedPatient=patientRepository.save(patient);
        return ResponseEntity.ok(savedPatient);


    }
}
