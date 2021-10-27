package com.attila.varga.BredexInterviewProject.position;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/positions")
@RequiredArgsConstructor
public class PositionEndpoint {

    private final PositionService positionService;

    @PostMapping
    ResponseEntity<String> createPosition(@RequestHeader(value="Authorization") String apiKey, @RequestBody PositionRequest positionRequest) {
        String url = positionService.createPosition(apiKey, positionRequest);

        return ResponseEntity.ok().body(url);
    }

    @GetMapping
    ResponseEntity<List<String>> getPositions(@RequestHeader(value="Authorization") String apiKey, @RequestBody PositionRequest positionRequest) {
        List<String> urls = positionService.getPositions(apiKey, positionRequest);

        return ResponseEntity.ok().body(urls);
    }
}
