package com.narayan.productservice.Controllers;

import com.narayan.productservice.dtos.ExceptionDto;
import com.narayan.productservice.dtos.GenericProductDto;
import com.narayan.productservice.exceptions.NotFoundException;
import com.narayan.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products/")
public class ProductControllers{

//  @Autowired
//  Field injection
    private ProductService productService;

//  Constructor injection
//  @Autowired
//  In latest version of spring , you don't need to explicitly set the autowired annotations
//  Spring automatically finds such constructor and injects all such dependencies
//    public ProductControllers(@Qualifier(@Value("$productservice.type")) ProductService productService){
    public ProductControllers(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

//    Setter injection
//    @Autowired
//    public void setProductService(ProductService productService){
//        this.productService = productService;
//    }

//  GET /products {}
    @GetMapping
    public List<GenericProductDto> getAllProducts() {
//        System.out.println("In getAllProducts()");
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public GenericProductDto getProductById(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable Long id) throws NotFoundException{
        return new ResponseEntity<>(
                productService.deleteProduct(id),
                HttpStatus.OK
        );
    }

    @PutMapping("/{id}")
    GenericProductDto updateProductById(@PathVariable Long id,GenericProductDto genericProductDto){
        return productService.updateProductById(id,genericProductDto);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        // return "Hello";
        // return "Created new product with id :" + UUID.randomUUID();
        // return "Created new product with id :" + genericProductDto.getTitle();
        return productService.createProduct(genericProductDto);
    }

//    @ExceptionHandler(NotFoundException.class)
//    private ResponseEntity<ExceptionDto> handleNotFoundException(){
//        return new ResponseEntity(
//                new ExceptionDto(HttpStatus.NOT_FOUND, handleNotFoundException().getBody().getMessage()),
//                HttpStatus.NOT_FOUND
//        );
//    }
}
