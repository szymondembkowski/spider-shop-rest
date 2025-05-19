package com.spidershop.Controller;

import com.spidershop.Entity.Spider;
import com.spidershop.Services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spiders")
public class SpiderController {

    private final SpiderService spiderService;

    @Autowired
    public SpiderController(SpiderService spiderService) {
        this.spiderService = spiderService;
    }

    @GetMapping
    public List<Spider> getAllSpiders() {
        return spiderService.getAllSpiders();
    }

    @GetMapping("/{id}")
    public Spider getSpiderById(@PathVariable Long id) {
        return spiderService.getSpiderById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Spider createSpider(@RequestBody Spider spider) {
        return spiderService.createSpider(spider);
    }

    @PutMapping("/{id}")
    public Spider updateSpider(@PathVariable Long id, @RequestBody Spider updatedSpider) {

        Spider spider = spiderService.getSpiderById(id);

        spider.setGenus(updatedSpider.getGenus());
        spider.setSpecies(updatedSpider.getSpecies());
        spider.setPrice(updatedSpider.getPrice());
        spider.setSize(updatedSpider.getSize());
        spider.setSex(updatedSpider.getSex());
        spider.setDescription(updatedSpider.getDescription());
        spider.setQuantity(updatedSpider.getQuantity());
        spider.setAvailable(updatedSpider.isAvailable());

        return spiderService.createSpider(spider);
    }

    @DeleteMapping("/{id}")
    public void deleteSpider(@PathVariable Long id) {
        spiderService.deleteById(id);
    }
}
