package com.dmtool.interfaces;

import com.dmtool.models.Encounter;

public interface IEncountersDataAccessLayer {

	int insertEncounter(int campaignId);

	Encounter selectEncounterById(int encounterId);

	void deleteEncounterById(int encounterId);

}
