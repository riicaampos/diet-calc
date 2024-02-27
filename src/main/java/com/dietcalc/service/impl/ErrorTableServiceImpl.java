package com.dietcalc.service.impl;

import com.dietcalc.entity.ErrorTable;
import com.dietcalc.repository.ErrorTableRepository;
import com.dietcalc.service.ErrorTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ErrorTableServiceImpl implements ErrorTableService {

    private final ErrorTableRepository errorTableRepository;
    @Override
    public void saveLineError(ErrorTable error) {
        this.errorTableRepository.save(error);
    }
}
