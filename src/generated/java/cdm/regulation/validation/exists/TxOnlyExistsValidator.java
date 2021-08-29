package cdm.regulation.validation.exists;

import cdm.regulation.Tx;
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

public class TxOnlyExistsValidator implements ValidatorWithArg<Tx, Set<String>> {

	@Override
	public <T2 extends Tx> ValidationResult<Tx> validate(RosettaPath path, T2 o, Set<String> fields) {
		Map<String, Boolean> fieldExistenceMap = ImmutableMap.<String, Boolean>builder()
				.put("newTx", ExistenceChecker.isSet(o.getNewTx()))
				.put("tradDt", ExistenceChecker.isSet(o.getTradDt()))
				.put("tradgCpcty", ExistenceChecker.isSet(o.getTradgCpcty()))
				.put("qty", ExistenceChecker.isSet(o.getQty()))
				.put("pric", ExistenceChecker.isSet(o.getPric()))
				.put("tradVn", ExistenceChecker.isSet(o.getTradVn()))
				.put("ctryOfBrnch", ExistenceChecker.isSet(o.getCtryOfBrnch()))
				.build();
		
		// Find the fields that are set
		Set<String> setFields = fieldExistenceMap.entrySet().stream()
				.filter(Map.Entry::getValue)
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		
		if (setFields.equals(fields)) {
			return success("Tx", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "");
		}
		return failure("Tx", ValidationType.ONLY_EXISTS, o.getClass().getSimpleName(), path, "",
				String.format("[%s] should only be set.  Set fields: %s", fields, setFields));
	}
}
