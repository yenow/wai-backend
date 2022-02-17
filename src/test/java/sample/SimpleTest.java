package sample;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class SimpleTest {

    @Test
    void splitTest() {
        String str = "abc|def|ghi|jkl";

//        for(String temp : str.split("|")) {
//            System.out.println(temp);
//        }

        for(String temp : str.split("\\|")) {
            System.out.println(temp);
        }

//        System.out.println(globalPropertySource.getDriverClassName());
//        System.out.println(globalPropertySource.getPassword());
//        System.out.println(globalPropertySource.getUsername());

    }
}
