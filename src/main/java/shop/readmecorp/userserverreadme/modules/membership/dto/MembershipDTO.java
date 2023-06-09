package shop.readmecorp.userserverreadme.modules.membership.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDTO {

    private Integer id;

    private String membershipName;

    private Integer price;

    private String membershipTerm;

}
