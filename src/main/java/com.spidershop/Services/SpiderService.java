package com.spidershop.Services;

import com.spidershop.Entity.Spider;

import java.util.List;
import java.util.Optional;

public interface SpiderService {

    List<Spider> getAllSpiders();

    Spider getSpiderById(Long id);

    Spider createSpider(Spider spider);

    Spider updateSpider(Long id, Spider spider);

    void deleteSpider(Long id);
}
