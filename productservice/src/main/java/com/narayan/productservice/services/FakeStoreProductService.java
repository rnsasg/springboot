package com.narayan.productservice.services;

import com.narayan.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductDto;
import com.narayan.productservice.dtos.GenericProductDto;
import com.narayan.productservice.exceptions.NotFoundException;
import com.narayan.productservice.thirdpartyclients.productservice.fakestore.FakeStoreProductServiceClient;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Service("fakeStoreProductService")
public class FakeStoreProductService implements  ProductService {

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    @Autowired
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient= fakeStoreProductServiceClient;
    }

    @Override
    public GenericProductDto getProductById(Long id) {
        return convertFakeProductIntoGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> answer = new ArrayList<>();
        for ( FakeStoreProductDto fakeStoreProductDto : fakeStoreProductServiceClient.getAllProducts() ){
            answer.add(convertFakeProductIntoGenericProduct(fakeStoreProductDto));
        }
        return answer;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = convertGenericProductIntoFakeStoreProduct(genericProductDto);
        return convertFakeProductIntoGenericProduct(fakeStoreProductServiceClient.createProduct(fakeStoreProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        FakeStoreProductDto fakeStoreProductDto = convertGenericProductIntoFakeStoreProduct(genericProductDto);
        return convertFakeProductIntoGenericProduct(fakeStoreProductDto);
    }

    @Override
    public GenericProductDto deleteProduct(Long id) throws NotFoundException {
        FakeStoreProductDto fakeStoreProductDto = fakeStoreProductServiceClient.deleteProduct(id);
        return convertFakeProductIntoGenericProduct(fakeStoreProductDto);
    }

    private GenericProductDto convertFakeProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();

        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());

        return genericProductDto;
    }

    private FakeStoreProductDto convertGenericProductIntoFakeStoreProduct(GenericProductDto genericProductDto){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setId(genericProductDto.getId());
        fakeStoreProductDto.setCategory(genericProductDto.getCategory());
        fakeStoreProductDto.setTitle(genericProductDto.getTitle());
        fakeStoreProductDto.setPrice(genericProductDto.getPrice());
        fakeStoreProductDto.setImage(genericProductDto.getImage());
        fakeStoreProductDto.setDescription(genericProductDto.getDescription());

        return fakeStoreProductDto;
    }

//    @Override
//    public GenericProductDto getProductById(Long id){
//
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
//        fakeStoreProductDto = response.getBody();
//
////        GenericProductDto product = new GenericProductDto();
////        product.setImage(fakeStoreProductDto.getImage());
////        product.setCategory(fakeStoreProductDto.getCategory());
////        product.setTitle(fakeStoreProductDto.getTitle());
////        product.setPrice(fakeStoreProductDto.getPrice());
////        product.setDescription(fakeStoreProductDto.getDescription());
//        return convertFakeProductIntoGenericProduct(fakeStoreProductDto);
//
////      restTemplate.postForEntity();
////      response.getStatusCode();
////      return "Here is the product id: " + id;
////      return null;
//    }
//
//    public GenericProductDto createProduct(GenericProductDto productDto){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(ProductRequestBaseUrl,productDto, GenericProductDto.class);
//        return response.getBody();
//    }
//
//    @Override
//    public List<GenericProductDto> getAllProducts() {
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(ProductRequestBaseUrl,FakeStoreProductDto[].class);
//
//        List<GenericProductDto> answer = new ArrayList<>();
//
////      for ( FakeStoreProductDto fakeStoreProductDto : Arrays.stream(response.getBody()).toList() ){
//        for ( FakeStoreProductDto fakeStoreProductDto : response.getBody() ){
//            answer.add(convertFakeProductIntoGenericProduct(fakeStoreProductDto));
////            GenericProductDto product = new GenericProductDto();
////            product.setImage(fakeStoreProductDto.getImage());
////            product.setDescription(fakeStoreProductDto.getDescription());
////            product.setTitle(fakeStoreProductDto.getTitle());
////            product.setPrice(fakeStoreProductDto.getPrice());
////            product.setCategory(fakeStoreProductDto.getCategory());
////            answer.add(product);
//        }
//        return answer;
//    }
//
//    @Override
//    public GenericProductDto deleteProduct(Long id) throws NotFoundException{
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseEntity = restTemplate.execute(specificProductUrl, HttpMethod.DELETE,requestCallback,responseExtractor,id);
//
//        fakeStoreProductDto = responseEntity.getBody();
//
//        if ( fakeStoreProductDto == null ){
//            throw new NotFoundException("Product with id: "+ id + " doesn't exist.");
//        }
//        return convertFakeProductIntoGenericProduct(fakeStoreProductDto);
//    }
//
//    private GenericProductDto convertFakeProductIntoGenericProduct(FakeStoreProductDto fakeStoreProductDto){
//        GenericProductDto genericProductDto = new GenericProductDto();
//
//        genericProductDto.setId(fakeStoreProductDto.getId());
//        genericProductDto.setImage(fakeStoreProductDto.getImage());
//        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
//        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
//        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
//        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
//
//        return genericProductDto;
//    }
}
