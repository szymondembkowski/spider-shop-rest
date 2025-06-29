package spidershop.Tests;

import com.spidershop.Dto.RegisterRequest;
import com.spidershop.Entity.User;
import com.spidershop.Repository.UserRepository;
import com.spidershop.Services.AuthService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AuthenticationManager authenticationManager;

    @InjectMocks
    private AuthService authService;

    @Test
    void register_shouldSaveUserWithEncodedPassword() {
        RegisterRequest request = new RegisterRequest("user", "pass");

        when(passwordEncoder.encode("pass")).thenReturn("hashedPass");

        authService.register(request);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).save(userCaptor.capture());
        assertEquals("user", userCaptor.getValue().getUsername());
        assertEquals("hashedPass", userCaptor.getValue().getPassword());
    }
}
