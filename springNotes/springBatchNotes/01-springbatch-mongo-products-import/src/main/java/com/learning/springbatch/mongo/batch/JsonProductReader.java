package com.learning.springbatch.mongo.batch;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learning.springbatch.mongo.dto.ProductDTO;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class JsonProductReader {
    
    public JsonItemReader<ProductDTO> createReader(Resource resource) {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonJsonObjectReader<ProductDTO> jsonObjectReader = 
            new JacksonJsonObjectReader<>(ProductDTO.class);
        jsonObjectReader.setMapper(objectMapper);
        
        JsonItemReader<ProductDTO> jsonItemReader = 
            new JsonItemReader<>();
        jsonItemReader.setResource(resource);
        jsonItemReader.setJsonObjectReader(jsonObjectReader);
        jsonItemReader.setName("productJsonItemReader");
        
        return jsonItemReader;
    }
}

