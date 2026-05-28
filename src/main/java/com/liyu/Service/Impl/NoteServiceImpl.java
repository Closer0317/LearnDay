package com.liyu.Service.Impl;

import com.liyu.Mapper.NoteMapper;
import com.liyu.Pojo.Note;
import com.liyu.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteMapper noteMapper;

    @Override
    public Note QueryNoteById(String id) {
        return noteMapper.QueryNoteById(id);
    }

    @Override
    public void CreateNote(Note note) {
        noteMapper.CreateNote(note);
    }

    @Override
    public void ModifyNote(Note note) {
        noteMapper.ModifyNote(note);
    }

    @Override
    public void DeleteNote(String id) {
        noteMapper.DeleteNote(id);
    }

}
