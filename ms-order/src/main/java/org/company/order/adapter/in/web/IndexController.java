package org.company.order.adapter.in.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author EGASIMOV on 13/11/2021
 */

@RestController
@RequestMapping("/api")
public class IndexController {

    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        var content = String.format("Hey! it`s %s, running on %s profile", name, profile);
        return ResponseEntity.ok(content);
    }

}