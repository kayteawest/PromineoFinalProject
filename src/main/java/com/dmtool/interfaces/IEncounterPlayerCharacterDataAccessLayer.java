package com.dmtool.interfaces;

public interface IEncounterPlayerCharacterDataAccessLayer {

	void insertEncounterPlayerCharacter(int encounterId, int characterId);

	void deleteEncounterPlayerCharacter(int encounterId, int characterId);

}
