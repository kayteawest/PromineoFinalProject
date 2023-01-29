package com.dmtool.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dmtool.models.Campaign;
import com.dmtool.models.CreateCampaignRequest;
import com.dmtool.models.UpdateCampaignRequest;

@RequestMapping("/campaigns")
public interface ICampaignsController {

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	int createCampaign(@RequestBody CreateCampaignRequest createCampaignRequest);

	@GetMapping("/{campaignId}")
	@ResponseStatus(code = HttpStatus.OK)
	Campaign getCampaign(@PathVariable int campaignId);

	@PatchMapping("/{campaignId}")
	@ResponseStatus(code = HttpStatus.OK)
	void updateCampaign(@PathVariable int campaignId, @RequestBody UpdateCampaignRequest updateCampaignRequest);

	@DeleteMapping("/{campaignId}")
	@ResponseStatus(code = HttpStatus.OK)
	void deleteCampaign(@PathVariable int campaignId);

}
