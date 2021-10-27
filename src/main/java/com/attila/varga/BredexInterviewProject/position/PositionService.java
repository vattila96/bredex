package com.attila.varga.BredexInterviewProject.position;

import com.attila.varga.BredexInterviewProject.client.ClientEntity;
import com.attila.varga.BredexInterviewProject.client.ClientRepository;
import com.attila.varga.BredexInterviewProject.common.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PositionService {

    private final ClientRepository clientRepository;
    private final PositionRepository positionRepository;

    public String createPosition(String apiKey, PositionRequest positionRequest) {
        boolean isApiKeyValid = false;

        for (ClientEntity clientEntity : clientRepository.findAll()) {
            if (Objects.equals(clientEntity.getUuid(), apiKey)) {
                isApiKeyValid = true;
                break;
            }
        }

        if (!isApiKeyValid) throw new ValidationException("invalid api key");
        if (positionRequest.getName().length() > 50) throw new ValidationException("position name max 50 characters");
        if (positionRequest.getLocation().length() > 50) throw new ValidationException("location max 50 characters");

        String url = "jobs.hu/" + generatePositionUrl();

        PositionEntity positionEntity = new PositionEntity(positionRequest.getName(), positionRequest.getLocation(), url);
        positionRepository.save(positionEntity);

        return url;
    }

    public String generatePositionUrl() {
        String chars = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder url;

        url = new StringBuilder();
        Random rnd = new Random();
        while (url.length() < 6) {
            int index = (int) (rnd.nextFloat() * chars.length());
            url.append(chars.charAt(index));
        }

        return url.toString();
    }

    List<String> getPositions(String apiKey, PositionRequest positionRequest) {
        boolean isApiKeyValid = false;

        for (ClientEntity clientEntity : clientRepository.findAll()) {
            if (clientEntity.getUuid().equals(apiKey)) {
                isApiKeyValid = true;
                break;
            }
        }

        if (!isApiKeyValid) throw new ValidationException("invalid api key");
        if (positionRequest.getName().length() > 50) throw new ValidationException("position name max 50 characters");
        if (positionRequest.getLocation().length() > 50) throw new ValidationException("location max 50 characters");

        List<String> urls = new ArrayList<>();

        for (PositionEntity positionEntity : positionRepository.findAll()) {
            if (positionEntity.getName().toLowerCase().contains(positionRequest.getName())
                    && positionEntity.getLocation().toLowerCase().contains(positionRequest.getLocation())) {
                urls.add(positionEntity.getUrl());
            }
        }

        return urls;
    }
}
