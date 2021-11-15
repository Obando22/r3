package com.usa.retos.repository;

import com.usa.retos.crud.ToolCrud;
import com.usa.retos.model.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToolRepository {
    @Autowired
    private ToolCrud toolCrud;

    public List<Tool> getAll() {
        return (List<Tool>) toolCrud.findAll();
    }

    public Optional<Tool> getTool(int id) {
        return toolCrud.findById(id);
    }

    public Tool save (Tool tool) {
        return toolCrud.save(tool);
    }

    public void delete (Tool tool) {
        toolCrud.delete(tool);
    }
}
