package bjorn.springframework.msccbrewery.web.controller;

import bjorn.springframework.msccbrewery.services.BeerService;
import bjorn.springframework.msccbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDto beerDto){
        BeerDto beer = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        //todo: add host name to URL
        headers.add("Location","/api/v1/beer/"+beer.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

}
