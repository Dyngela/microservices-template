package com.diy.generated.model;

import java.net.URI;
import java.util.Objects;
import com.diy.generated.model.CategoryDto;
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
 * ProductDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T10:45:05.655330+02:00[Europe/Paris]")
public class ProductDto   {
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

  @JsonProperty("category")
  private CategoryDto category;

  public ProductDto productId(Long productId) {
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

  public ProductDto name(String name) {
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

  public ProductDto price(BigDecimal price) {
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

  public ProductDto description(String description) {
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

  public ProductDto weight(BigDecimal weight) {
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

  public ProductDto height(BigDecimal height) {
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

  public ProductDto photo(String photo) {
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

  public ProductDto availableInStore(Boolean availableInStore) {
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

  public ProductDto storeId(Long storeId) {
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

  public ProductDto category(CategoryDto category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
  */
  @ApiModelProperty(value = "")

  @Valid

  public CategoryDto getCategory() {
    return category;
  }

  public void setCategory(CategoryDto category) {
    this.category = category;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductDto product = (ProductDto) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.name, product.name) &&
        Objects.equals(this.price, product.price) &&
        Objects.equals(this.description, product.description) &&
        Objects.equals(this.weight, product.weight) &&
        Objects.equals(this.height, product.height) &&
        Objects.equals(this.photo, product.photo) &&
        Objects.equals(this.availableInStore, product.availableInStore) &&
        Objects.equals(this.storeId, product.storeId) &&
        Objects.equals(this.category, product.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, name, price, description, weight, height, photo, availableInStore, storeId, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductDto {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    weight: ").append(toIndentedString(weight)).append("\n");
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
    sb.append("    availableInStore: ").append(toIndentedString(availableInStore)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

