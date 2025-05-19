package com.spidershop.Services;

import com.spidershop.Entity.Spider;
import com.spidershop.Repository.SpiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpiderServiceImpl implements SpiderService {

    private final SpiderRepository spiderRepository;

    public SpiderServiceImpl(SpiderRepository spiderRepository) {
        this.spiderRepository = spiderRepository;
    }

    @Override
    public List<Spider> getAllSpiders() {
        return spiderRepository.findAll();
    }

    @Override
    public Spider getSpiderById(Long id) {
        return spiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spider not found"));
    }

    @Override
    public Spider createSpider(Spider spider) {
        return spiderRepository.save(spider);
    }

    @Override
    public Spider updateSpider(Long id, Spider updatedSpider) {

        Spider existingSpider = getSpiderById(id);

        existingSpider.setGenus(updatedSpider.getGenus());
        existingSpider.setSpecies(updatedSpider.getSpecies());
        existingSpider.setSize(updatedSpider.getSize());
        existingSpider.setSex(updatedSpider.getSex());
        existingSpider.setPrice(updatedSpider.getPrice());
        existingSpider.setQuantity(updatedSpider.getQuantity());
        existingSpider.setDescription(updatedSpider.getDescription());
        existingSpider.setAvailable(updatedSpider.isAvailable());

        return spiderRepository.save(existingSpider);
    }

    @Override
    public void deleteById(Long id) {
        spiderRepository.deleteById(id);
    }
}