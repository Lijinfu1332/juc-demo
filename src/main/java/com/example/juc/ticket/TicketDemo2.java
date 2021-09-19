package com.example.juc.ticket;



public class TicketDemo2 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        new Thread(()->{for (int i = 0; i <= 30; i--) {ticket.sale(); }},"AA").start();
        new Thread(()->{for (int i = 0; i <= 30; i--) {ticket.sale(); }},"BB").start();
        new Thread(()->{for (int i = 0; i <= 30; i--) {ticket.sale(); }},"CC").start();
    }
}

