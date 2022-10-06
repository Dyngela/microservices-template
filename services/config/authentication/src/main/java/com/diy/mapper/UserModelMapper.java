package com.diy.mapper;

import com.diy.entity.UserEntity;
import com.diy.generated.model.UserDto;
import com.diy.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;

@Mapper(unmappedSourcePolicy = ReportingPolicy.ERROR, unmappedTargetPolicy = ReportingPolicy.ERROR,
        typeConversionPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserModelMapper {
    UserDto toDto(UserModel userModel);
    List<UserDto> toDtos(Collection<UserDto> userModels);
    UserModel entityToModel(UserEntity userEntity);
    UserEntity toEntity(UserDto userDto);
    UserModel dtoToModel(UserDto userDto);
}
