package fr.charly.mampuyaExam.service.interfaces;

public interface ServiceUpdateInterface <T, ID, U> {

    T update(U o, ID id);

}
