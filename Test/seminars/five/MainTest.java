package seminars.five;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import seminars.five.number.MaxNumberModule;
import seminars.five.number.RandomNumberModule;
import seminars.five.user.UserRepository;
import seminars.five.user.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MainTest {
    //5.1.
    @Test
    void maxNumberModuleTest(){
        MaxNumberModule maxNumberModule = new MaxNumberModule();
        List<Integer> list = new ArrayList<>(Arrays.asList(30, 50, 60, 7, 4, 0));
        int res = maxNumberModule.findMaxNumber(list);

        Assertions.assertEquals(60, res);

    }

    @Test
    void randomNumberModuleTest(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        List<Integer> res = randomNumberModule.generateList(7);

        Assertions.assertEquals(7, res.size());
    }

    @Test
    void integrationTest1(){
        RandomNumberModule randomNumberModule = new RandomNumberModule();
        MaxNumberModule maxNumberModule = new MaxNumberModule();

        List<Integer> list = randomNumberModule.generateList(7);
        int res = maxNumberModule.findMaxNumber(list);

        Assertions.assertEquals(Collections.max(list), res);

    }
    //5.2.
    @ParameterizedTest
    @ValueSource(ints = {1, 5})
    void integrationTest2(int id){
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        String res = userService.getUserName(id);

        Assertions.assertEquals("User " + id, res);
    }
    //5.3.
}