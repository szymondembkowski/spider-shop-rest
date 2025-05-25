package com.spidershop.Services;

import com.spidershop.Dto.SpiderDto;
import com.spidershop.Entity.Spider;
import com.spidershop.Repository.SpiderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                .orElseThrow(() -> new RuntimeException("Spider not found with id: " + id));
    }

    @Override
    public Spider createSpider(SpiderDto dto) {
        Spider spider = new Spider();
        spider.setGenus(dto.getGenus());
        spider.setSpecies(dto.getSpecies());
        spider.setPrice(dto.getPrice());
        spider.setQuantity(dto.getQuantity());
        spider.setSize(dto.getSize());
        spider.setSex(dto.getSex());
        return spiderRepository.save(spider);
    }

    @Override
    public Spider updateSpider(Long id, SpiderDto dto) {
        Spider spider = spiderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Spider not found with id: " + id));

        spider.setGenus(dto.getGenus());
        spider.setSpecies(dto.getSpecies());
        spider.setPrice(dto.getPrice());
        spider.setQuantity(dto.getQuantity());
        spider.setSize(dto.getSize());
        spider.setSex(dto.getSex());
        return spiderRepository.save(spider);
    }

    @Override
    public void deleteSpider(Long id) {
        spiderRepository.deleteById(id);
    }

}