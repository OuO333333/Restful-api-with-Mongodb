package com.tim.common.entity;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Description {
    @NotNull(message = "mainDescription cammot be null")
    private String mainDescription;
    private String contentDescription;
}
