package com.diy.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpMethod;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Authorization {
    private HttpMethod method;
    private String path;
}
