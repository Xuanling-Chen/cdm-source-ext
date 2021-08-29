package cdm.legalagreement.csa.validation.exists;

import cdm.legalagreement.csa.PledgeeRepresentativeRider;
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

public class PledgeeRepresentativeRiderOnlyExistsValidator implements ValidatorWithArg<PledgeeRepresentativeRider, Set<String>> {

	@Override
	public <T2 extends PledgeeRepresentativeRider> ValidationResult<PledgeeRepresentativeRider> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("isApplicable", ExistenceChecker.isSet(o.getIsApplicable()))
				.put("party", ExistenceChecker.isSet(o.getParty()))
				.put("representativeTerms", ExistenceChecker.isSet(o.getRepresentativeTerms()))
				.put("representativeEvent", ExistenceChecker.isSet(o.getRepresentativeEvent()))
				.put("representativeEventTerms", ExistenceChecker.isSet(o.getRepresentativeEventTerms()))
				.put("representativeEndDate", ExistenceChecker.isSet(o.getRepresentativeEndDate()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("PledgeeRepresentativeRider", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("PledgeeRepresentativeRider", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
