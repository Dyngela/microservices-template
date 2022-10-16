package com.diy.generated.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;


import java.util.*;

/**
 * ProductWithoutCategoryDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T10:45:05.655330+02:00[Europe/Paris]")
public class ProductWithoutCategoryDto   {
  @JsonProperty("productId")
  private Long productId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("description")
  private String description;

  @JsonProperty("weight")
  private BigDecimal weight;

  @JsonProperty("height")
  private BigDecimal height;

  @JsonProperty("photo")
  private String photo;

  @JsonProperty("availableInStore")
  private Boolean availableInStore;

  @JsonProperty("storeId")
  private Long storeId;

  public ProductWithoutCategoryDto productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  */
  @ApiModelProperty(value = "")


  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public ProductWithoutCategoryDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductWithoutCategoryDto price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Get price
   * @return price
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public ProductWithoutCategoryDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ProductWithoutCategoryDto weight(BigDecimal weight) {
    this.weight = weight;
    return this;
  }

  /**
   * Get weight
   * @return weight
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getWeight() {
    return weight;
  }

  public void setWeight(BigDecimal weight) {
    this.weight = weight;
  }

  public ProductWithoutCategoryDto height(BigDecimal height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
  */
  @ApiModelProperty(value = "")

  @Valid

  public BigDecimal getHeight() {
    return height;
  }

  public void setHeight(BigDecimal height) {
    this.height = height;
  }

  public ProductWithoutCategoryDto photo(String photo) {
    this.photo = photo;
    return this;
  }

  /**
   * Get photo
   * @return photo
  */
  @ApiModelProperty(value = "")


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }

  public ProductWithoutCategoryDto availableInStore(Boolean availableInStore) {
    this.availableInStore = availableInStore;
    return this;
  }

  /**
   * Get availableInStore
   * @return availableInStore
  */
  @ApiModelProperty(value = "")


  public Boolean getAvailableInStore() {
    return availableInStore;
  }

  public void setAvailableInStore(Boolean availableInStore) {
    this.availableInStore = availableInStore;
  }

  public ProductWithoutCategoryDto storeId(Long storeId) {
    this.storeId = storeId;
    return this;
  }

  /**
   * Get storeId
   * @return storeId
  */
  @ApiModelProperty(value = "")


  public Long getStoreId() {
    return storeId;
  }

  public void setStoreId(Long storeId) {
    this.storeId = storeId;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductWithoutCategoryDto productWithoutCategory = (ProductWithoutCategoryDto) o;
    return Objects.equals(this.productId, productWithoutCategory.productId) &&
        Objects.equals(this.name, productWithoutCategory.name) &&
        Objects.equals(this.price, productWithoutCategory.price) &&
        Objects.equals(this.description, productWithoutCategory.description) &&
        Objects.equals(this.weight, productWithoutCategory.weight) &&
        Objects.equals(this.height, productWithoutCategory.height) &&
        Objects.equals(this.photo, productWithoutCategory.photo) &&
        Objects.equals(this.availableInStore, productWithoutCategory.availableInStore) &&
        Objects.equals(this.storeId, productWithoutCategory.storeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, name, price, description, weight, height, photo, availableInStore, storeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductWithoutCategoryDto {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    availableInStore: ").append(toIndentedString(availableInStore)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
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

