package com.ispan.eeit69.DTO;

public class UserDTO {
	private String invitationCode;
	private String username;
    private String password;
    
	    public UserDTO() {}

		public UserDTO(String invitationCode, String username, String password, String password2) {
			super();
			this.invitationCode = invitationCode;
			this.username = username;
			this.password = password;
		}

		public String getInvitationCode() {
			return invitationCode;
		}

		public void setInvitationCode(String invitationCode) {
			this.invitationCode = invitationCode;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

}