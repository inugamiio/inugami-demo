package com.my.project.api.domain.user;

import io.inugami.framework.interfaces.models.crud.Crud;
import com.my.project.api.domain.user.dto.UserDTO;
import com.my.project.api.domain.user.dto.UserDTOSearchRequestDTO;

public interface IUserService extends Crud<UserDTO,String, UserDTOSearchRequestDTO> {

}