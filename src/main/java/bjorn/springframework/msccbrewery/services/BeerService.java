package bjorn.springframework.msccbrewery.services;

import bjorn.springframework.msccbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    BeerDto getBeerById(UUID beerId);
}
