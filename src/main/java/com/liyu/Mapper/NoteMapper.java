package com.liyu.Mapper;

import com.liyu.Pojo.Note;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteMapper {
    void CreateNote(Note note);

    void ModifyNote(Note note);

    Note QueryNoteById(String id);

    void DeleteNote(String id);
}
