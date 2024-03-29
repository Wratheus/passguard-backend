package com.example.passguard.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseMapper {
    public static String map(BaseResponse response) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(response);
        } catch (Exception error) {
            return "{mapResponse : error}";
        }
    }
}
