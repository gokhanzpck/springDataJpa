package com.example.dto;

import jakarta.persistence.MapKeyClass;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class DtoStudentIU {
    @NotEmpty(message = "Bu alan boş bırakılamaz.")
    @Min(value = 3)
    @Max(value = 10)
    private String firstName;

    @Size(min = 5,max = 10)
    private String lastName;

    private LocalDate birthOfDate;
}
