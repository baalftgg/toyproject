package com.example.project_toy.product.dto;

import lombok.*;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDTO {

    @NotNull
    private String memberId;

    @NotNull
    @Id
    private String memberName;

    @NotNull
    private String memberMail;

    @NotNull
    private Date memberRegdate;

    @NotNull
    private String memberGrade;
}
