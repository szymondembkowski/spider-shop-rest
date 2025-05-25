package com.spidershop.Services;

import com.spidershop.Dto.SpiderDto;
import com.spidershop.Entity.Spider;

import java.util.List;
import java.util.Optional;

public interface SpiderService {

    List<Spider> getAllSpiders();

    Spider getSpiderById(Long id);

    Spider createSpider(SpiderDto spiderDto);

    Spider updateSpider(Long id, SpiderDto spiderDto);

    void deleteSpider(Long id);
}
