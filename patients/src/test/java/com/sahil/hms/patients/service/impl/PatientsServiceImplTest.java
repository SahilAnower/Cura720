package com.sahil.hms.patients.service.impl;

import com.sahil.hms.patients.dto.AddressDto;
import com.sahil.hms.patients.dto.PatientDto;
import com.sahil.hms.patients.entity.Address;
import com.sahil.hms.patients.entity.Patient;
import com.sahil.hms.patients.mapper.GenericMapper;
import com.sahil.hms.patients.repository.PatientsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class PatientsServiceImplTest {

  private AutoCloseable mocks;

  @InjectMocks private PatientsServiceImpl patientsService;
  @Mock private PatientsRepository patientsRepository;
  @Mock private GenericMapper genericMapper;

  @BeforeEach
  void setUp() {
    mocks = MockitoAnnotations.openMocks(this);
  }

  @AfterEach
  void tearDown() throws Exception {
    if (mocks != null) {
      mocks.close();
    }
  }

  @Test
  public void create_success() {
    //given
    PatientDto patientDto = samplePatientDto();
    Patient patient = samplePatient();

    //when
    when(genericMapper.toPatient(patientDto)).thenReturn(patient);
    when(patientsRepository.save(patient)).thenReturn(patient);
    patientsService.create(patientDto);

    //then
    verify(genericMapper, times(1)).toPatient(patientDto);
    verify(patientsRepository, times(1)).save(patient);
  }

  private static AddressDto sampleAddressDto() {
    return new AddressDto(
      1L,
      "California",
      "Los Angeles",
      "123 Main St",
      "90001",
      "USA"
    );
  }

  private static PatientDto samplePatientDto() {
    return new PatientDto(
      1L,
      "John",
      "john@test.com",
      "1994-05-28",
      "1012345678",
      sampleAddressDto()
    );
  }

  private static Address sampleAddress() {
    AddressDto addressDto = sampleAddressDto();
    return new Address(
      addressDto.getId(),
      addressDto.getState(),
      addressDto.getCity(),
      addressDto.getStreet(),
      addressDto.getZipCode(),
      addressDto.getCountry()
    );
  }

  private static Patient samplePatient() {
    PatientDto patientDto = samplePatientDto();
    return new Patient(
      patientDto.getId(),
      patientDto.getName(),
      patientDto.getEmail(),
      patientDto.getDob(),
      patientDto.getPhone(),
      sampleAddress()
    );
  }

}