package fr.charly.mampuyaExam.service.interfaces;

public interface ServiceInterface <T, ID, C>  {

    T create(C o);

   // T update(U o, ID id);

  //  Boolean delete(ID id);

    T findOneById(ID id);

}
