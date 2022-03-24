package sample;

import com.wai.domain.fileUpload.FileType;
import org.junit.jupiter.api.Test;


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

    @Test
    void enumTest() {
        FileType t1 = FileType.valueOf("image");
//        FileType t2 = FileType.valueOf("image1");
        FileType t3 = FileType.valueOf("");
        System.out.println(t1);
//        System.out.println(t2);
        System.out.println(t3);

    }
}
