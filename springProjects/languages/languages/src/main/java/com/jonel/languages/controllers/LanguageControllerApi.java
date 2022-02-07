//package com.jonel.languages.controllers;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.jonel.languages.models.Language;
//import com.jonel.languages.services.LanguageService;
//
//
//@RestController
//public class LanguageControllerApi {
// private final LanguageService languageService;
// public LanguageControllerApi(LanguageService languageService){
//     this.languageService = languageService;
// }
//
// @RequestMapping(value="/languages/delete/{id}", method=RequestMethod.DELETE)
// public void destroy(@PathVariable("id") Long id) {
//     languageService.delete(id);
// }
//}
