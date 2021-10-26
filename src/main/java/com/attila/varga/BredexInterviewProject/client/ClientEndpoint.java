package com.attila.varga.BredexInterviewProject.client;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientEndpoint {

    private final ClientService clientService;

    @PostMapping ResponseEntity<String> createClient(@RequestBody ClientRequest clientRequest) {
        String id = clientService.createClient(clientRequest);

        return ResponseEntity.ok().body(id);
    }
}
