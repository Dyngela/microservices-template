package com.diy.mapper;

import com.diy.entity.AddressEntity;
import com.diy.entity.StoreEntity;
import com.diy.generated.model.AddressDto;
import com.diy.model.AddressModel;
import com.diy.model.StoreModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2022-10-16T11:11:27+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
=======
    date = "2022-10-16T10:45:07+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4.1 (OpenJDK Porters Group)"
>>>>>>> yul
)
@Component
public class AddressModelMapperImpl implements AddressModelMapper {

    @Override
    public AddressDto modelToDto(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();

        addressDto.setAddressId( addressModel.getAddressId() );
        addressDto.setCity( addressModel.getCity() );
        addressDto.setPostalCode( addressModel.getPostalCode() );
        addressDto.setComplement( addressModel.getComplement() );
        addressDto.setStreetNumber( addressModel.getStreetNumber() );
        addressDto.setStreetName( addressModel.getStreetName() );

        return addressDto;
    }

    @Override
    public List<AddressDto> modelsToDtos(List<AddressModel> addressModels) {
        if ( addressModels == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addressModels.size() );
        for ( AddressModel addressModel : addressModels ) {
            list.add( modelToDto( addressModel ) );
        }

        return list;
    }

    @Override
    public AddressModel dtoToModel(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        addressModel.setAddressId( addressDto.getAddressId() );
        addressModel.setCity( addressDto.getCity() );
        addressModel.setPostalCode( addressDto.getPostalCode() );
        addressModel.setComplement( addressDto.getComplement() );
        addressModel.setStreetNumber( addressDto.getStreetNumber() );
        addressModel.setStreetName( addressDto.getStreetName() );

        return addressModel;
    }

    @Override
    public List<AddressModel> dtosToModels(List<AddressDto> addressDtos) {
        if ( addressDtos == null ) {
            return null;
        }

        List<AddressModel> list = new ArrayList<AddressModel>( addressDtos.size() );
        for ( AddressDto addressDto : addressDtos ) {
            list.add( dtoToModel( addressDto ) );
        }

        return list;
    }

