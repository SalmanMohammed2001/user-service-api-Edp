package com.eadp.userserviceapi.util;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private String message;
    private int code;
    private Object data;
}
