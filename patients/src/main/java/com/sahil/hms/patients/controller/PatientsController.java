package com.sahil.hms.patients.controller;


import com.sahil.hms.patients.constants.PatientsConstants;
import com.sahil.hms.patients.dto.PatientDto;
import com.sahil.hms.patients.dto.ResponseDto;
import com.sahil.hms.patients.service.IPatientsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@RequiredArgsConstructor
public class PatientsController {

    private final IPatientsService iPatientsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createPatient(@Valid @RequestBody PatientDto patientDto) {
        iPatientsService.create(patientDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(PatientsConstants.STATUS_201, PatientsConstants.MESSAGE_201));
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<PatientDto> fetchPatient(@PathVariable("id") Long id) {
        PatientDto patientDto = iPatientsService.getById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patientDto);
    }

    @GetMapping("/fetchByEmail/{email}")
    public ResponseEntity<PatientDto> fetchPatientByEmail(@PathVariable("email") String email) {
        PatientDto patientDto = iPatientsService.getByEmail(email);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(patientDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updatePatient(@RequestBody PatientDto patientDto) {
        iPatientsService.update(patientDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(PatientsConstants.STATUS_200, PatientsConstants.MESSAGE_200));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deletePatient(@PathVariable("id") Long id) {
        iPatientsService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(PatientsConstants.STATUS_200, PatientsConstants.MESSAGE_200));
    }

}
