package com.tim.common.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    // if Description is not null, mainDescription cannot be null
    @NotNull(message = "mainDescription cannot be null")
    private String mainDescription;
    private String contentDescription;
}
