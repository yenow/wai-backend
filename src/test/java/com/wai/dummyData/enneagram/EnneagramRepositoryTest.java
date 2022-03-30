package com.wai.dummyData.enneagram;

import com.wai.domain.enneagram.Enneagram;
import com.wai.domain.enneagram.EnneagramRepository;
import com.wai.domain.wiseSaying.WiseSaying;
import com.wai.domain.wiseSaying.WiseSayingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@ActiveProfiles("test")
public class EnneagramRepositoryTest {

    @Autowired
    private EnneagramRepository enneagramRepository;
//    @Autowired
//    private WiseSayingRepository wiseSayingRepository;

    @BeforeEach
    void beforeEach() {
        enneagramRepository.deleteAll();
//        wiseSayingRepository.deleteAll();
    }

    @Test
    void insertData() {
        Enneagram type1 = Enneagram.builder()
                .enneagramType(1)
                .animalName("소")
                .imagePath("assets/images/enneagram/cow.png")
                .subName("개혁가")
                .simpleExplain("이상적이고 이상적인 유형")
                .simpleExplain2("원칙적이고, 목표가 분명하며, 자신을 잘 통제하고, 완벽주의 기질이 있다.")
                .build();
        enneagramRepository.save(type1);

        List<WiseSaying> type1_list = new ArrayList<>();
        type1_list.add(WiseSaying.builder()
                .author("간디")
                .wiseSaying("나는 고통스러운 경험을 통해서 한가지 교훈을 얻었다. 즉 분노를 억제하면 그것은 에너지로 바뀌고, 그 에너지는 힘으로 변환되어서 세상을 움직일 수 있다는 것이다.")
                .build());
        type1_list.add(WiseSaying.builder()
                .author("잭 콘필드")
                .wiseSaying("깨어나지 않은 마음은 만물을 그대로 내버려 두지 않고 사사건건 저항한다.")
                .build());
//
//        type1_list.forEach((wiseSaying) -> {
//            wiseSayingRepository.save(wiseSaying);
//        });

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(2)
                .animalName("강아지")
                .imagePath("assets/images/enneagram/dog.png")
                .subName("돕는 사람")
                .simpleExplain("사람들을 잘 돌보고 그들과 교류하기를 즐기는 유형")
                .simpleExplain2("자신의 감정을 잘 드러내며, 사람들을 즐겁게 해 주고, 관대하며, 소유욕이 강하다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(3)
                .animalName("독수리")
                .imagePath("assets/images/enneagram/eagle.png")
                .subName("성취하는 사람")
                .simpleExplain("성공지향적이며 실용적인 유형")
                .simpleExplain2("적응을 잘하고, 뛰어나며, 자신의 이미지에 관심이 많다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(4)
                .animalName("고양이")
                .imagePath("assets/images/enneagram/cat.png")
                .subName("예술가")
                .simpleExplain("민감하며 안으로 움츠러드는 유형")
                .simpleExplain2("표현력이 있고, 극적이며, 자기 내면에 빠져 있으며, 변덕스럽다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(5)
                .animalName("부엉이")
                .imagePath("assets/images/enneagram/owl.png")
                .subName("탐구자")
                .simpleExplain("이성적이고 지혜가 있는 유형")
                .simpleExplain2("지각력이 있고, 창의적이며, 혼자 있기를 좋아하고, 마음을 잘 드러내지 않는다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(6)
                .animalName("사슴")
                .imagePath("assets/images/enneagram/deer.png")
                .subName("충실한 사람")
                .simpleExplain("충실하고 안전을 추구하는 유형")
                .simpleExplain2("책임감이 있고, 의심과 불안이 많으며, 사람들에게 맞추려고 한다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(7)
                .animalName("원숭이")
                .imagePath("assets/images/enneagram/monkey.png")
                .subName("열정적인 사람")
                .simpleExplain("늘 분주하며 재미를 추구하는 유형")
                .simpleExplain2("즉흥적이고, 변덕스러우며, 욕심이 많고, 산만하다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(8)
                .animalName("호랑이")
                .imagePath("assets/images/enneagram/tiger.png")
                .subName("도전하는 사람")
                .simpleExplain("힘이 있으며 남을 지배하는 유형")
                .simpleExplain2("자신감이 있고, 결단력이 있으며, 고집스럽고, 사람들과 맞서기를 좋아한다.")
                .build());

        enneagramRepository.save(Enneagram.builder()
                .enneagramType(9)
                .animalName("코끼리")
                .imagePath("assets/images/enneagram/elephant.png")
                .subName("평화주의자")
                .simpleExplain("느긋하며 남들 앞에 나서지 않는 유형")
                .simpleExplain2("수용적이며, 자족적이고, 남에게 쉽게 동의하며 위안을 준다.")
                .build());
    }
}
