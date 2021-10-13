package com.brieflee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BSampleRequest {
    private int pageNumber;
    private int pageSize;
}
