package com.techelevator.npgeek.model;

public class DayForecast {

private String parkcode;
private int fivedayforecastvalue;
private int low;
private int high;
private String forecast;
private boolean extrawater;
private boolean layers;
private boolean frigidtemperature;
//private boolean temperatureinFahrenheit;
private int lowInCelsius;
private int highInCelsius;

public int getLowInCelsius() {
	return lowInCelsius;
}

public void setLowInCelsius() {
	this.lowInCelsius = (this.low-32)*5/9;
}

public int getHighInCelsius() {
	return highInCelsius;
}

public void setHighInCelsius() {
	this.highInCelsius = (this.high-32)*5/9;
}


//public int getTemperatureInCelsius(int temperatureInFahrenheit) {
//	int temperatureInCelsius = (temperatureInFahrenheit-32)*5/9;
//	return temperatureInCelsius;
//}

//public boolean isTemperatureinFahrenheit() {
//    return temperatureinFahrenheit;
//}
//
//public void setTemperatureinFahrenheit() {
//    this.temperatureinFahrenheit = true;
//}



public boolean isFrigidtemperature() {
    return frigidtemperature;
}

public void setFrigidtemperature() {
    if(low <= 20) {
    this.frigidtemperature = true;
    }
    else {
        this.frigidtemperature = false;
    }
}

public boolean isLayers() {
    return layers;
}

public void setLayers() {
    if(high-low >= 20) {
        this.layers = true;
    }
    else {
        this.layers = false;
    }
}

public boolean isExtrawater() {
    return extrawater;
}

public void setExtrawater() {
    if(high >=75) {
        this.extrawater=true;
    }
    else this.extrawater=false;
}

public String getParkcode() {
    return parkcode;
}
public void setParkcode(String parkcode) {
    this.parkcode = parkcode;
}
public int getFivedayforecastvalue() {
    return fivedayforecastvalue;
}
public void setFivedayforecastvalue(int fivedayforecastvalue) {
    this.fivedayforecastvalue = fivedayforecastvalue;
}
public int getLow() {
    return low;
}
public void setLow(int low) {
    this.low = low;
}
public int getHigh() {
    return high;
}
public void setHigh(int high) {
    this.high = high;
}
public String getForecast() {
    return forecast;
}
public void setForecast(String forecast) {
    this.forecast = forecast;
}
}