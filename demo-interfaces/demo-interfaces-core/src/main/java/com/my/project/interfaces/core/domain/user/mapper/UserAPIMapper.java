package com.my.project.interfaces.core.domain.user.mapper;

import com.my.project.api.domain.user.dto.UserDTO;
import com.my.project.api.domain.user.dto.UserDTOSearchRequestDTO;
import com.my.project.interfaces.api.domain.user.dto.UserAPI;
import com.my.project.interfaces.api.domain.user.dto.UserDTOSearchRequestAPI;
import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mapper()
public interface UserAPIMapper {

    UserAPI convertToRest(final UserDTO value);

    default Collection<UserAPI> convertToRest(final Collection<UserDTO> values) {
        return Optional.ofNullable(values)
                       .orElse(List.of())
                       .stream()
                       .map(this::convertToRest)
                       .toList();
    }

    UserDTO convertToCore(final UserAPI value);

    default Collection<UserDTO> convertToCore(final Collection<UserAPI> values) {
        return Optional.ofNullable(values)
                       .orElse(List.of())
                       .stream()
                       .map(this::convertToCore)
                       .toList();
    }

    UserDTOSearchRequestDTO convertToCore(final UserDTOSearchRequestAPI value);
}
