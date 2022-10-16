/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.3.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.diy.generated.api;

import com.diy.generated.model.AddressDto;
import com.diy.generated.model.StoreDto;
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
<<<<<<< HEAD
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T11:11:25.234768300+02:00[Europe/Paris]")
=======
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T10:45:07.131120+02:00[Europe/Paris]")
>>>>>>> yul
@Validated
@Api(value = "Store", description = "the Store API")
public interface StoreApi {

    /**
     * DELETE /address/{addressid} : Delete a store
     * Delete an address by ID
     *
     * @param addressid Address ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Delete a store", nickname = "deleteAddressById", notes = "Delete an address by ID", response = String.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = String.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/address/{addressid}",
        produces = { "application/json" }
    )
    ResponseEntity<String> deleteAddressById(@ApiParam(value = "Address ID", required = true) @PathVariable("addressid") Long addressid

);


    /**
     * DELETE /store/{storeId} : Delete a store
     * Delete a store by ID with all its dependencies in other microservices
     *
     * @param storeId Store ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Delete a store", nickname = "deleteStoreById", notes = "Delete a store by ID with all its dependencies in other microservices", response = String.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = String.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/store/{storeId}",
        produces = { "application/json" }
    )
    ResponseEntity<String> deleteStoreById(@ApiParam(value = "Store ID", required = true) @PathVariable("storeId") Long storeId

);


    /**
     * GET /address/{addressid} : Find a specific address with its ID
     * Get an address by id
     *
     * @param addressid Address ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find a specific address with its ID", nickname = "findAddressById", notes = "Get an address by id", response = AddressDto.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = AddressDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/address/{addressid}",
        produces = { "application/json" }
    )
    ResponseEntity<AddressDto> findAddressById(@ApiParam(value = "Address ID", required = true) @PathVariable("addressid") Long addressid

);


    /**
     * GET /address/{storeid} : Find all address related to a store
     * Get all stores
     *
     * @param storeid The store id we want those addresses to be attached to (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find all address related to a store", nickname = "findAddressesByStoreId", notes = "Get all stores", response = AddressDto.class, responseContainer = "List", tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = AddressDto.class, responseContainer = "List"),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/address/{storeid}",
        produces = { "application/json" }
    )
    ResponseEntity<List<AddressDto>> findAddressesByStoreId(@ApiParam(value = "The store id we want those addresses to be attached to", required = true) @PathVariable("storeid") Long storeid

);


    /**
     * GET /store/{storeId} : Find a specific store with its ID
     * Get a store by id
     *
     * @param storeId Store ID (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find a specific store with its ID", nickname = "findStoreById", notes = "Get a store by id", response = StoreDto.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = StoreDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/{storeId}",
        produces = { "application/json" }
    )
    ResponseEntity<StoreDto> findStoreById(@ApiParam(value = "Store ID", required = true) @PathVariable("storeId") Long storeId

);


    /**
     * GET /store/{storename} : Find a specific store with its ID
     * Get a store by name, namely for ms communication
     *
     * @param storename Store&#39; name (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find a specific store with its ID", nickname = "findStoreByStoreName", notes = "Get a store by name, namely for ms communication", response = StoreDto.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = StoreDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/store/{storename}",
        produces = { "application/json" }
    )
    ResponseEntity<StoreDto> findStoreByStoreName(@ApiParam(value = "Store' name", required = true) @PathVariable("storename") String storename

);


    /**
     * GET /stores/{size}/{page}/{sortby}/{ascending} : Find all stores
     * Get all stores
     *
     * @param size The size of the array wanted, usually no more than 50 (required)
     * @param page The page number to know where to put sql cursor on. Pages start at index 0 (required)
     * @param sortby The name of the field to sort the result by (required)
     * @param ascending Noting if the sorting is ascending or not (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Find all stores", nickname = "findStores", notes = "Get all stores", response = StoreDto.class, responseContainer = "List", tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = StoreDto.class, responseContainer = "List"),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/stores/{size}/{page}/{sortby}/{ascending}",
        produces = { "application/json" }
    )
    ResponseEntity<List<StoreDto>> findStores(@ApiParam(value = "The size of the array wanted, usually no more than 50", required = true) @PathVariable("size") Integer size

,@ApiParam(value = "The page number to know where to put sql cursor on. Pages start at index 0", required = true) @PathVariable("page") Integer page

,@ApiParam(value = "The name of the field to sort the result by", required = true) @PathVariable("sortby") String sortby

,@ApiParam(value = "Noting if the sorting is ascending or not", required = true) @PathVariable("ascending") Boolean ascending

);


    /**
     * POST /address/{storeid} : Create or update an address
     * Get an address and create it or update it.
     *
     * @param storeid store ID (required)
     * @param addressDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Create or update an address", nickname = "saveAddress", notes = "Get an address and create it or update it.", response = AddressDto.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = AddressDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/address/{storeid}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<AddressDto> saveAddress(@ApiParam(value = "store ID", required = true) @PathVariable("storeid") Long storeid

,

@ApiParam(value = "", required = true )   @Valid @RequestBody AddressDto addressDto);


    /**
     * POST /store : Create or update a store
     * Get a store object and potentially an address object nested, from the body
     *
     * @param storeDto  (required)
     * @return Successful operation (status code 200)
     *         or Invalid request (status code 404)
     */

    @ApiOperation(value = "Create or update a store", nickname = "saveStore", notes = "Get a store object and potentially an address object nested, from the body", response = StoreDto.class, tags={ "store", })
    @ApiResponses(value = { 

        @ApiResponse(code = 200, message = "Successful operation", response = StoreDto.class),

        @ApiResponse(code = 404, message = "Invalid request") })
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/store",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<StoreDto> saveStore(

@ApiParam(value = "", required = true )   @Valid @RequestBody StoreDto storeDto);

}