package com.sahil.hms.staffs.controller;


import com.sahil.hms.staffs.constants.UserConstants;
import com.sahil.hms.staffs.dto.ResponseDto;
import com.sahil.hms.staffs.dto.UserDto;
import com.sahil.hms.staffs.service.IStaffsService;
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
public class StaffsController {

    private final IStaffsService iStaffsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createStaff(@RequestBody UserDto userDto) {
        iStaffsService.create(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UserConstants.STATUS_201, UserConstants.MESSAGE_201));
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<UserDto> fetchStaff (@PathVariable("id") Long id, @RequestParam String userType) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(iStaffsService.getById(id, userType));
    }

}
