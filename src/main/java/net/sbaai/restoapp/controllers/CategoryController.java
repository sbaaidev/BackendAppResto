package net.sbaai.restoapp.controllers;

import net.sbaai.restoapp.model.Category;
import net.sbaai.restoapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categorys")
    public ResponseEntity<List<Category>> getAllCategorys(@RequestParam(required = false) String name) {
        try {
            List<Category> categories = new ArrayList<Category>();


            categoryRepository.findAll().forEach(categories::add);


            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorys/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
        Optional<Category> tutorialData = categoryRepository.findById(id);

        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/categorys")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        try {
            Category categoryrepo = categoryRepository
                    .save(new Category(category.getName()));
            return new ResponseEntity<>(categoryrepo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping("/categorys/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        Optional<Category> categoryData = categoryRepository.findById(id);

        if (categoryData.isPresent()) {
            Category _category = categoryData.get();
            _category.setName(category.getName());
            // _tutorial.setDescription(tutorial.getDescription());
            // _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/categorys/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") Long id) {
        try {
            categoryRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping("/category")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            categoryRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }

    }


}
