package se.yrgo.budgetplanner;

import org.junit.Test;
import se.yrgo.budgetplanner.model.user.User;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class UserTest {
    final LocalDate DATE = LocalDate.now();

    @Test
    public void TestIfUsersWithTheSameMailAndPasswordAreConsideredTheSame(){
        User user1 = new User("anders@abc.com", "password", DATE,DATE);
        User user2 = new User("anders@abc.com", "password", DATE,DATE);
        assertTrue("",user1.equals(user2));
    }
}
