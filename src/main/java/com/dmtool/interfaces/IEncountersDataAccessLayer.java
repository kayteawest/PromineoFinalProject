package com.dmtool.interfaces;

import com.dmtool.models.Encounters;

public interface IEncountersDataAccessLayer {
	
	int insertEncounter();
	Encounters selectEncounterById(int encounterId);
	void deleteEncounterById(int encounterId);

}
