package com.mikola.demolibrary;

import com.mikola.demolibrary.dao.BookRepository;
import com.mikola.demolibrary.dao.ReservationRepository;
import com.mikola.demolibrary.dao.UserRepository;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.model.Reservation;
import com.mikola.demolibrary.model.User;
import com.mikola.demolibrary.service.ViewerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoLibraryApplication implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ViewerService viewerService;

    public static void main(String[] args) {
        SpringApplication.run(DemoLibraryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
