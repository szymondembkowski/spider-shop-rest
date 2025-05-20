package com.spidershop.Controller;

import com.spidershop.Entity.Spider;
import com.spidershop.Services.SpiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Spider> getSpiderById(@PathVariable Long id) {
        return ResponseEntity.ok(spiderService.getSpiderById(id));
    }

    @PostMapping
    public ResponseEntity<Spider> createSpider(@RequestBody Spider spider) {
        return ResponseEntity.ok(spiderService.createSpider(spider));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spider> updateSpider(@PathVariable Long id, @RequestBody Spider spider) {
        return ResponseEntity.ok(spiderService.updateSpider(id, spider));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpider(@PathVariable Long id) {
        spiderService.deleteSpider(id);
        return ResponseEntity.noContent().build();
    }
}
