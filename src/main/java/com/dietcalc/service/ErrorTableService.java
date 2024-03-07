package com.dietcalc.service;

import com.dietcalc.entity.ErrorTable;
import com.dietcalc.repository.ErrorTableRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ErrorTableService {

    private final ErrorTableRepository errorTableRepository;

    public void saveLineError(ErrorTable error) {
        this.errorTableRepository.save(error);
    }
}
