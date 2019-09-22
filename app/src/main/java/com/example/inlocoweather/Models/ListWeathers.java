package com.example.inlocoweather.Models;

import java.util.ArrayList;

public class ListWeathers {
    private String message;
    private int cod;
    private ArrayList<WeatherResponse> list;

    @Override
    public String toString() {
        return "ListWeathers{" +
                "message='" + message + '\'' +
                ", cod=" + cod +
                ", list=" + list +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public ArrayList<WeatherResponse> getList() {
        return list;
    }

    public void setList(ArrayList<WeatherResponse> list) {
        this.list = list;
    }
}