    @Override
    public AddressEntity modelToEntity(AddressModel storeModel) {
        if ( storeModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAddressId( storeModel.getAddressId() );
        addressEntity.setCity( storeModel.getCity() );
        addressEntity.setPostalCode( storeModel.getPostalCode() );
        addressEntity.setComplement( storeModel.getComplement() );
        addressEntity.setStreetNumber( storeModel.getStreetNumber() );
        addressEntity.setStreetName( storeModel.getStreetName() );
        addressEntity.setCreatedAt( storeModel.getCreatedAt() );
        addressEntity.setUpdatedAt( storeModel.getUpdatedAt() );
        addressEntity.setDeletedAt( storeModel.getDeletedAt() );
        addressEntity.setStore( storeModelToStoreEntity( storeModel.getStore() ) );

        return addressEntity;
    }

    @Override
    public List<AddressEntity> modelsToEntities(List<AddressEntity> storeEntities) {
        if ( storeEntities == null ) {
            return null;
        }

        List<AddressEntity> list = new ArrayList<AddressEntity>( storeEntities.size() );
        for ( AddressEntity addressEntity : storeEntities ) {
            list.add( addressEntity );
        }

        return list;
    }

    @Override
    public AddressModel entityToModel(AddressEntity storeEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        AddressModel target = cycleAvoidingMappingContext.getMappedInstance( storeEntity, AddressModel.class );
        if ( target != null ) {
            return target;
        }

        if ( storeEntity == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        cycleAvoidingMappingContext.storeMappedInstance( storeEntity, addressModel );

        addressModel.setAddressId( storeEntity.getAddressId() );
        addressModel.setCity( storeEntity.getCity() );
        addressModel.setPostalCode( storeEntity.getPostalCode() );
        addressModel.setComplement( storeEntity.getComplement() );
        addressModel.setStreetNumber( storeEntity.getStreetNumber() );
        addressModel.setStreetName( storeEntity.getStreetName() );
        addressModel.setCreatedAt( storeEntity.getCreatedAt() );
        addressModel.setUpdatedAt( storeEntity.getUpdatedAt() );
        addressModel.setDeletedAt( storeEntity.getDeletedAt() );
        addressModel.setStore( storeEntityToStoreModel( storeEntity.getStore(), cycleAvoidingMappingContext ) );

        return addressModel;
    }

    @Override
    public List<AddressModel> entitiesToModels(List<AddressEntity> storeEntities, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<AddressModel> target = cycleAvoidingMappingContext.getMappedInstance( storeEntities, List.class );
        if ( target != null ) {
            return target;
        }

        if ( storeEntities == null ) {
            return null;
        }

        List<AddressModel> list = new ArrayList<AddressModel>( storeEntities.size() );
        cycleAvoidingMappingContext.storeMappedInstance( storeEntities, list );

        for ( AddressEntity addressEntity : storeEntities ) {
            list.add( entityToModel( addressEntity, cycleAvoidingMappingContext ) );
        }

        return list;
    }

    @Override
    public void updateStoreFromModel(AddressModel model, AddressEntity entity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        if ( model == null ) {
            return;
        }

        cycleAvoidingMappingContext.storeMappedInstance( model, entity );

        if ( model.getAddressId() != null ) {
            entity.setAddressId( model.getAddressId() );
        }
        if ( model.getCity() != null ) {
            entity.setCity( model.getCity() );
        }
        if ( model.getPostalCode() != null ) {
            entity.setPostalCode( model.getPostalCode() );
        }
        if ( model.getComplement() != null ) {
            entity.setComplement( model.getComplement() );
        }
        if ( model.getStreetNumber() != null ) {
            entity.setStreetNumber( model.getStreetNumber() );
        }
        if ( model.getStreetName() != null ) {
            entity.setStreetName( model.getStreetName() );
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
        if ( model.getStore() != null ) {
            if ( entity.getStore() == null ) {
                entity.setStore( new StoreEntity() );
            }
            storeModelToStoreEntity1( model.getStore(), cycleAvoidingMappingContext, entity.getStore() );
        }
    }

    protected List<AddressEntity> addressModelListToAddressEntityList(List<AddressModel> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEntity> list1 = new ArrayList<AddressEntity>( list.size() );
        for ( AddressModel addressModel : list ) {
            list1.add( modelToEntity( addressModel ) );
        }

        return list1;
    }

    protected StoreEntity storeModelToStoreEntity(StoreModel storeModel) {
        if ( storeModel == null ) {
            return null;
        }

        StoreEntity storeEntity = new StoreEntity();

        storeEntity.setStoreId( storeModel.getStoreId() );
        storeEntity.setSiret( storeModel.getSiret() );
        storeEntity.setStoreName( storeModel.getStoreName() );
        storeEntity.setSector( storeModel.getSector() );
        storeEntity.setFirstname( storeModel.getFirstname() );
        storeEntity.setLastname( storeModel.getLastname() );
        storeEntity.setEmail( storeModel.getEmail() );
        storeEntity.setPhoneNumber( storeModel.getPhoneNumber() );
        storeEntity.setCreatedAt( storeModel.getCreatedAt() );
        storeEntity.setUpdatedAt( storeModel.getUpdatedAt() );
        storeEntity.setDeletedAt( storeModel.getDeletedAt() );
        storeEntity.setSubscriptionId( storeModel.getSubscriptionId() );
        storeEntity.setAddresses( addressModelListToAddressEntityList( storeModel.getAddresses() ) );

        return storeEntity;
    }

    protected StoreModel storeEntityToStoreModel(StoreEntity storeEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        StoreModel target = cycleAvoidingMappingContext.getMappedInstance( storeEntity, StoreModel.class );
        if ( target != null ) {
            return target;
        }

        if ( storeEntity == null ) {
            return null;
        }

        StoreModel storeModel = new StoreModel();

        cycleAvoidingMappingContext.storeMappedInstance( storeEntity, storeModel );

        storeModel.setStoreId( storeEntity.getStoreId() );
        storeModel.setSiret( storeEntity.getSiret() );
        storeModel.setSector( storeEntity.getSector() );
        storeModel.setStoreName( storeEntity.getStoreName() );
        storeModel.setFirstname( storeEntity.getFirstname() );
        storeModel.setLastname( storeEntity.getLastname() );
        storeModel.setEmail( storeEntity.getEmail() );
        storeModel.setPhoneNumber( storeEntity.getPhoneNumber() );
        storeModel.setCreatedAt( storeEntity.getCreatedAt() );
        storeModel.setUpdatedAt( storeEntity.getUpdatedAt() );
        storeModel.setDeletedAt( storeEntity.getDeletedAt() );
        storeModel.setSubscriptionId( storeEntity.getSubscriptionId() );
        storeModel.setAddresses( entitiesToModels( storeEntity.getAddresses(), cycleAvoidingMappingContext ) );

        return storeModel;
    }

    protected List<AddressEntity> addressModelListToAddressEntityList1(List<AddressModel> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<AddressEntity> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<AddressEntity> list1 = new ArrayList<AddressEntity>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( AddressModel addressModel : list ) {
            list1.add( modelToEntity( addressModel ) );
        }

        return list1;
    }

    protected void storeModelToStoreEntity1(StoreModel storeModel, CycleAvoidingMappingContext cycleAvoidingMappingContext, StoreEntity mappingTarget) {
        if ( storeModel == null ) {
            return;
        }

        cycleAvoidingMappingContext.storeMappedInstance( storeModel, mappingTarget );

        if ( storeModel.getStoreId() != null ) {
            mappingTarget.setStoreId( storeModel.getStoreId() );
        }
        if ( storeModel.getSiret() != null ) {
            mappingTarget.setSiret( storeModel.getSiret() );
        }
        if ( storeModel.getStoreName() != null ) {
            mappingTarget.setStoreName( storeModel.getStoreName() );
        }
        if ( storeModel.getSector() != null ) {
            mappingTarget.setSector( storeModel.getSector() );
        }
        if ( storeModel.getFirstname() != null ) {
            mappingTarget.setFirstname( storeModel.getFirstname() );
        }
        if ( storeModel.getLastname() != null ) {
            mappingTarget.setLastname( storeModel.getLastname() );
        }
        if ( storeModel.getEmail() != null ) {
            mappingTarget.setEmail( storeModel.getEmail() );
        }
        if ( storeModel.getPhoneNumber() != null ) {
            mappingTarget.setPhoneNumber( storeModel.getPhoneNumber() );
        }
        if ( storeModel.getCreatedAt() != null ) {
            mappingTarget.setCreatedAt( storeModel.getCreatedAt() );
        }
        if ( storeModel.getUpdatedAt() != null ) {
            mappingTarget.setUpdatedAt( storeModel.getUpdatedAt() );
        }
        if ( storeModel.getDeletedAt() != null ) {
            mappingTarget.setDeletedAt( storeModel.getDeletedAt() );
        }
        if ( storeModel.getSubscriptionId() != null ) {
            mappingTarget.setSubscriptionId( storeModel.getSubscriptionId() );
        }
        if ( mappingTarget.getAddresses() != null ) {
            List<AddressEntity> list = addressModelListToAddressEntityList1( storeModel.getAddresses(), cycleAvoidingMappingContext );
            if ( list != null ) {
                mappingTarget.getAddresses().clear();
                mappingTarget.getAddresses().addAll( list );
            }
        }
        else {
            List<AddressEntity> list = addressModelListToAddressEntityList1( storeModel.getAddresses(), cycleAvoidingMappingContext );
            if ( list != null ) {
                mappingTarget.setAddresses( list );
            }
        }
    }
}
