package com.Sudongbu.board.api;


import com.Sudongbu.board.dto.RegisterReqDto;
import com.Sudongbu.board.dto.validation.ValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @PostMapping("/register")
    public ResponseEntity<?> register(@Validated(ValidationSequence.class) @RequestBody RegisterReqDto registerReqDto, BindingResult bindingResult) {

        System.out.println(registerReqDto);

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors) {
                System.out.println("필드명: " + fieldError.getField());
                System.out.println("에러 메세지: " + fieldError.getDefaultMessage());
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }

            return ResponseEntity.badRequest().body(errorMap);
        }

        return ResponseEntity.created(null).body(null);
    }
}
