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

        Spider spider = spiderRepository.getSpiderById(id)
                .orElseThrow(() -> new RuntimeException("Spider not found with id: " + id));

        spider.setGenus(updatedSpider.getGenus());
        spider.setSpecies(updatedSpider.getSpecies());
        spider.setSize(updatedSpider.getSize());
        spider.setSex(updatedSpider.getSex());
        spider.setPrice(updatedSpider.getPrice());
        spider.setQuantity(updatedSpider.getQuantity());
        spider.setDescription(updatedSpider.getDescription());
        spider.setAvailable(updatedSpider.isAvailable());

        return spiderRepository.save(spider);
    }

    @Override
    public void deleteSpider(Long id) {
        spiderRepository.deleteById(id);
    }

}