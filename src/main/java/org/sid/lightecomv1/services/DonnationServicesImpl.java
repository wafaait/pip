package org.sid.lightecomv1.services;

import net.bytebuddy.utility.RandomString;
import org.sid.lightecomv1.dao.ArticlRepository;
import org.sid.lightecomv1.dao.CategoryRepository;
import org.sid.lightecomv1.dao.VilleRepository;
import org.sid.lightecomv1.entities.Articl;
import org.sid.lightecomv1.entities.Category;
import org.sid.lightecomv1.entities.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Service
@Transactional
public class DonnationServicesImpl implements IDonnationInitService {
    @Autowired
    private VilleRepository villeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ArticlRepository articlRepository;

    @Override
    public void initVilles() {
        Stream.of("Casablanca","Marrackech","Rabet","Tanger","Agadir","Tinghir")
                .forEach(nameVille->{
                    Ville ville= new Ville();
                    ville.setName(nameVille);
                    villeRepository.save(ville);
                });

    }

    @Override
    public void initCategories() {
        villeRepository.findAll().forEach(v->{
            Stream.of("robe","t-chirt","pull","books","cassquette","meuble","accessoiredecuisine")
                    .forEach(nameCategory->{
                        Category category= new Category();
                        category.setName(nameCategory);
                        category.setVille(v);
                        category.setPhoto(nameCategory+".png");
                        categoryRepository.save(category);



                    });
        });

    }

    @Override
    public void initArticls() {
        List<Category>categories=categoryRepository.findAll();
        Random rnd=new Random();

        categoryRepository.findAll().forEach(c->{
            Stream.of("Robe Noire","T-chirt Rose","Costume Homme","Pentalon","Chossure").forEach(filmName->{
                for (int i = 0; i <5 ; i++) {
                    Articl a=new Articl();
                    a.setName(filmName);

                    a.setAvailable(rnd.nextBoolean());
                    a.setDatePublication(new Date());
                    a.setDescription(RandomString.make(18));
                    a.setSelected(rnd.nextBoolean());
                    a.setCategory(c);
                    a.setPhotoName("unknown.png");
                    articlRepository.save(a);
                }

            });


        });

    }
}
