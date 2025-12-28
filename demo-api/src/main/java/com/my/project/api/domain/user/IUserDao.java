package com.my.project.api.domain.user;

import io.inugami.framework.interfaces.models.crud.CrudDao;
import com.my.project.api.domain.user.dto.UserDTO;
import com.my.project.api.domain.user.dto.UserDTOSearchRequestDTO;

public interface IUserDao extends CrudDao<UserDTO,String, UserDTOSearchRequestDTO> {

}