package com.example.microservice.entity;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.io.IOException;
import java.time.LocalDateTime;

@Component

public class Request {

    private long id;

    private String time_sent;

    private String address;

    private long transactions;



    public Request(String addr) throws IOException {
        this.address = addr;
        this.transactions = this.getNumberOfTransactions();
        this.time_sent = LocalDateTime.now().toString();
    }

    public Request() {}

    private long getNumberOfTransactions() throws IOException {
        Document doc = Jsoup.connect("https://etherscan.io/txs?a=" + this.address).get();
        Element content = doc.getElementById("ContentPlaceHolder1_topPageDiv");
        assert content != null;
        String[] splitted = content.text().split(" ");
        return Integer.parseInt(splitted[3].replaceAll(",", ""));
    }


    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTransactions() {
        return transactions;
    }

    public void setTransactions(long transactions) {
        this.transactions = transactions;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime_sent() {
        return time_sent;
    }

    public void setTime_sent(String time_sent) {
        this.time_sent = time_sent;
    }



}
