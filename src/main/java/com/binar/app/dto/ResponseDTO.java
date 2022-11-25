package com.binar.app.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseDTO<T> {

    private boolean status;
    private List<String> messasges = new ArrayList<>();
    private T payload;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getMessasges() {
        return messasges;
    }

    public void setMessasges(List<String> messasges) {
        this.messasges = messasges;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }
}
