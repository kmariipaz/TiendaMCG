package com.TiendaMCG.service.impl;

import com.TiendaMCG.dao.CategoriaDao;
import com.TiendaMCG.domain.Categoria;
import com.TiendaMCG.service.CategoriaService;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        ver lista = categoriaDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
        
    }
    
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }
    
    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }
    
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}