package com.example.spring5.restservices;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookmarks.Account;
import bookmarks.AccountRepository;
import bookmarks.Bookmark;
import bookmarks.BookmarkRepository;

@SpringBootApplication
public class RestservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestservicesApplication.class, args);
	}

	@Bean
	CommandLineRunner init(AccountRepository accountRepository, BookmarkRepository bookmarkRepository) {
		return (evt) -> Arrays.asList("kvaysse,siwata,cstrife,mmario".split(",")).forEach(a -> {
			Account account = accountRepository.save(new Account("password", a));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/1/" + a, "A desccription"));
			bookmarkRepository.save(new Bookmark(account, "http://bookmark.com/2/" + a, "A desccription"));
		});

	}
}
