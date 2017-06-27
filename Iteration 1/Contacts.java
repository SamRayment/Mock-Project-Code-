public class Contacts   
{

    private String title;
    private String forename;
    private String surname;
    private String email;
    private String mobilePhone;
    private String address1;
    private String address2;
    private String townOrCity;
    private String county;
    private String postcode;
    //constructor method 
    public Contacts (String title, String forename, String surname, String email, String mobilePhone, String address1, String address2, String townOrCity,  String county, String postcode) 
    {        
        this.title = title;
        this.forename = forename;
        this.surname = surname;
        this.email = email;
        this.mobilePhone = mobilePhone;
        this.address1 = address1;
        this.address2 = address2;
        this.townOrCity = townOrCity;
        this.county = county;
        this.postcode = postcode;
    }

    //override the toString() method, if you don't have this when outputting you get a reference to the object
    // not the values of the object
    @Override   
    public String toString() 
    {
        return this.title + ", " +   this.forename + ", " + this.surname + ", " +   this.email + ", " + this.mobilePhone + ", " +   this.address1 + ", " +   this.address2 + ", " + this.townOrCity + ", " +   this.county + ", " + this.postcode ;
    }

    //methods - getters and setters

    public String getTitle() {return title;}

    public String getForname() {return forename;}
    
    public String getSurname() {return surname;}
    
    public String getEmail() {return email;}
    
    public String getMobilePhone() {return mobilePhone;}
    
    public String getAddress1() {return address1;}
    
    public String getAddress2() {return address2;}
    
    public String getTownOrCity() {return townOrCity;}
    
    public String getCounty() {return county;}
    
    public String getPostcode() {return postcode;}

    //this keyword highlights that the attribute is being assigned to rather than the parameter being assigned to itself
    public void setTitle(String title) {this.title = title;}

    public void setForname(String forname) {this.forename = forname;}

    public void setSurname(String surname) {this.county = surname;}
    
    public void setEmail(String email) {this.email = email;}
    
    public void setMobilePhone(String mobilePhone) {this.mobilePhone = mobilePhone;}
    
    public void setAddress1(String address1) {this.address1 = address1;}
    
    public void setAddress2(String address2) {this.address2 = address2;}
    
    public void setTownOrCity(String townOrCity) {this.townOrCity = townOrCity;}
    
    public void setCounty(String county) {this.county = county;}
    
    public void setPostcode(String postcode) {this.postcode = postcode;}
}