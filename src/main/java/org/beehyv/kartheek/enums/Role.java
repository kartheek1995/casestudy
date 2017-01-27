package org.beehyv.kartheek.enums;

public enum Role {
	USER("USER"),
    ADMIN("ADMIN");
     
    String role;
     
    private Role(String role){
        this.role = role;
    }
     
    public String getRole(){
        return role;
    }
}
