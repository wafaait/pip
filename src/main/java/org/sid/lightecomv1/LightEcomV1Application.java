package org.sid.lightecomv1;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecomv1.dao.ArticlRepository;
import org.sid.lightecomv1.dao.CategoryRepository;

import org.sid.lightecomv1.dao.VilleRepository;
import org.sid.lightecomv1.entities.Articl;
import org.sid.lightecomv1.entities.Category;

import org.sid.lightecomv1.entities.Ville;
import org.sid.lightecomv1.services.IDonnationInitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;
import java.util.Random;

@SpringBootApplication
public class LightEcomV1Application implements CommandLineRunner {
    @Autowired
    private ArticlRepository articlRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private IDonnationInitService donnationInitService;

    public static void main(String[] args) {
        SpringApplication.run(LightEcomV1Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        repositoryRestConfiguration.exposeIdsFor(Articl.class,Category.class, Ville.class);
        donnationInitService.initVilles();
        donnationInitService.initCategories();
        donnationInitService.initArticls();

    }
}
