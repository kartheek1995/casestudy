package org.beehyv.kartheek.enums;

public enum AddressType {
	HOME("HOME"),
    OFFICE("OFFICE"),
    OTHER("OTHER");
	
    String addressType;
     
    private AddressType(String addressType){
        this.addressType = addressType;
    }
     
    public String getaddressType(){
        return addressType;
    }
}
