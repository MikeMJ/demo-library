package com.mikola.demolibrary.controller;

import com.mikola.demolibrary.exceptions.NoSuchBookException;
import com.mikola.demolibrary.model.Book;
import com.mikola.demolibrary.response.Response;
import com.mikola.demolibrary.response.ResponseCode;
import com.mikola.demolibrary.service.ViewerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Mikola on  Sep 10, 2018
 */

@RestController
@Validated
public class ViewerController {

    private static final Logger logger = LoggerFactory.getLogger(ViewerController.class);
    private ViewerService viewerService;

    @Autowired
    public ViewerController(ViewerService viewerService) {
        this.viewerService = viewerService;
    }

    //We're expecting page number to be bigger than zero as it's more intuitive.
    @RequestMapping(value = "list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBooksList(@RequestParam(value = "filter", required = false, defaultValue = "") String filter,
                                 @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        logger.debug("Request received to list books with filter:{}, page:{} and size:{}", filter, page, size);
        if (page < 1)
            page = 1;
        Page<Book> books = viewerService.listBooks(filter, page-1, size);
        logger.info("{} books retrieved for filter:{}", books.getTotalElements(), filter);
        return new Response(ResponseCode.Ok.getCode(), "OK", books);
    }

    @RequestMapping(value = "details/{bookid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getBookDetails(@PathVariable("bookid") Long bookId) throws NoSuchBookException {
        logger.debug("Request received to show book details for {}", bookId);
        Book book = viewerService.showBookDetails(bookId);
        logger.info("Book details: {}", book);
        return new Response(ResponseCode.Ok.getCode(), "OK", book);
    }
}
