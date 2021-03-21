package com.nag.beer.web.mapper;

import com.nag.beer.web.domain.Beer;
import com.nag.beer.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDTO(Beer beer);
    Beer beerDTOToBeer(BeerDto dto);
}
