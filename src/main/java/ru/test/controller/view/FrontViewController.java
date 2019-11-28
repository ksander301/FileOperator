package ru.test.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.test.logic.HomeDirService;
import ru.test.model.entity.UploadFileResponse;

import java.io.IOException;
import java.util.List;

@Controller
public class FrontViewController {

    @Autowired
    private HomeDirService homeDirService;

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("message", "Make your choice...");
        return "index";
    }

    @GetMapping("/fileList")
    public String fileList(Model model) throws IOException {
        model.addAttribute("files", this.homeDirService.getHomeDirContent());
        model.addAttribute("path", "/files/get/");
        return "fileList";
    }

    @GetMapping("/fileUpload")
    public String fileUpload(Model model) {
        return "fileUpload";
    }

    @PostMapping("/resultUpload")
    public String resultUpload(@RequestParam("files") MultipartFile[] files, Model model) {
        model.addAttribute("updList", this.homeDirService.storeMultiFiles(files));
        return "/resultUpload";
    }
}

