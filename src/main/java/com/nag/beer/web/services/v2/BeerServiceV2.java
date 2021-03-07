package com.nag.beer.web.services.v2;



import com.nag.beer.web.model.v2.BeerDtoV2;

import java.util.UUID;

/**
 * Created by jt on 2019-04-23.
 */
public interface BeerServiceV2 {
    BeerDtoV2 getBeerById(UUID beerId);

    BeerDtoV2 saveNewBeer(BeerDtoV2 beerDto);

    void updateBeer(UUID beerId, BeerDtoV2 beerDto);

    void deleteById(UUID beerId);
}
