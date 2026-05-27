package com.liyu.Controller;

import com.liyu.Pojo.Note;
import com.liyu.Pojo.Result;
import com.liyu.Service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/note")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("/create")
    public Result CreateNote(@RequestBody Note note){
        log.info("创建笔记");
        noteService.CreateNote(note);
        return Result.success();
    }

}
