package com.dietcalc.service.impl;

import com.dietcalc.dto.NutricionalTableResponseDTO;
import com.dietcalc.entity.ErrorTable;
import com.dietcalc.entity.NutritionalTable;
import com.dietcalc.enums.FoodCategories;
import com.dietcalc.repository.NutritionalTableRepository;
import com.dietcalc.service.ErrorTableService;
import com.dietcalc.service.NutritionalTableService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NutritionalTableServiceImpl implements NutritionalTableService {

    private final NutritionalTableRepository nutritionalTableRepository;
    private final ErrorTableService errorTableService;
    private final ModelMapper modelMapper;

    @Override
    public void saveFood(NutritionalTable food) {
       this.nutritionalTableRepository.save(food);
    }


    @Override
    public List<NutricionalTableResponseDTO> listNutricionalTable() {
        return this.nutritionalTableRepository.findAll()
                .stream()
                .map( f-> modelMapper.map(f, NutricionalTableResponseDTO.class))
                .toList();
    }

    @Override
    public List<NutricionalTableResponseDTO> findFoodByDescription(String description) {
        return this.nutritionalTableRepository.findByDescriptionContainingIgnoreCase(description)
                .stream()
                .map( f -> modelMapper.map(f, NutricionalTableResponseDTO.class))
                .toList();
    }

    @Override
    public void populateTable()  {

        BufferedReader br = null;
        String line = "";

        FoodCategories categorie = FoodCategories.FISHANDSEAFOOD;

        try{
            br = new BufferedReader(new FileReader("./src/LinhasComErroCorrigido.txt"));
            line = br.readLine();
        }catch(Exception e){
            log.error(e.getMessage());
        }

        while(line != null){
            NutritionalTable nt = new NutritionalTable();
            String[] splits = line.split(";");

            categorie = FoodCategories.valueOf(splits[12]);

            try {

                nt.setCategorie(categorie);

                nt.setTacoTableId(Long.parseLong(splits[0]));
                nt.setDescription(splits[1]);
                nt.setMoisture(Double.parseDouble(splits[2]));
                nt.setEnergyKcal(Double.parseDouble(splits[3]));
                nt.setEnergyKj(Double.parseDouble(splits[4]));
                nt.setProtein(Double.parseDouble(splits[5]));
                nt.setProtein(Double.parseDouble(splits[6]));
                nt.setProtein(Double.parseDouble(splits[7]));
                nt.setProtein(Double.parseDouble(splits[8]));
                nt.setProtein(Double.parseDouble(splits[9]));
                nt.setProtein(Double.parseDouble(splits[10]));
                nt.setProtein(Double.parseDouble(splits[11]));
                nt.setProtein(Double.parseDouble(splits[12]));

                this.nutritionalTableRepository.save(nt);

            }catch(Exception e){
                log.error("Linha com erro: "+line);
                ErrorTable error = new ErrorTable();
                error.setLineError(line);
                error.setCategorie(categorie);
                error.setErrorMessage(e.getMessage());
                this.errorTableService.saveLineError(error);
            }
            try{
                line = br.readLine();
            }catch(Exception e){
                log.error("erro ao ler a proxima linha");
            }

        }
        try{
            br.close();
        }catch(Exception e){
            log.error("erro ao encerrar bufferedReader");
        }

    }

}