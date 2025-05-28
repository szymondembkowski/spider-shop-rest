package com.spidershop.Services;

import com.spidershop.Dto.SpiderDto;
import com.spidershop.Entity.Spider;
import com.spidershop.Entity.SpiderSize;
import com.spidershop.Exception.SpiderNotFoundException;
import com.spidershop.Repository.SpiderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
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
                .orElseThrow(() -> new SpiderNotFoundException("Spider not found with id: " + id));
    }

    @Override
    public Spider createSpider(SpiderDto spiderDto) {
        validateSexBasedOnSize(spiderDto);
        Spider spider = new Spider();
        spider.setGenus(spiderDto.getGenus());
        spider.setSpecies(spiderDto.getSpecies());
        spider.setPrice(spiderDto.getPrice());
        spider.setQuantity(spiderDto.getQuantity());
        spider.setSize(spiderDto.getSize());
        spider.setSex(spiderDto.getSex());
        return spiderRepository.save(spider);
    }

    @Override
    public Spider updateSpider(Long id, SpiderDto spiderDto) {
        validateSexBasedOnSize(spiderDto);
        Spider spider = spiderRepository.findById(id)
                .orElseThrow(() -> new SpiderNotFoundException("Spider not found with id: " + id));

        spider.setGenus(spiderDto.getGenus());
        spider.setSpecies(spiderDto.getSpecies());
        spider.setPrice(spiderDto.getPrice());
        spider.setQuantity(spiderDto.getQuantity());
        spider.setSize(spiderDto.getSize());
        spider.setSex(spiderDto.getSex());
        return spiderRepository.save(spider);
    }

    @Override
    public void deleteSpider(Long id) {
        if (!spiderRepository.existsById(id)) {
            throw new SpiderNotFoundException("Spider not found with id: " + id);
        }
        spiderRepository.deleteById(id);
    }

    private void validateSexBasedOnSize(SpiderDto spiderDto){
        if(spiderDto.getSize().compareTo(SpiderSize.Juvenile) >= 0) {
            if(spiderDto.getSex() == null){
                throw new IllegalArgumentException("Sex must be specified for spiders of size Junvenile or greater.");
            }
        }
    }
}