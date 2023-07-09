package demopersons;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import lombok.Getter;
import lombok.Setter;

public class UserIntegrationTest {
	@Test
    public void givenAnnotatedUser_thenHasGettersAndSetters() {
        User user = new User();
        user.setFirstName("Alex");
        assertEquals(user.getFirstName(), "Alex");
    }

    @Getter @Setter
    class User {
        private String FirstName;
    }
}
