package com.liyu.Service;

import com.liyu.Pojo.Note;

public interface NoteService {


    //查询笔记
    Note QueryNoteById(String id);

    //创建笔记
    void CreateNote(Note note);

    void ModifyNote(Note note);

    void DeleteNote(String id);
}
