package cdm.base.staticdata.party.validation.exists;

import cdm.base.staticdata.party.AncillaryParty;
import com.google.common.collect.ImmutableMap;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ExistenceChecker;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import static com.rosetta.model.lib.validation.ValidationResult.failure;
import static com.rosetta.model.lib.validation.ValidationResult.success;

public class AncillaryPartyOnlyExistsValidator implements ValidatorWithArg<AncillaryParty, Set<String>> {

	@Override
	public <T2 extends AncillaryParty> ValidationResult<AncillaryParty> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("role", ExistenceChecker.isSet(o.getRole()))
				.put("partyReference", ExistenceChecker.isSet(o.getPartyReference()))
				.put("onBehalfOf", ExistenceChecker.isSet(o.getOnBehalfOf()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("AncillaryParty", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("AncillaryParty", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
