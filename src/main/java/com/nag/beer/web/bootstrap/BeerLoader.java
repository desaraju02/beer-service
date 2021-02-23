package com.nag.beer.web.bootstrap;

import com.nag.beer.web.domain.Beer;
import com.nag.beer.web.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0)
        {
            beerRepository.save((Beer.builder()
                    .beerName("ABC Beer")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(3370L)
                    .price(new BigDecimal("12.95"))
                    .minOnHand(10)
                    .build()));

            beerRepository.save((Beer.builder()
                    .beerName("DEF Beer")
                    .beerStyle("API")
                    .quantityToBrew(200)
                    .upc(5555L)
                    .price(new BigDecimal("15.95"))
                    .minOnHand(100)
                    .build()));

            System.out.println("Loaded all Beers ....");
        }
        System.out.println("Just coming out of Loading Beers ...");
    }
}
