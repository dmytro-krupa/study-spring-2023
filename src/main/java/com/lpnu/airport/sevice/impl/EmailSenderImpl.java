package com.lpnu.airport.sevice.impl;

import com.lpnu.airport.sevice.EmailSender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSenderImpl implements EmailSender {
    @Override
    public void send() {
        try {
            Thread.sleep(6000);
        } catch (Exception e){}
        System.out.println("Email was sent");
    }
}

