package com.spidershop.Controller;

import com.spidershop.Dto.SpiderDto;
import com.spidershop.Entity.Spider;
import com.spidershop.Services.SpiderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Spiders", description = "Operations related to tarantula spiders in the shop")
@RestController
@RequestMapping("/api/spiders")
public class SpiderController {

    private final SpiderService spiderService;

    @Autowired
    public SpiderController(SpiderService spiderService) {
        this.spiderService = spiderService;
    }

    @Operation(summary = "Get all spiders", description = "Returns a list of all available spiders in the store.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Spiders retrieved successfully"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<Spider> getAllSpiders() {
        return spiderService.getAllSpiders();
    }

    @Operation(summary = "Get a spider by ID", description = "Returns a spider with the specified ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Spider found"),
            @ApiResponse(responseCode = "404", description = "Spider not found")
    })

    @GetMapping("/{id}")
    public ResponseEntity<Spider> getSpiderById(@PathVariable Long id) {
        Spider spider = spiderService.getSpiderById(id);
        return ResponseEntity.ok(spider);
    }

    @Operation(summary = "Create a new spider", description = "Creates a new spider with the provided data.")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Spider created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Spider> createSpider(@Valid @RequestBody SpiderDto spiderDto) {
        Spider createdSpider = spiderService.createSpider(spiderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSpider);
    }

    @Operation(summary = "Update a spider", description = "Updates the data of a spider with the specified ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Spider updated successfully"),
            @ApiResponse(responseCode = "404", description = "Spider not found"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Spider> updateSpider(@PathVariable Long id, @Valid @RequestBody SpiderDto dto) {
        Spider updated = spiderService.updateSpider(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete a spider", description = "Deletes the spider with the specified ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Spider deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Spider not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpider(@PathVariable Long id) {
        spiderService.deleteSpider(id);
        return ResponseEntity.noContent().build();
    }
}
