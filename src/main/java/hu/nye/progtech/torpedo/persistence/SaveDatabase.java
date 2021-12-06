package hu.nye.progtech.torpedo.persistence;

import hu.nye.progtech.torpedo.model.CharacterMap;

public interface SaveDatabase {
    void save(CharacterMap currentMap);

    CharacterMap load();
}
