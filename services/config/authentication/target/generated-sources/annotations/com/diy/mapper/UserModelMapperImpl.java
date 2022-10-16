package com.diy.mapper;

import com.diy.entity.UserEntity;
import com.diy.enums.Roles;
import com.diy.generated.model.UserDto;
import com.diy.model.UserModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-15T19:19:33+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.4 (Oracle Corporation)"
)
@Component
public class UserModelMapperImpl implements UserModelMapper {

    @Override
    public UserDto toDto(UserModel userModel) {
        if ( userModel == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        if ( userModel.getUserId() != null ) {
            userDto.setUserId( userModel.getUserId().intValue() );
        }
        userDto.setEmail( userModel.getEmail() );
        userDto.setPassword( userModel.getPassword() );
        userDto.setFirstName( userModel.getFirstName() );
        userDto.setLastName( userModel.getLastName() );
        userDto.setPhoneNumber( userModel.getPhoneNumber() );
        if ( userModel.getStoreId() != null ) {
            userDto.setStoreId( String.valueOf( userModel.getStoreId() ) );
        }
        if ( userModel.getRole() != null ) {
            userDto.setRole( userModel.getRole().name() );
        }

        return userDto;
    }

    @Override
    public List<UserDto> toDtos(Collection<UserDto> userModels) {
        if ( userModels == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userModels.size() );
        for ( UserDto userDto : userModels ) {
            list.add( userDto );
        }

        return list;
    }

    @Override
    public UserModel entityToModel(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        userModel.setUserId( userEntity.getUserId() );
        userModel.setEmail( userEntity.getEmail() );
        userModel.setPassword( userEntity.getPassword() );
        userModel.setFirstName( userEntity.getFirstName() );
        userModel.setLastName( userEntity.getLastName() );
        userModel.setPhoneNumber( userEntity.getPhoneNumber() );
        userModel.setStoreId( userEntity.getStoreId() );
        userModel.setRole( userEntity.getRole() );
        userModel.setCreatedAt( userEntity.getCreatedAt() );
        userModel.setUpdatedAt( userEntity.getUpdatedAt() );
        userModel.setDeletedAt( userEntity.getDeletedAt() );

        return userModel;
    }

    @Override
    public UserEntity toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        if ( userDto.getUserId() != null ) {
            userEntity.setUserId( userDto.getUserId().longValue() );
        }
        userEntity.setEmail( userDto.getEmail() );
        userEntity.setPassword( userDto.getPassword() );
        userEntity.setFirstName( userDto.getFirstName() );
        userEntity.setLastName( userDto.getLastName() );
        userEntity.setPhoneNumber( userDto.getPhoneNumber() );
        if ( userDto.getStoreId() != null ) {
            userEntity.setStoreId( Long.parseLong( userDto.getStoreId() ) );
        }
        if ( userDto.getRole() != null ) {
            userEntity.setRole( Enum.valueOf( Roles.class, userDto.getRole() ) );
        }

        return userEntity;
    }

    @Override
    public UserModel dtoToModel(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserModel userModel = new UserModel();

        if ( userDto.getUserId() != null ) {
            userModel.setUserId( userDto.getUserId().longValue() );
        }
        userModel.setEmail( userDto.getEmail() );
        userModel.setPassword( userDto.getPassword() );
        userModel.setFirstName( userDto.getFirstName() );
        userModel.setLastName( userDto.getLastName() );
        userModel.setPhoneNumber( userDto.getPhoneNumber() );
        if ( userDto.getStoreId() != null ) {
            userModel.setStoreId( Long.parseLong( userDto.getStoreId() ) );
        }
        if ( userDto.getRole() != null ) {
            userModel.setRole( Enum.valueOf( Roles.class, userDto.getRole() ) );
        }

        return userModel;
    }
}
