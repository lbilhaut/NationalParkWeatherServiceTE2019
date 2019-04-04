package com.techelevator.npgeek.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {
private Long surveyId;

@NotBlank(message="You need to pick a park!")
private String parkCode;

@NotBlank(message="Email can't be blank")
@Email(message="Email must be a valid email address")
@Size(max=100, message="Email can't be over 100 characters")
private String emailAddress;

@NotBlank(message="state can't be blank")
@Size(max=30, message="State can't be over 30 characters")
private String state;

@NotBlank(message="You need to choose an activity level")
private String activityLevel;

public Long getSurveyId() {
    return surveyId;
}
public void setSurveyId(Long surveyId) {
    this.surveyId = surveyId;
}
public String getParkCode() {
    return parkCode;
}
public void setParkCode(String parkCode) {
    this.parkCode = parkCode;
}
public String getEmailAddress() {
    return emailAddress;
}
public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
}
public String getState() {
    return state;
}
public void setState(String state) {
    this.state = state;
}
public String getActivityLevel() {
    return activityLevel;
}
public void setActivityLevel(String activityLevel) {
    this.activityLevel = activityLevel;
}
}
