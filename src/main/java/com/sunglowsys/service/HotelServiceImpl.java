package com.sunglowsys.service;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.repository.HotelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HotelServiceImpl  implements HotelService{

    private final Logger log = LoggerFactory.getLogger(HotelServiceImpl.class);

    private  final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public Hotel save(Hotel hotel) {
        log.debug("Request to create hotel: {}",hotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel update(Hotel hotel) {
        log.debug("request to update hotel: {}",hotel);
        return hotelRepository.save(hotel);
    }

    @Override
    public Page<Hotel> findAll(Pageable pageable) {
        log.debug("request to  ind all hotel :{}",pageable);
        return hotelRepository.findAll(pageable);
    }

    @Override
    public Optional<Hotel> findById(Long id) {
        log.debug("request to find hotel by id: {}",id);
        return hotelRepository.findById(id);
    }

    @Override
    public void delete(Long id) {

        log.debug("request to delete hotel: {}",id);
        hotelRepository.findById(id);

    }
}
