package backend;

import java.util.Date;

public class members {
    private String firstName;
    private String lastName;
    private String membershipType;
    private Integer id;
    private String address;
    private Date renwalDate;
    private Integer creditCard;

    public members(String firstName, String lastName, String membershipType, Integer id, String address,
                   Date renwalDate, Integer creditCard){
        this.firstName      = firstName;
        this.lastName       = lastName;
        this.membershipType = membershipType;
        this.id             = id;
        this.address        = address;
        this.renwalDate     = renwalDate;
        this.creditCard     = creditCard;
    }
    public String getName(){
        return firstName + lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMembershipType(){
        return membershipType;
    }
    public String getAddress(){
        return address;
    }
    public Integer getId(){
        return id;
    }
    public Integer getCreditCard(){
        return creditCard;
    }
    public Date getRenwalDate(){
        return  renwalDate;
    }

    //Need to do checking in all of these if possible
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setMembershipType(String membershipType){
        this.membershipType = membershipType;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public void setId(Integer id){
        this.id = id;
    }
    public void setRenwalDate(Date renwalDate){
        this.renwalDate = renwalDate;
    }
    public void setCreditCard(Integer creditCard){
        this.creditCard = creditCard;
    }

    public Integer searchID(){
        //catch exception if id can't be found
        return 123;
    }
}
