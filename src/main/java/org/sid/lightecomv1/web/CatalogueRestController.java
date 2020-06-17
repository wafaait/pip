package org.sid.lightecomv1.web;

import org.sid.lightecomv1.dao.ArticlRepository;

import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.entities.Articl;

import org.sid.lightecomv1.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class CatalogueRestController {
   @Autowired
    private ArticlRepository articlRepository;
   @Autowired
   private CategoryRepository categoryRepository;



    @GetMapping(path="/photoArticl/{id}",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
        Articl p=articlRepository.findById(id).get();
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/donn/articls/"+p.getPhotoName()));
    }

    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto(MultipartFile file, @PathVariable Long id) throws Exception{
       Articl a =articlRepository.findById(id).get();
       a.setPhotoName(file.getOriginalFilename());
       Files.write(Paths.get(System.getProperty("user.home")+"/donn/articls/"+a.getPhotoName()),file.getBytes());
       articlRepository.save(a);
    }
    @GetMapping(path = "/imageCat/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] image(@PathVariable(name = "id") Long id) throws Exception {
        Category category = categoryRepository.findById(id).get();
        String photoName = category.getPhoto();
        File file = new File(System.getProperty("user.home")+"/donn/articls/"+photoName);
        Path path = Paths.get(file.toURI());
        return Files.readAllBytes(path);

    }

    @PostMapping( value = "/listArticls/{id}")
    public Articl save(@RequestBody Articl a){

        return articlRepository.save(a);
    }
    @PostMapping(value ="caddy/id")
    public void addToCaddy(@PathVariable("id") Long id){

    }
}
