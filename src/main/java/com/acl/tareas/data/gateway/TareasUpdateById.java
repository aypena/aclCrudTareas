package com.acl.tareas.data.gateway;

import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;

public interface TareasUpdateById {
    ResponseDto modifyNewsById(Integer id, TareasDTO featuredNews );
}
