package com.TiendaMCG.controller;

import ch.qos.logback.core.model.Model;
import com.TiendaMCG.domain.Categoria;
import com.TiendaMCG.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/categoria")

public class IndexController {
    
    @Autowired 
    private CategoriaService categoriaSevice;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        ver categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        model.addAttribute("totalCategorias", categorias.size());
        return "/categorias/listado";
    }
    
    @GetMapping("/nuevo")
    public String categoriaNuevo(Categoria categoria) {
        return "/condominio/modifica";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String categoriaGuardar(Categoria categoria, @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty() {
            categoriaService.save(categoria);
            categoria.setRutaImagen(firebaseStorageService.cargaImagen(imagenFile, "categoria", categoria.getIdCategoria()));
        }
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String categoriaModificar(Categoria categoria, Model model) {
            categoria = categoriaService.getCategorias(categoria);
    model.addAttriute("categoria", categorias);
    return "/categorias/modifica";
    }
    
}
