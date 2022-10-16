package com.diy.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;


import java.util.*;

/**
 * AddressDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T10:45:07.131120+02:00[Europe/Paris]")
public class AddressDto   {
  @JsonProperty("addressId")
  private Long addressId;

  @JsonProperty("city")
  private String city;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("complement")
  private String complement;

  @JsonProperty("streetNumber")
  private String streetNumber;

  @JsonProperty("streetName")
  private String streetName;

  public AddressDto addressId(Long addressId) {
    this.addressId = addressId;
    return this;
  }

  /**
   * Get addressId
   * @return addressId
  */
  @ApiModelProperty(value = "")


  public Long getAddressId() {
    return addressId;
  }

  public void setAddressId(Long addressId) {
    this.addressId = addressId;
  }

  public AddressDto city(String city) {
    this.city = city;
    return this;
  }

  /**
   * Get city
   * @return city
  */
  @ApiModelProperty(value = "")


  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public AddressDto postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  @ApiModelProperty(value = "")


  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public AddressDto complement(String complement) {
    this.complement = complement;
    return this;
  }

  /**
   * Get complement
   * @return complement
  */
  @ApiModelProperty(value = "")


  public String getComplement() {
    return complement;
  }

  public void setComplement(String complement) {
    this.complement = complement;
  }

  public AddressDto streetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
    return this;
  }

  /**
   * Get streetNumber
   * @return streetNumber
  */
  @ApiModelProperty(value = "")


  public String getStreetNumber() {
    return streetNumber;
  }

  public void setStreetNumber(String streetNumber) {
    this.streetNumber = streetNumber;
  }

  public AddressDto streetName(String streetName) {
    this.streetName = streetName;
    return this;
  }

  /**
   * Get streetName
   * @return streetName
  */
  @ApiModelProperty(value = "")


  public String getStreetName() {
    return streetName;
  }

  public void setStreetName(String streetName) {
    this.streetName = streetName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressDto address = (AddressDto) o;
    return Objects.equals(this.addressId, address.addressId) &&
        Objects.equals(this.city, address.city) &&
        Objects.equals(this.postalCode, address.postalCode) &&
        Objects.equals(this.complement, address.complement) &&
        Objects.equals(this.streetNumber, address.streetNumber) &&
        Objects.equals(this.streetName, address.streetName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressId, city, postalCode, complement, streetNumber, streetName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressDto {\n");
    
    sb.append("    addressId: ").append(toIndentedString(addressId)).append("\n");
    sb.append("    city: ").append(toIndentedString(city)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    complement: ").append(toIndentedString(complement)).append("\n");
    sb.append("    streetNumber: ").append(toIndentedString(streetNumber)).append("\n");
    sb.append("    streetName: ").append(toIndentedString(streetName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

