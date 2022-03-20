package com.wai.controller.user;

import com.wai.common.exception.user.UserKeyNotExistException;
import com.wai.controller.UserApiController;
import com.wai.service.user.UserService;
import com.wai.service.user.UserServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(UserApiController.class)
@MockBean(JpaMetamodelMappingContext.class)
class UserApiControllerTest {

    @MockBean
    private UserService userService;
    @Autowired
    private UserServiceUtil userServiceUtil;

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders
                .standaloneSetup(new UserApiController(userService, userServiceUtil))
                .addFilters(new CharacterEncodingFilter("UTF-8", true)) // utf-8 필터 추가
                .build();
    }

    @Test
    void saveUserKey() throws Exception {
        // given
        given(userService.saveUserKey(UUID.randomUUID().toString())).willReturn(1L);
        given(userService.saveUserKey("")).willThrow(new UserKeyNotExistException());

        // when
        final ResultActions actions = mvc.perform(
                post("/api/saveUserKey")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content("")
        );


        // then
        actions.andExpect(status().isBadRequest());
    }
}