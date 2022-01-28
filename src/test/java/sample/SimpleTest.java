package sample;

import org.junit.jupiter.api.Test;

/**
 * packageName : sample
 * fileName : SimpleTest
 * author : 윤신영
 * date : 2022-01-28
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-28   윤신영     최초 생성
 */
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

    }
}
