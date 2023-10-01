package com.example.MovieTheaterAPI.booking;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.MovieTheaterAPI.user.User;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "booking")
public class Booking {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "user")
  private User user;

  @Column(name = "showtime", nullable = false)
  private Showtime showtime;

  @Column(name = "seats", nullable = false)
  private int[] seats;

  @Column(name = "booking-date", nullable = false)
  private DateTimeFormat bookingDate;

  @Column(name = "total-paid", nullable = false)
  private double totalPaid;

  @Column(name = "status", nullable = false)
  private String status;
}
