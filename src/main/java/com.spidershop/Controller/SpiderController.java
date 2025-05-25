package com.spidershop.Controller;

import com.spidershop.Dto.SpiderDto;
import com.spidershop.Entity.Spider;
import com.spidershop.Services.SpiderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        Spider spider = spiderService.getSpiderById(id);
        return ResponseEntity.ok(spider);
    }

    @PostMapping
    public ResponseEntity<Spider> createSpider(@Valid @RequestBody SpiderDto spiderDto) {
        Spider createdSpider = spiderService.createSpider(spiderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpider);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Spider> updateSpider(@PathVariable Long id, @Valid @RequestBody SpiderDto dto) {
        Spider updated = spiderService.updateSpider(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpider(@PathVariable Long id) {
        spiderService.deleteSpider(id);
        return ResponseEntity.noContent().build();
    }
}
