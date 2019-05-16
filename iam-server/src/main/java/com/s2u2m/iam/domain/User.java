package com.s2u2m.iam.domain;

import com.s2u2m.iam.constant.GenderEnum;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Builder
@Getter
public class User {
    private String uid;
    private String nickName;
    private String password;
    private GenderEnum gender;
    private Instant birthday;
}
