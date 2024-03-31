package com.example.passguard.requests.password;
import com.example.passguard.models.Response;
import com.example.passguard.requests.password.get.GetProductRequest;
import com.example.passguard.util.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    final private ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/get")
    public String getProduct(@RequestBody GetProductRequest request) {
        final Response response = service.getResponse(request);
        return Resource.fromResponse(response);
    }
}
