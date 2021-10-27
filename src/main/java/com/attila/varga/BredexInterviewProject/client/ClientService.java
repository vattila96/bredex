package com.attila.varga.BredexInterviewProject.client;

import com.attila.varga.BredexInterviewProject.common.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public String createClient(ClientRequest clientRequest) {
        validateClientRequest(clientRequest);

        UUID uuid = UUID.randomUUID();
        ClientEntity clientEntity = new ClientEntity(clientRequest.getName(), clientRequest.getEmail(), uuid.toString());
        clientRepository.save(clientEntity);

        return uuid.toString();
    }

    public void validateClientRequest(ClientRequest clientRequest) {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(clientRequest.getEmail());

        if (clientRequest.getName().length() > 100) throw new ValidationException("name must be max 100 characters");
        if (!matcher.find()) throw new ValidationException("email must be a valid email");

        for (ClientEntity clientEntity : clientRepository.findAll()) {
            if (clientEntity.getEmail().equals(clientRequest.getEmail())) throw new ValidationException("email already exists");
        }
    }
}
