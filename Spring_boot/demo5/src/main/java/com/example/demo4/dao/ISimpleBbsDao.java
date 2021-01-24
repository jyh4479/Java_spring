package com.example.demo4.dao;

import com.example.demo4.dto.SimpleBbsDto;
import java.util.List;

public interface ISimpleBbsDao {

    public List<SimpleBbsDto> listDao();
    public SimpleBbsDto viewDao(String id);
    public int writeDao(String writer, String title, String content);
    public int deleteDao(String id);
}
