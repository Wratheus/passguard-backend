package com.example.passguard.util;

import com.example.passguard.models.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Resource {
    public static String fromResponse(Response response) {
        ObjectMapper om = new ObjectMapper();
        try {
            return om.writeValueAsString(response);
        } catch (Exception error) {
            return "Resource.fromResponse" + error;
        }
    }
}
