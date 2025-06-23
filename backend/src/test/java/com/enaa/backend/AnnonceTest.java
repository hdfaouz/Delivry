package com.enaa.backend;


import com.enaa.backend.Dto.TrajetDto;
import com.enaa.backend.Mappers.TrajetMap;
import com.enaa.backend.Model.Driver;
import com.enaa.backend.Model.Trajet;
import com.enaa.backend.Repositories.TrajerRepository;
import com.enaa.backend.Repositories.UserRepository;
import com.enaa.backend.Service.TrajetService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnnonceTest {

    @Mock
    private TrajetMap trajetMap;
    //Créé simulationde mon repository
    @Mock
    private TrajerRepository trajetRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TrajetService trajetService;

    @Test
    void ajouterAnnonceTest() {

        String email = "driver@example.com";
        Driver driver = new Driver();
        driver.setId(1L);

        TrajetDto dto = new TrajetDto(
                "Tanger",
                "Settat",
                "Casa",
                new Date(),
                "120x80x60",
                "fragile",
                200L
        );

        Trajet trajetEntity = new Trajet();
        trajetEntity.setDriver(driver);
        Trajet savedTrajet = new Trajet();
        TrajetDto expectedDto = dto;


        when(trajetMap.toEntity(dto)).thenReturn(trajetEntity);
        when(userRepository.findByEmail(email)).thenReturn(driver);
        when(trajetRepository.save(trajetEntity)).thenReturn(savedTrajet);
        when(trajetMap.toDTO(savedTrajet)).thenReturn(expectedDto);


        try (MockedStatic<SecurityContextHolder> mockedStatic = mockStatic(SecurityContextHolder.class)) {
            SecurityContext context = mock(SecurityContext.class);
            Authentication auth = mock(Authentication.class);

            mockedStatic.when(SecurityContextHolder::getContext).thenReturn(context);
            when(context.getAuthentication()).thenReturn(auth);
            when(auth.getName()).thenReturn(email);


            TrajetDto result = trajetService.ajouterAnnonce(dto);


            assertEquals(dto.getLieuDepart(), result.getLieuDepart());
            assertEquals(dto.getDestinationFinal(), result.getDestinationFinal());
            assertEquals(dto.getTypeMarchandise(), result.getTypeMarchandise());

            verify(trajetMap).toEntity(dto);
            verify(userRepository).findByEmail(email);
            verify(trajetRepository).save(trajetEntity);
            verify(trajetMap).toDTO(savedTrajet);
        }
    }
}
