package com.dmtool.dataAccessLayer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dmtool.interfaces.IEncounterPlayerCharacterDataAccessLayer;

@Service
@Component
public class EncounterPlayerCharacterDataAccess implements IEncounterPlayerCharacterDataAccessLayer {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Override
	public void insertEncounterPlayerCharacter(int encounterId, int characterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_encounterId", encounterId);
		params.put("p_characterId", characterId);

		// Execute stored procedure
		jdbcTemplate.update("{call Insert_Encounter_PlayerCharacter(:p_encounterId,:p_characterId)}", params);
	}

	@Override
	public void deleteEncounterPlayerCharacter(int encounterId, int characterId) {

		// Create parameter map for stored procedure call
		Map<String, Object> params = new HashMap<>();
		params.put("p_encounterId", encounterId);
		params.put("p_characterId", characterId);

		// Execute stored procedure
		jdbcTemplate.update("{call Delete_Encounter_PlayerCharacter_ByIds(:p_encounterId,:p_characterId)}", params);
	}
}
