package com.acl.tareas.data.gateway;

import com.acl.tareas.data.model.TareasEntity;
import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import com.acl.tareas.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


@Service
@AllArgsConstructor
public class TareasSaveimpl implements  TareasSave{
    private final TareasRepository tareasRepository;
    @Override
    public ResponseDto saveTarea(TareasDTO tareasDTO) throws ParseException {


        Date fechaCrea = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
        String fechaConFormato= formato.format(fechaCrea);
        Date fechaConvertida = formato.parse(fechaConFormato);

        TareasEntity tareasEntity = new TareasEntity(
                tareasDTO.getDescripcion(),
                fechaConvertida,
                tareasDTO.isVigente());

        tareasRepository.save(tareasEntity);

        return new ResponseDto(Constants.SUCCESS_CODE,Constants.SAVED_MESSAGE);

    }
}
