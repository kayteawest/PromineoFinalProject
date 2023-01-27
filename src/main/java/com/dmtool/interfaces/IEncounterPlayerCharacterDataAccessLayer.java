package com.dmtool.interfaces;

public interface IEncounterPlayerCharacterDataAccessLayer {
	
	  int insertEncounterPlayerCharacter(int encounterId, int characterId);
	  void deleteEncounterPlayerCharacter(int encounterId, int characterId);

}
