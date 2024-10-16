package fr.charly.mampuyaExam.entity.interfaces;


import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SluggerInterface {

    void setSlug(String slug);

    @JsonIgnore
    String getField();

}
