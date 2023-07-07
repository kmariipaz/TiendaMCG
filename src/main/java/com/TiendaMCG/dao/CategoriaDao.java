package com.TiendaMCG.dao;

import com.TiendaMCG.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository <Categoria, Long> {
    
}