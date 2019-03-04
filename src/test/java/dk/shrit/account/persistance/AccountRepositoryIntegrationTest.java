package dk.shrit.account.persistance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryIntegrationTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private AccountRepository repository;
 
    @Test
    public void whenFindByName_thenReturnAccount() {
        // given
        Account alex = new Account();
        alex.setName("axel");
        alex.setAccountStatus("enabled");
        entityManager.persistAndFlush(alex);
     
        // when
        Account found = repository.findByName(alex.getName());
     
        // then
        assertEquals(found.getName(), alex.getName());
    } 
}