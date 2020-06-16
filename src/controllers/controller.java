package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.Map;

@Controller
public class controller {
    @GetMapping("/search")
    public String search() {
        return "form_search";

    }
    @GetMapping("/result")
    public String result(@RequestParam String english, Model model, String VN) {
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("goodbye", "tam biet");
        dictionary.put("book", "sach");
        dictionary.put("pc", "my tinh ca nhan");

        for (String key : dictionary.keySet()) {
            if (english.equals(key)) {
                VN = dictionary.get(key);
                model.addAttribute("vn", VN);
                model.addAttribute("english", english);
                return "meaning_result";
            }
        }
        return null;
    }

}
