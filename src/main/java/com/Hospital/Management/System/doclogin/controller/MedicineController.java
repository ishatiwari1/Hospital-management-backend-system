package com.Hospital.Management.System.doclogin.controller;

import com.Hospital.Management.System.doclogin.MedicineRepository;
import com.Hospital.Management.System.doclogin.entity.Medicine;
import com.Hospital.Management.System.entity.Patient;
import com.Hospital.Management.System.repository.PatientRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.AttributeNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v3")
public class MedicineController {
    MedicineRepository medicineRepository;

    public MedicineController(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    @PostMapping("/insert")
    public Medicine createMedicine(@RequestBody Medicine medicine) {
        return medicineRepository.save(medicine);
    }

    @GetMapping
    public List<Medicine> getAllMedicines() {
        return medicineRepository.findAll();
    }

    @GetMapping("/medicine/{id}")
    public ResponseEntity<Medicine> getMedicineById(@PathVariable Long id) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found with id" + id));
        return ResponseEntity.ok().body(medicine);
    }
    @PutMapping("/medicines/{id}")
    public ResponseEntity<List<Medicine>> updateMedicine(@PathVariable Long id, @RequestBody Medicine medicineDetails) throws AttributeNotFoundException {
        Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found with id" + id));
        medicine.setDrugName(medicineDetails.getDrugName());
        medicine.setStock(medicineDetails.getStock());
        medicineRepository.save(medicine);
        return ResponseEntity.ok(Collections.singletonList(medicine));

    }

    @DeleteMapping("/medicine/{id}")
    public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) throws AttributeNotFoundException {
     Medicine medicine = medicineRepository.findById(id).orElseThrow(() -> new AttributeNotFoundException("Medicine Not Found with id" + id));
     medicineRepository.delete(medicine);
     Map<String, Boolean> response = new HashMap<String, Boolean>();
     response.put("Deleted", Boolean.TRUE);
     return ResponseEntity.ok(response);
     }

}