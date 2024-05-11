package com.acl.tareas.data.gateway;

import com.acl.tareas.domain.model.ResponseDto;

public interface TareasDeleteById {
    ResponseDto deleteNewsById(Integer id);
}
