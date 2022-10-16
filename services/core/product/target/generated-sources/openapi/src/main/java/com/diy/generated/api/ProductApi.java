/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diy.generated.api;

import com.diy.generated.model.CategoryWithProductDto;
import com.diy.generated.model.CategoryWithoutProductDto;
import com.diy.generated.model.PagerDto;
import com.diy.generated.model.ProductDto;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T14:03:30.242737300+02:00[Europe/Paris]")
@Validated
@Api(value = "Product", description = "the Product API")
public interface ProductApi {

    /**
     * DELETE /product/{productid} : Delete a product
     * Delete a product by ID
     *
     * @param productid Product ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Delete a product", nickname = "deleteProductById", notes = "Delete a product by ID", response = String.class, tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = String.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/product/{productid}",
        produces = { "application/json" }
    )
    ResponseEntity<String> deleteProductById(@ApiParam(value = "Product ID", required = true) @PathVariable("productid") Long productid

);


    /**
     * GET /product/{productid} : Find a specific product with its ID
     * Get a product by id
     *
     * @param productid Product ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find a specific product with its ID", nickname = "findProductById", notes = "Get a product by id", response = ProductDto.class, tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = ProductDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/product/{productid}",
        produces = { "application/json" }
    )
    ResponseEntity<ProductDto> findProductById(@ApiParam(value = "Product ID", required = true) @PathVariable("productid") Long productid

);


    /**
     * POST /categories : Find all categories according to its store id
     * Get all categories related to a store
     *
     * @param pagerDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find all categories according to its store id", nickname = "getAllCategoryByStoreId", notes = "Get all categories related to a store", response = CategoryWithoutProductDto.class, tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = CategoryWithoutProductDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/categories",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CategoryWithoutProductDto> getAllCategoryByStoreId(

@ApiParam(value = "", required = true )   @Valid @RequestBody PagerDto pagerDto);


    /**
     * POST /products : Find all product according to its store id
     * Get all product related to a store
     *
     * @param pagerDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find all product according to its store id", nickname = "getAllProductByStoreId", notes = "Get all product related to a store", response = ProductDto.class, responseContainer = "List", tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = ProductDto.class, responseContainer = "List"),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/products",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<List<ProductDto>> getAllProductByStoreId(

@ApiParam(value = "", required = true )   @Valid @RequestBody PagerDto pagerDto);


    /**
     * GET /category/{categoryid} : find a category by ID and all its product associated
     * Get a single category and all its product associated. According to a specific store id
     *
     * @param categoryid Category ID (required)
     * @param pagerDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "find a category by ID and all its product associated", nickname = "getCategoryAndItsProductByStoreId", notes = "Get a single category and all its product associated. According to a specific store id", response = CategoryWithProductDto.class, tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = CategoryWithProductDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/category/{categoryid}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CategoryWithProductDto> getCategoryAndItsProductByStoreId(@ApiParam(value = "Category ID", required = true) @PathVariable("categoryid") Long categoryid

,

@ApiParam(value = "", required = true )   @Valid @RequestBody PagerDto pagerDto);


    /**
     * POST /product : Create or update a product
     * Get a product object and potentially a category object nested, from the body
     *
     * @param productDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Create or update a product", nickname = "saveProduct", notes = "Get a product object and potentially a category object nested, from the body", response = ProductDto.class, tags={ "product", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = ProductDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/product",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<ProductDto> saveProduct(

@ApiParam(value = "", required = true )   @Valid @RequestBody ProductDto productDto);

}
