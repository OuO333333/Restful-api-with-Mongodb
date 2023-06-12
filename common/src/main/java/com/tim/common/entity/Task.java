package com.tim.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    /**
     * 任務ID
     */
    private String taskId;

    /**
     * 任務內容
     */
    private String context;

}
