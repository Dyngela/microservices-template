package com.diy.generated.model;

import java.net.URI;
import java.util.Objects;
import com.diy.generated.model.ProductWithoutCategoryDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;


import java.util.*;

/**
 * CategoryWithProductDto
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-10-16T16:10:48.551126+02:00[Europe/Paris]")
public class CategoryWithProductDto   {
  @JsonProperty("categoryId")
  private Long categoryId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("storeId")
  private Long storeId;

  @JsonProperty("products")
  @Valid
  private List<ProductWithoutCategoryDto> products = null;

  public CategoryWithProductDto categoryId(Long categoryId) {
    this.categoryId = categoryId;
    return this;
  }

  /**
   * Get categoryId
   * @return categoryId
  */
  @ApiModelProperty(value = "")


  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public CategoryWithProductDto name(String name) {
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

  public CategoryWithProductDto storeId(Long storeId) {
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

  public CategoryWithProductDto products(List<ProductWithoutCategoryDto> products) {
    this.products = products;
    return this;
  }

  public CategoryWithProductDto addProductsItem(ProductWithoutCategoryDto productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
  */
  @ApiModelProperty(value = "")

  @Valid

  public List<ProductWithoutCategoryDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductWithoutCategoryDto> products) {
    this.products = products;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CategoryWithProductDto categoryWithProduct = (CategoryWithProductDto) o;
    return Objects.equals(this.categoryId, categoryWithProduct.categoryId) &&
        Objects.equals(this.name, categoryWithProduct.name) &&
        Objects.equals(this.storeId, categoryWithProduct.storeId) &&
        Objects.equals(this.products, categoryWithProduct.products);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryId, name, storeId, products);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CategoryWithProductDto {\n");
    
    sb.append("    categoryId: ").append(toIndentedString(categoryId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
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

