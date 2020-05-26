package com.croclub.club.controller;

import com.croclub.club.dto.ClubDto;
import com.croclub.club.model.Club;
import com.croclub.club.repository.ClubRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {
    private ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addClub(@RequestBody ClubDto clubDto) {

        Club club = new Club();
        club.setName(clubDto.getName());
        club.setCapacity(clubDto.getCapacity());
        club.setGenre(clubDto.getGenre());
        

        Club savedClub = clubRepository.save(club);


        return ResponseEntity.ok(savedClub);
    }

    @GetMapping("/allclubs")
    public List<ClubDto> getAllClubs() {
        List<ClubDto> clubDtos = new ArrayList<>();
        List<Club> clubs = clubRepository.findAll();
        for (Club club : clubs) {
            ClubDto clubDto = new ClubDto();
            clubDto.setId(club.getId());
            clubDto.setName(club.getName());
            clubDto.setCapacity(club.getCapacity());
            clubDto.setGenre(club.getGenre());
            clubDtos.add(clubDto);
        }

        return clubDtos;
    }
}
