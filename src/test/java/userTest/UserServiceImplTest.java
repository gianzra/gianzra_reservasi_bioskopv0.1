package userTest;

import com.binar.app.model.User;
import com.binar.app.repository.UserRepository;
import com.binar.app.service.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userServiceImpl;


    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Mengambil Data Pengguna Tidak Dapat Ditemukan")
    void MockTestGetUserNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Mockito.verify(userServiceImpl.findById(Long.valueOf("NOT FOUND")));
        });
    }

    @Test
    @DisplayName("Mengambil Semua Data Pengguna Berhasil")
    void MockTestGetAllUserSuccess() {
        userServiceImpl.findAll();
        Mockito.verify(userRepository).findAll();
    }

    @Test
    @DisplayName("Membuat Pengguna Baru Berhasil")
    void MockTestcreateUser() {
        User userEntity = new User();
        userEntity.setId(Long.valueOf("1"));
        userEntity.setUsername("Gianzra");
        userEntity.setEmailAddress("gianzra@gmail.com");
        userEntity.setPassword("password");
        Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);
        Assertions.assertEquals(userEntity, userServiceImpl.create(userEntity));
    }

    @Test
    @DisplayName("Mengupdate Pengguna Berhasil")
    void MockTestUpdateUser() {
        User userEntity = new User();
        userEntity.setId((1L));
        userEntity.setUsername("Gianzra");
        userEntity.setEmailAddress("gianzra@gmail.com");
        userEntity.setPassword("password");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        Mockito.when(userRepository.save(userEntity)).thenReturn(userEntity);

        var actualValue = userServiceImpl.update(1L, userEntity);

        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Gianzra", actualValue.getUsername());
        Assertions.assertNotNull(actualValue);
    }

    @Test
    @DisplayName("Menghapus data pengguna Berhasil")
    void MockTestDeleteUser() {
        User userEntity = new User();
        userEntity.setId(Long.valueOf(1L));
        userEntity.setUsername("Gianzra");
        userEntity.setEmailAddress("gianzra@gmail.com");
        userEntity.setPassword("password");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        Mockito.doNothing().when(userRepository).deleteById(1L);
        userServiceImpl.delete(1L);
        Mockito.verify(userRepository).deleteById(1L);

    }

    @Test
    @DisplayName("Mengambil data pengguna ById")
    void MockTestGetById() {
        User userEntity = new User();
        userEntity.setId(Long.valueOf(1L));
        userEntity.setUsername("Gianzra");
        userEntity.setEmailAddress("gianzra@gmail.com");
        userEntity.setPassword("password");

        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));

        var actualValue = userServiceImpl.update(1L, userEntity);

        Assertions.assertEquals(1L, actualValue.getId());
        Assertions.assertEquals("Gianzra", actualValue.getUsername());
        Assertions.assertNotNull(actualValue);
    }
}

