package com.example.copsboot;
import com.example.copsboot.user.User;
import com.example.copsboot.user.UserRepository;
import com.example.copsboot.user.UserRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    public void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        User user = repository.save(new User(UUID.randomUUID(),
                "saadnasir31@gmail.com",
                "password",
                roles));
        assertThat(user).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }
}
