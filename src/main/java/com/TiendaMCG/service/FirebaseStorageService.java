package com.TiendaMCG.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface FirebaseStorageService {
      
    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);
    
    final String BucketName = categoria.appspot.com;
    
    final String rutaSuperiorStorage = "categoria";
    
    final String rutaJsonFile = "firebase";
    
    final String archivoJsonFile = "categoria-firebase-adminsdk-ftnwx-0442f8d411.json";
    
}
