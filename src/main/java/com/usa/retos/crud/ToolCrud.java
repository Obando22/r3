package com.usa.retos.crud;

import com.usa.retos.model.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolCrud extends CrudRepository<Tool, Integer> {
}
