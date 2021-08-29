package cdm.product.common.schedule.validation.exists;

import cdm.product.common.schedule.FinalCalculationPeriodDateAdjustment;
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

public class FinalCalculationPeriodDateAdjustmentOnlyExistsValidator implements ValidatorWithArg<FinalCalculationPeriodDateAdjustment, Set<String>> {

	@Override
	public <T2 extends FinalCalculationPeriodDateAdjustment> ValidationResult<FinalCalculationPeriodDateAdjustment> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("relevantUnderlyingDateReference", ExistenceChecker.isSet(o.getRelevantUnderlyingDateReference()))
				.put("swapStreamReference", ExistenceChecker.isSet(o.getSwapStreamReference()))
				.put("businessDayConvention", ExistenceChecker.isSet(o.getBusinessDayConvention()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("FinalCalculationPeriodDateAdjustment", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("FinalCalculationPeriodDateAdjustment", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
