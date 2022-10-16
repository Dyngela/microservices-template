package com.diy.mapper;

import com.diy.entity.CategoryEntity;
import com.diy.entity.ProductEntity;
import com.diy.generated.model.ProductDto;
import com.diy.generated.model.ProductWithoutCategoryDto;
import com.diy.model.CategoryModel;
import com.diy.model.ProductModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T16:10:49+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (OpenJDK Porters Group)"
)
@Component
public class ProductModelMapperImpl implements ProductModelMapper {

    @Override
    public ProductDto toProductDto(ProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( productModel.getProductId() );
        productDto.setName( productModel.getName() );
        productDto.setPrice( productModel.getPrice() );
        productDto.setDescription( productModel.getDescription() );
        productDto.setWeight( productModel.getWeight() );
        productDto.setHeight( productModel.getHeight() );
        productDto.setPhoto( productModel.getPhoto() );
        productDto.setAvailableInStore( productModel.getAvailableInStore() );
        productDto.setStoreId( productModel.getStoreId() );

        return productDto;
    }

    @Override
    public List<ProductDto> modelsToProductDtos(List<ProductModel> productModels) {
        if ( productModels == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( productModels.size() );
        for ( ProductModel productModel : productModels ) {
            list.add( toProductDto( productModel ) );
        }

        return list;
    }

    @Override
    public ProductWithoutCategoryDto toProductWOCategoryDto(ProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        ProductWithoutCategoryDto productWithoutCategoryDto = new ProductWithoutCategoryDto();

        productWithoutCategoryDto.setProductId( productModel.getProductId() );
        productWithoutCategoryDto.setName( productModel.getName() );
        productWithoutCategoryDto.setPrice( productModel.getPrice() );
        productWithoutCategoryDto.setDescription( productModel.getDescription() );
        productWithoutCategoryDto.setWeight( productModel.getWeight() );
        productWithoutCategoryDto.setHeight( productModel.getHeight() );
        productWithoutCategoryDto.setPhoto( productModel.getPhoto() );
        productWithoutCategoryDto.setAvailableInStore( productModel.getAvailableInStore() );
        productWithoutCategoryDto.setStoreId( productModel.getStoreId() );

        return productWithoutCategoryDto;
    }

    @Override
    public List<ProductWithoutCategoryDto> toProductWOCategoryDto(List<ProductModel> productModel) {
        if ( productModel == null ) {
            return null;
        }

        List<ProductWithoutCategoryDto> list = new ArrayList<ProductWithoutCategoryDto>( productModel.size() );
        for ( ProductModel productModel1 : productModel ) {
            list.add( toProductWOCategoryDto( productModel1 ) );
        }

        return list;
    }

    @Override
    public ProductModel dtoToModel(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        ProductModel productModel = new ProductModel();

        productModel.setProductId( productDto.getProductId() );
        productModel.setName( productDto.getName() );
        productModel.setPrice( productDto.getPrice() );
        productModel.setDescription( productDto.getDescription() );
        productModel.setWeight( productDto.getWeight() );
        productModel.setHeight( productDto.getHeight() );
        productModel.setPhoto( productDto.getPhoto() );
        productModel.setAvailableInStore( productDto.getAvailableInStore() );
        productModel.setStoreId( productDto.getStoreId() );

        return productModel;
    }

    @Override
    public List<ProductModel> dtosToModels(List<ProductDto> productDtos) {
        if ( productDtos == null ) {
            return null;
        }

        List<ProductModel> list = new ArrayList<ProductModel>( productDtos.size() );
        for ( ProductDto productDto : productDtos ) {
            list.add( dtoToModel( productDto ) );
        }

        return list;
    }

    @Override
    public ProductEntity modelToEntity(ProductModel productModel) {
        if ( productModel == null ) {
            return null;
        }

        ProductEntity productEntity = new ProductEntity();

        productEntity.setProductId( productModel.getProductId() );
        productEntity.setName( productModel.getName() );
        productEntity.setPrice( productModel.getPrice() );
        productEntity.setDescription( productModel.getDescription() );
        productEntity.setWeight( productModel.getWeight() );
        productEntity.setHeight( productModel.getHeight() );
        productEntity.setPhoto( productModel.getPhoto() );
        productEntity.setAvailableInStore( productModel.getAvailableInStore() );
        productEntity.setStoreId( productModel.getStoreId() );
        productEntity.setCreatedAt( productModel.getCreatedAt() );
        productEntity.setUpdatedAt( productModel.getUpdatedAt() );
        productEntity.setDeletedAt( productModel.getDeletedAt() );
        productEntity.setCategoryEntity( categoryModelToCategoryEntity( productModel.getCategoryEntity() ) );

        return productEntity;
    }

    @Override
    public List<ProductEntity> modelsToEntities(List<ProductModel> productModels) {
        if ( productModels == null ) {
            return null;
        }

        List<ProductEntity> list = new ArrayList<ProductEntity>( productModels.size() );
        for ( ProductModel productModel : productModels ) {
            list.add( modelToEntity( productModel ) );
        }

        return list;
    }

    @Override
    public ProductModel entityToModel(ProductEntity productEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        ProductModel target = cycleAvoidingMappingContext.getMappedInstance( productEntity, ProductModel.class );
        if ( target != null ) {
            return target;
        }

        if ( productEntity == null ) {
            return null;
        }

        ProductModel productModel = new ProductModel();

        cycleAvoidingMappingContext.storeMappedInstance( productEntity, productModel );

        productModel.setProductId( productEntity.getProductId() );
        productModel.setName( productEntity.getName() );
        productModel.setPrice( productEntity.getPrice() );
        productModel.setDescription( productEntity.getDescription() );
        productModel.setWeight( productEntity.getWeight() );
        productModel.setHeight( productEntity.getHeight() );
        productModel.setPhoto( productEntity.getPhoto() );
        productModel.setAvailableInStore( productEntity.getAvailableInStore() );
        productModel.setStoreId( productEntity.getStoreId() );
        productModel.setCategoryEntity( categoryEntityToCategoryModel( productEntity.getCategoryEntity(), cycleAvoidingMappingContext ) );
        productModel.setCreatedAt( productEntity.getCreatedAt() );
        productModel.setUpdatedAt( productEntity.getUpdatedAt() );
        productModel.setDeletedAt( productEntity.getDeletedAt() );

        return productModel;
    }

    @Override
    public List<ProductModel> entitiesToModels(List<ProductEntity> productEntities, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<ProductModel> target = cycleAvoidingMappingContext.getMappedInstance( productEntities, List.class );
        if ( target != null ) {
            return target;
        }

        if ( productEntities == null ) {
            return null;
        }

        List<ProductModel> list = new ArrayList<ProductModel>( productEntities.size() );
        cycleAvoidingMappingContext.storeMappedInstance( productEntities, list );

        for ( ProductEntity productEntity : productEntities ) {
            list.add( entityToModel( productEntity, cycleAvoidingMappingContext ) );
        }

        return list;
    }

    @Override
    public void updateStoreFromModel(ProductModel model, ProductEntity entity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        if ( model == null ) {
            return;
        }

        cycleAvoidingMappingContext.storeMappedInstance( model, entity );

        if ( model.getProductId() != null ) {
            entity.setProductId( model.getProductId() );
        }
        if ( model.getName() != null ) {
            entity.setName( model.getName() );
        }
        if ( model.getPrice() != null ) {
            entity.setPrice( model.getPrice() );
        }
        if ( model.getDescription() != null ) {
            entity.setDescription( model.getDescription() );
        }
        if ( model.getWeight() != null ) {
            entity.setWeight( model.getWeight() );
        }
        if ( model.getHeight() != null ) {
            entity.setHeight( model.getHeight() );
        }
        if ( model.getPhoto() != null ) {
            entity.setPhoto( model.getPhoto() );
        }
        if ( model.getAvailableInStore() != null ) {
            entity.setAvailableInStore( model.getAvailableInStore() );
        }
        if ( model.getStoreId() != null ) {
            entity.setStoreId( model.getStoreId() );
        }
        if ( model.getCreatedAt() != null ) {
            entity.setCreatedAt( model.getCreatedAt() );
        }
        if ( model.getUpdatedAt() != null ) {
            entity.setUpdatedAt( model.getUpdatedAt() );
        }
        if ( model.getDeletedAt() != null ) {
            entity.setDeletedAt( model.getDeletedAt() );
        }
        if ( model.getCategoryEntity() != null ) {
            if ( entity.getCategoryEntity() == null ) {
                entity.setCategoryEntity( new CategoryEntity() );
            }
            categoryModelToCategoryEntity1( model.getCategoryEntity(), cycleAvoidingMappingContext, entity.getCategoryEntity() );
        }
    }

    protected CategoryEntity categoryModelToCategoryEntity(CategoryModel categoryModel) {
        if ( categoryModel == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setCategoryId( categoryModel.getCategoryId() );
        categoryEntity.setName( categoryModel.getName() );
        categoryEntity.setStoreId( categoryModel.getStoreId() );
        categoryEntity.setCreatedAt( categoryModel.getCreatedAt() );
        categoryEntity.setUpdatedAt( categoryModel.getUpdatedAt() );
        categoryEntity.setDeletedAt( categoryModel.getDeletedAt() );
        categoryEntity.setProductEntities( modelsToEntities( categoryModel.getProductEntities() ) );

        return categoryEntity;
    }

    protected CategoryModel categoryEntityToCategoryModel(CategoryEntity categoryEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        CategoryModel target = cycleAvoidingMappingContext.getMappedInstance( categoryEntity, CategoryModel.class );
        if ( target != null ) {
            return target;
        }

        if ( categoryEntity == null ) {
            return null;
        }

        CategoryModel categoryModel = new CategoryModel();

        cycleAvoidingMappingContext.storeMappedInstance( categoryEntity, categoryModel );

        categoryModel.setCategoryId( categoryEntity.getCategoryId() );
        categoryModel.setName( categoryEntity.getName() );
        categoryModel.setStoreId( categoryEntity.getStoreId() );
        categoryModel.setProductEntities( entitiesToModels( categoryEntity.getProductEntities(), cycleAvoidingMappingContext ) );
        categoryModel.setCreatedAt( categoryEntity.getCreatedAt() );
        categoryModel.setUpdatedAt( categoryEntity.getUpdatedAt() );
        categoryModel.setDeletedAt( categoryEntity.getDeletedAt() );

        return categoryModel;
    }

    protected void categoryModelToCategoryEntity1(CategoryModel categoryModel, CycleAvoidingMappingContext cycleAvoidingMappingContext, CategoryEntity mappingTarget) {
        if ( categoryModel == null ) {
            return;
        }

        cycleAvoidingMappingContext.storeMappedInstance( categoryModel, mappingTarget );

        if ( categoryModel.getCategoryId() != null ) {
            mappingTarget.setCategoryId( categoryModel.getCategoryId() );
        }
        if ( categoryModel.getName() != null ) {
            mappingTarget.setName( categoryModel.getName() );
        }
        if ( categoryModel.getStoreId() != null ) {
            mappingTarget.setStoreId( categoryModel.getStoreId() );
        }
        if ( categoryModel.getCreatedAt() != null ) {
            mappingTarget.setCreatedAt( categoryModel.getCreatedAt() );
        }
        if ( categoryModel.getUpdatedAt() != null ) {
            mappingTarget.setUpdatedAt( categoryModel.getUpdatedAt() );
        }
        if ( categoryModel.getDeletedAt() != null ) {
            mappingTarget.setDeletedAt( categoryModel.getDeletedAt() );
        }
        if ( mappingTarget.getProductEntities() != null ) {
            List<ProductEntity> list = modelsToEntities( categoryModel.getProductEntities() );
            if ( list != null ) {
                mappingTarget.getProductEntities().clear();
                mappingTarget.getProductEntities().addAll( list );
            }
        }
        else {
            List<ProductEntity> list = modelsToEntities( categoryModel.getProductEntities() );
            if ( list != null ) {
                mappingTarget.setProductEntities( list );
            }
        }
    }
}
