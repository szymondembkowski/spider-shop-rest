package com.spidershop.Controller;

import com.spidershop.Entity.Spider;
import com.spidershop.Repository.SpiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spiders")
public class SpiderController {

    private final SpiderRepository spiderRepository;

    @Autowired
    public SpiderController(SpiderRepository spiderRepository){
        this.spiderRepository = spiderRepository;
    }

    @GetMapping
    public List<Spider> getAllSpiders(){
        return spiderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Spider getSpiderById(@PathVariable Long id){
        return spiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spider not found"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Spider createSpider(@RequestBody Spider spider){
        return spiderRepository.save(spider);
    }

    @PutMapping("/{id}")
    public Spider updateSpider(@PathVariable Long id, @RequestBody Spider updatedSpider){

        Spider spider = spiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spider not found"));

        spider.setGenus(updatedSpider.getGenus());
        spider.setSpecies(updatedSpider.getSpecies());
        spider.setPrice(updatedSpider.getPrice());
        spider.setSize(updatedSpider.getSize());
        spider.setSex(updatedSpider.getSex());
        spider.setDescription(updatedSpider.getDescription());
        spider.setQuantity(updatedSpider.getQuantity());
        spider.setAvailable(updatedSpider.isAvailable());

        return spiderRepository.save(spider);
    }

    @DeleteMapping("/{id}")
    public void deleteSpider(@PathVariable Long id){
        spiderRepository.deleteById(id);
    }
}
