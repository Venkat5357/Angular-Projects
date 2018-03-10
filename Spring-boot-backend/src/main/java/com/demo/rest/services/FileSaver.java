package com.demo.rest.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Collections;

@RestController
@Component
class FileResource {

    @GetMapping(path = "/api/text", produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<String> getFile() {
        String exportedContent = "Hello, World!";
        String filename = "my-file.txt";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccessControlExposeHeaders(Collections.singletonList("Content-Disposition"));
        headers.set("Content-Disposition", "attachment; filename=" + filename);
        return new ResponseEntity<>(exportedContent, headers, HttpStatus.OK);
    }



    @RequestMapping(value = "/api/pdf", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> downloadPDFFile()
            throws IOException {

        ClassPathResource file = new ClassPathResource("marriage.JPG");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setAccessControlExposeHeaders(Collections.singletonList("Content-Disposition"));
        headers.set("Content-Disposition", "filename=" + file.getFilename());
        headers.set("Access-Control-Allow-Headers", "Content-Type");
        headers.setContentLength(file.contentLength());

        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
                new InputStreamResource(file.getInputStream()), headers, HttpStatus.OK);


        return response;
    }


//    @RequestMapping(value = "/api/pdf", method = RequestMethod.GET, produces = "application/pdf")
//    public ResponseEntity<InputStreamResource> download(@PathVariable("fileName") String fileName) throws IOException {
//        System.out.println("Calling Download:- " + fileName);
//        ClassPathResource pdfFile = new ClassPathResource("sample.pdf");
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(APPLICATION_PDF);
//        headers.add("Access-Control-Allow-Origin", "*");
//        headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
//        headers.add("Access-Control-Allow-Headers", "Content-Type");
//        headers.add("Content-Disposition", "filename=" + pdfFile.getFilename());
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
//
//        headers.setContentLength(pdfFile.contentLength());
//        ResponseEntity<InputStreamResource> response = new ResponseEntity<InputStreamResource>(
//                new InputStreamResource(pdfFile.getInputStream()), headers, HttpStatus.OK);
//        return response;
//
//    }
}
