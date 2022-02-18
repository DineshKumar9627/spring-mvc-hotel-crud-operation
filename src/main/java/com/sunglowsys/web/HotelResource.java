package com.sunglowsys.web;

import com.sunglowsys.domain.Hotel;
import com.sunglowsys.service.HotelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/")
public class HotelResource {

    private final Logger log  = LoggerFactory.getLogger(HotelResource.class);

    private  final HotelService  hotelService;

    public HotelResource(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ModelAndView home(){
        log.debug("web request to create hotel");
        Page<Hotel> page = hotelService.findAll(PageRequest.of(0,20));
        List<Hotel> hotels = page.getContent();
        return new ModelAndView("index","hotels",hotels);
    }

    @GetMapping("/hotels/create")
    public ModelAndView createForm(@ModelAttribute Hotel hotel){
        log.debug("Web request to create hotel form");
        return new ModelAndView("add-hotel","Hotel", hotel);
    }

    @PostMapping("/hotels")
    public ModelAndView createHotel(@ModelAttribute Hotel hotel){
        log.debug("web request to create  hotel: {}",hotel);
        hotelService.save(hotel);
        return new  ModelAndView("redirect:/","hotel",hotel);
    }

    @GetMapping("/hotels/update/{id}")
    public ModelAndView update(@ModelAttribute Hotel hotel, @PathVariable Long id){
        log.debug("web request to  update hotels :{}",id);
        hotel = hotelService.findById(id).get();
        return  new ModelAndView("add-hotel","hotel",hotel);
    }

    @GetMapping("/hotels/delete/{id}")
    public ModelAndView delete(@PathVariable Long id){
        log.debug("Web request to delete hotel: {}",id);
        hotelService.delete(id);
        return  new ModelAndView("redirect:/");

    }



}
