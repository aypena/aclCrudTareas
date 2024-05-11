package com.acl.tareas.data.gateway;

import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TareasDeleteByIdImpl implements  TareasDeleteById{

    private final TareasRepository tareasRepository;
    @Override
    public ResponseDto deleteNewsById(Integer id) {
        try {
            tareasRepository.deleteById(id);
            return new ResponseDto(Constants.SUCCESS_CODE, Constants.DELETE_MESSAGE);
        } catch (Exception e) {
            throw e;
        }
    }
}
