package com.ayushi.BlogApplication.payloads;

import lombok.Data;

@Data
public class UserDto {
	
	private String userName;
	private String userEmail;
	private String userpassword;
	private String userAbout;

}
