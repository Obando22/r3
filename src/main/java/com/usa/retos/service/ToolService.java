package com.usa.retos.service;

import com.usa.retos.model.Tool;
import com.usa.retos.repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;

    public List<Tool> getAll() {
        return toolRepository.getAll();
    }

    public Optional<Tool> getTool(int id) {
        return toolRepository.getTool(id);
    }

    public Tool save(Tool tool){
        if(tool.getId()==null){
            return toolRepository.save(tool);
        }else{
            Optional<Tool> e= toolRepository.getTool(tool.getId());
            if(e.isEmpty()){
                return toolRepository.save(tool);
            }else{
                return tool;
            }
        }
    }

    public Tool update(Tool tool){
        if(tool.getId()!=null){
            Optional<Tool> tmpTool = toolRepository.getTool(tool.getId());
            if(!tmpTool.isEmpty()){
                if(tool.getName()!=null){
                    tmpTool.get().setName(tool.getName());
                }
                if(tool.getBrand()!=null){
                    tmpTool.get().setBrand(tool.getBrand()); ;
                }
                if(tool.getYear() !=null){
                    tmpTool.get().setYear(tool.getYear());
                }
                if(tool.getDescription()!=null){
                    tmpTool.get().setDescription(tool.getDescription());
                }
                if(tool.getCategory()!=null){
                    tmpTool.get().setCategory(tool.getCategory());
                }
                toolRepository.save(tmpTool.get());
                return tmpTool.get();
            }else{
                return tool;
            }
        }else{
            return tool;
        }
    }

    public boolean deleteTool(int id) {
        Boolean aBoolean = getTool(id).map(tool -> {
            toolRepository.delete(tool);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
