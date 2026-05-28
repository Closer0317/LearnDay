package com.liyu.Controller;

import com.liyu.Pojo.Note;
import com.liyu.Pojo.Result;
import com.liyu.Service.NoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/query")
    public Result QueryNoteById(String id){
        noteService.QueryNoteById(id);
        log.info("查询笔记");
        return Result.success(noteService.QueryNoteById(id));
    }
    @PostMapping("/modify")
    public Result ModifyNote(@RequestBody Note note){
        log.info("修改笔记");
        noteService.ModifyNote(note);
        return Result.success();
    }

    @DeleteMapping
    public Result DeleteNote(String id){
        log.info("删除笔记");
        noteService.DeleteNote(id);
        return Result.success();
    }

}
