package com.diy.mapper;

import com.diy.entity.AddressEntity;
import com.diy.entity.StoreEntity;
import com.diy.generated.model.AddressDto;
import com.diy.generated.model.StoreDto;
import com.diy.model.AddressModel;
import com.diy.model.StoreModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-16T12:50:48+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class StoreModelMapperImpl implements StoreModelMapper {

    @Override
    public StoreDto modelToDto(StoreModel storeModel) {
        if ( storeModel == null ) {
            return null;
        }

        StoreDto storeDto = new StoreDto();

        storeDto.setStoreId( storeModel.getStoreId() );
        storeDto.setSiret( storeModel.getSiret() );
        storeDto.setStoreName( storeModel.getStoreName() );
        storeDto.setSector( storeModel.getSector() );
        storeDto.setFirstname( storeModel.getFirstname() );
        storeDto.setLastname( storeModel.getLastname() );
        storeDto.setEmail( storeModel.getEmail() );
        storeDto.setPhoneNumber( storeModel.getPhoneNumber() );
        storeDto.setSubscriptionId( storeModel.getSubscriptionId() );
        storeDto.setAddresses( addressModelListToAddressDtoList( storeModel.getAddresses() ) );

        return storeDto;
    }

    @Override
    public List<StoreDto> modelsToDtos(List<StoreModel> storeModels) {
        if ( storeModels == null ) {
            return null;
        }

        List<StoreDto> list = new ArrayList<StoreDto>( storeModels.size() );
        for ( StoreModel storeModel : storeModels ) {
            list.add( modelToDto( storeModel ) );
        }

        return list;
    }

    @Override
    public StoreModel dtoToModel(StoreDto storeDto) {
        if ( storeDto == null ) {
            return null;
        }

        StoreModel storeModel = new StoreModel();

        storeModel.setStoreId( storeDto.getStoreId() );
        storeModel.setSiret( storeDto.getSiret() );
        storeModel.setSector( storeDto.getSector() );
        storeModel.setStoreName( storeDto.getStoreName() );
        storeModel.setFirstname( storeDto.getFirstname() );
        storeModel.setLastname( storeDto.getLastname() );
        storeModel.setEmail( storeDto.getEmail() );
        storeModel.setPhoneNumber( storeDto.getPhoneNumber() );
        storeModel.setSubscriptionId( storeDto.getSubscriptionId() );
        storeModel.setAddresses( addressDtoListToAddressModelList( storeDto.getAddresses() ) );

        return storeModel;
    }

    @Override
    public List<StoreModel> dtosToModels(List<StoreDto> storeDtos) {
        if ( storeDtos == null ) {
            return null;
        }

        List<StoreModel> list = new ArrayList<StoreModel>( storeDtos.size() );
        for ( StoreDto storeDto : storeDtos ) {
            list.add( dtoToModel( storeDto ) );
        }

        return list;
    }

    @Override
    public StoreEntity modelToEntity(StoreModel storeModel) {
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

    @Override
    public List<StoreEntity> modelsToEntities(List<StoreEntity> storeEntities) {
        if ( storeEntities == null ) {
            return null;
        }

        List<StoreEntity> list = new ArrayList<StoreEntity>( storeEntities.size() );
        for ( StoreEntity storeEntity : storeEntities ) {
            list.add( storeEntity );
        }

        return list;
    }

    @Override
    public StoreModel entityToModel(StoreEntity storeEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
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
        storeModel.setAddresses( addressEntityListToAddressModelList( storeEntity.getAddresses(), cycleAvoidingMappingContext ) );

        return storeModel;
    }

    @Override
    public List<StoreModel> entitiesToModels(List<StoreEntity> storeEntities, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<StoreModel> target = cycleAvoidingMappingContext.getMappedInstance( storeEntities, List.class );
        if ( target != null ) {
            return target;
        }

        if ( storeEntities == null ) {
            return null;
        }

        List<StoreModel> list = new ArrayList<StoreModel>( storeEntities.size() );
        cycleAvoidingMappingContext.storeMappedInstance( storeEntities, list );

        for ( StoreEntity storeEntity : storeEntities ) {
            list.add( entityToModel( storeEntity, cycleAvoidingMappingContext ) );
        }

        return list;
    }

    @Override
    public void updateStoreFromModel(StoreModel model, StoreEntity entity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        if ( model == null ) {
            return;
        }

        cycleAvoidingMappingContext.storeMappedInstance( model, entity );

        if ( model.getStoreId() != null ) {
            entity.setStoreId( model.getStoreId() );
        }
        if ( model.getSiret() != null ) {
            entity.setSiret( model.getSiret() );
        }
        if ( model.getStoreName() != null ) {
            entity.setStoreName( model.getStoreName() );
        }
        if ( model.getSector() != null ) {
            entity.setSector( model.getSector() );
        }
        if ( model.getFirstname() != null ) {
            entity.setFirstname( model.getFirstname() );
        }
        if ( model.getLastname() != null ) {
            entity.setLastname( model.getLastname() );
        }
        if ( model.getEmail() != null ) {
            entity.setEmail( model.getEmail() );
        }
        if ( model.getPhoneNumber() != null ) {
            entity.setPhoneNumber( model.getPhoneNumber() );
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
        if ( model.getSubscriptionId() != null ) {
            entity.setSubscriptionId( model.getSubscriptionId() );
        }
        if ( entity.getAddresses() != null ) {
            List<AddressEntity> list = addressModelListToAddressEntityList1( model.getAddresses(), cycleAvoidingMappingContext );
            if ( list != null ) {
                entity.getAddresses().clear();
                entity.getAddresses().addAll( list );
            }
        }
        else {
            List<AddressEntity> list = addressModelListToAddressEntityList1( model.getAddresses(), cycleAvoidingMappingContext );
            if ( list != null ) {
                entity.setAddresses( list );
            }
        }
    }

    protected AddressDto addressModelToAddressDto(AddressModel addressModel) {
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

    protected List<AddressDto> addressModelListToAddressDtoList(List<AddressModel> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressDto> list1 = new ArrayList<AddressDto>( list.size() );
        for ( AddressModel addressModel : list ) {
            list1.add( addressModelToAddressDto( addressModel ) );
        }

        return list1;
    }

    protected AddressModel addressDtoToAddressModel(AddressDto addressDto) {
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

    protected List<AddressModel> addressDtoListToAddressModelList(List<AddressDto> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressModel> list1 = new ArrayList<AddressModel>( list.size() );
        for ( AddressDto addressDto : list ) {
            list1.add( addressDtoToAddressModel( addressDto ) );
        }

        return list1;
    }

    protected AddressEntity addressModelToAddressEntity(AddressModel addressModel) {
        if ( addressModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setAddressId( addressModel.getAddressId() );
        addressEntity.setCity( addressModel.getCity() );
        addressEntity.setPostalCode( addressModel.getPostalCode() );
        addressEntity.setComplement( addressModel.getComplement() );
        addressEntity.setStreetNumber( addressModel.getStreetNumber() );
        addressEntity.setStreetName( addressModel.getStreetName() );
        addressEntity.setCreatedAt( addressModel.getCreatedAt() );
        addressEntity.setUpdatedAt( addressModel.getUpdatedAt() );
        addressEntity.setDeletedAt( addressModel.getDeletedAt() );
        addressEntity.setStore( modelToEntity( addressModel.getStore() ) );

        return addressEntity;
    }

    protected List<AddressEntity> addressModelListToAddressEntityList(List<AddressModel> list) {
        if ( list == null ) {
            return null;
        }

        List<AddressEntity> list1 = new ArrayList<AddressEntity>( list.size() );
        for ( AddressModel addressModel : list ) {
            list1.add( addressModelToAddressEntity( addressModel ) );
        }

        return list1;
    }

    protected AddressModel addressEntityToAddressModel(AddressEntity addressEntity, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        AddressModel target = cycleAvoidingMappingContext.getMappedInstance( addressEntity, AddressModel.class );
        if ( target != null ) {
            return target;
        }

        if ( addressEntity == null ) {
            return null;
        }

        AddressModel addressModel = new AddressModel();

        cycleAvoidingMappingContext.storeMappedInstance( addressEntity, addressModel );

        addressModel.setAddressId( addressEntity.getAddressId() );
        addressModel.setCity( addressEntity.getCity() );
        addressModel.setPostalCode( addressEntity.getPostalCode() );
        addressModel.setComplement( addressEntity.getComplement() );
        addressModel.setStreetNumber( addressEntity.getStreetNumber() );
        addressModel.setStreetName( addressEntity.getStreetName() );
        addressModel.setCreatedAt( addressEntity.getCreatedAt() );
        addressModel.setUpdatedAt( addressEntity.getUpdatedAt() );
        addressModel.setDeletedAt( addressEntity.getDeletedAt() );
        addressModel.setStore( entityToModel( addressEntity.getStore(), cycleAvoidingMappingContext ) );

        return addressModel;
    }

    protected List<AddressModel> addressEntityListToAddressModelList(List<AddressEntity> list, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        List<AddressModel> target = cycleAvoidingMappingContext.getMappedInstance( list, List.class );
        if ( target != null ) {
            return target;
        }

        if ( list == null ) {
            return null;
        }

        List<AddressModel> list1 = new ArrayList<AddressModel>( list.size() );
        cycleAvoidingMappingContext.storeMappedInstance( list, list1 );

        for ( AddressEntity addressEntity : list ) {
            list1.add( addressEntityToAddressModel( addressEntity, cycleAvoidingMappingContext ) );
        }

        return list1;
    }

    protected AddressEntity addressModelToAddressEntity1(AddressModel addressModel, CycleAvoidingMappingContext cycleAvoidingMappingContext) {
        AddressEntity target = cycleAvoidingMappingContext.getMappedInstance( addressModel, AddressEntity.class );
        if ( target != null ) {
            return target;
        }

        if ( addressModel == null ) {
            return null;
        }

        AddressEntity addressEntity = new AddressEntity();

        cycleAvoidingMappingContext.storeMappedInstance( addressModel, addressEntity );

        addressEntity.setAddressId( addressModel.getAddressId() );
        addressEntity.setCity( addressModel.getCity() );
        addressEntity.setPostalCode( addressModel.getPostalCode() );
        addressEntity.setComplement( addressModel.getComplement() );
        addressEntity.setStreetNumber( addressModel.getStreetNumber() );
        addressEntity.setStreetName( addressModel.getStreetName() );
        addressEntity.setCreatedAt( addressModel.getCreatedAt() );
        addressEntity.setUpdatedAt( addressModel.getUpdatedAt() );
        addressEntity.setDeletedAt( addressModel.getDeletedAt() );
        addressEntity.setStore( modelToEntity( addressModel.getStore() ) );

        return addressEntity;
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
            list1.add( addressModelToAddressEntity1( addressModel, cycleAvoidingMappingContext ) );
        }

        return list1;
    }
}
