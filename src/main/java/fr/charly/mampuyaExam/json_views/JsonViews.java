package fr.charly.mampuyaExam.json_views;

public class JsonViews {

    public interface UserShow{}


    public interface GameShow extends GameList, RoundShow{}
    public interface GameList{}

    public interface MapList{}
    public interface MapShow extends MapList{}


    public interface RoundShow{}
    public interface CoordinateShow{}

}
