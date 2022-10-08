package com.demo.testHelidon.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Data
@Entity
@Table(name="TB_M_APPLICANT_TYPE")
@org.hibernate.annotations.NamedNativeQuery(name = "findAll",
        query = "select * from TB_M_APPLICANT_TYPE", resultClass = TbMApplicationType.class)
public class TbMApplicationType extends BaseEntity {
    @Id
    @Column(name="APPLICANT_TYPE")
    private String applicantType;

    @Column(name="APPLICANT_TYPE_NAME")
    private String applicantTypeName;

    @Column(name="HP_CUSTOMER_TYPE")
    private String phCustomerType;

}

