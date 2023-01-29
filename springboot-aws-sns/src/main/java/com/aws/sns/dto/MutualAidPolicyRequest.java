package com.aws.sns.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MutualAidPolicyRequest {
	private Long userId;
	private Long applicationId;
	private Long productId;
	private Long groupId;
	private Boolean isCorporate;
	private Long partnerId;

}