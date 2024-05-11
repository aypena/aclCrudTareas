package com.acl.tareas.data.gateway;

import com.acl.tareas.domain.model.TareasDTO;

import java.util.List;

public interface TareasFindAll {
    List<TareasDTO> findTareasAll();
}
