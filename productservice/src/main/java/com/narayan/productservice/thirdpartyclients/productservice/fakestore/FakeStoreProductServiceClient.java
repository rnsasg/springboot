package com.narayan.productservice.thirdpartyclients.productservice.fakestore;

import com.narayan.productservice.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class FakeStoreProductServiceClient{

    private RestTemplateBuilder restTemplateBuilder;
    private final String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private final String ProductRequestBaseUrl = "https://fakestoreapi.com/products/";
    private FakeStoreProductDto fakeStoreProductDto;

    @Autowired
    public FakeStoreProductServiceClient( RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreProductDto getProductById(Long id){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        return response.getBody();

    }

    public FakeStoreProductDto createProduct(FakeStoreProductDto productDto){
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(ProductRequestBaseUrl,productDto, FakeStoreProductDto.class);
        return response.getBody();
    }

    public FakeStoreProductDto updateProductById(Long id, FakeStoreProductDto fakeStoreProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> response = restTemplate.execute(specificProductUrl,HttpMethod.PUT, requestCallback,responseExtractor,id);
        fakeStoreProductDto = response.getBody();

        return fakeStoreProductDto;
    }

    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(ProductRequestBaseUrl,FakeStoreProductDto[].class);

        List<FakeStoreProductDto> answer = new ArrayList<>();

        for ( FakeStoreProductDto fakeStoreProductDto : response.getBody() ){
            answer.add(fakeStoreProductDto);
        }
        return answer;
    }

    public FakeStoreProductDto deleteProduct(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE,requestCallback,responseExtractor,id);

        fakeStoreProductDto = responseEntity.getBody();

        if ( fakeStoreProductDto == null ){
            throw new NotFoundException("Product with id: "+ id + " doesn't exist.");
        }
        return fakeStoreProductDto;
    }

}
