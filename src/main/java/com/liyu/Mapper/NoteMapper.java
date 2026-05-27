package com.liyu.Mapper;

import com.liyu.Pojo.Note;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoteMapper {
    void CreateNote(Note note);
}
