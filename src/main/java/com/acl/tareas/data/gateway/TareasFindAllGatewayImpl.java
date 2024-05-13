package com.acl.tareas.data.gateway;

import com.acl.tareas.data.mapper.ListTareasEntityToListTareasDTOMapper;
import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.TareasDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class TareasFindAllGatewayImpl implements  TareasFindAll{
    private ListTareasEntityToListTareasDTOMapper listTareasEntityToListTareasDTOMapper;

    private final TareasRepository tareasRepository;
    @Override
    public List<TareasDTO> findTareasAll() {
        return listTareasEntityToListTareasDTOMapper.mapper(tareasRepository.findAll());
    }
}
