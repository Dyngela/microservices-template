package com.diy.security;

import lombok.*;
import org.springframework.http.HttpMethod;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Authorization {
    private HttpMethod method;
    private String path;
}
