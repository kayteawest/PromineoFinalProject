package com.dmtool.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dmtool.interfaces.IEncounterPlayerCharacterDataAccessLayer;
import com.dmtool.interfaces.IEncountersController;
import com.dmtool.interfaces.IEncountersDataAccessLayer;
import com.dmtool.models.CreateEncounterRequest;
import com.dmtool.models.Encounter;

@RestController
public class EncountersController implements IEncountersController {

	@Autowired
	private IEncountersDataAccessLayer encountersDataAccess;

	@Autowired
	private IEncounterPlayerCharacterDataAccessLayer encounterPlayerCharacterDataAccess;

	@Override
	public int createEncounter(CreateEncounterRequest createEncounterRequest) {

		var encounterId = encountersDataAccess.insertEncounter(createEncounterRequest.getCampaignId());

		var characterIds = createEncounterRequest.getPlayerCharacterIds();

		if (characterIds != null) {

			for (Integer id : characterIds) {

				addPlayerCharacter(encounterId, id);

			}

		}

		return encounterId;
	}

	@Override
	public Encounter getEncounter(int encounterId) {

		return encountersDataAccess.selectEncounterById(encounterId);

	}

	@Override
	public void addPlayerCharacter(int encounterId, int playerCharacterId) {

		encounterPlayerCharacterDataAccess.insertEncounterPlayerCharacter(encounterId, playerCharacterId);

	}

	@Override
	public void removePlayerCharacter(int encounterId, int playerCharacterId) {

		encounterPlayerCharacterDataAccess.deleteEncounterPlayerCharacter(encounterId, playerCharacterId);

	}

	@Override
	public void deleteEncounter(int encounterId) {

		encountersDataAccess.deleteEncounterById(encounterId);

	}

}
