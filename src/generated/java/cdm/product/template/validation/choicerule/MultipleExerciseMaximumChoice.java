package cdm.product.template.validation.choicerule;

import cdm.product.template.MultipleExercise;
import com.rosetta.model.lib.annotations.RosettaChoiceRule;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleFailure;
import com.rosetta.model.lib.validation.ValidationResult.ChoiceRuleValidationMethod;
import com.rosetta.model.lib.validation.ValidationResult.ValidationType;
import com.rosetta.model.lib.validation.Validator;
import java.util.LinkedList;
import java.util.List;

import static com.rosetta.model.lib.validation.ExistenceChecker.isSet;
import static com.rosetta.model.lib.validation.ValidationResult.success;
import static java.util.Arrays.asList;

/**
 * @version ${project.version}
 */
@RosettaChoiceRule("MultipleExerciseMaximumChoice")
public class MultipleExerciseMaximumChoice implements Validator<MultipleExercise> {
	
	private static final String NAME = "MultipleExerciseMaximumChoice";
	
	@Override
	public ValidationResult<MultipleExercise> validate(RosettaPath path, MultipleExercise object) {
		List<String> choiceFieldNames = asList("maximumNotionalAmount", "maximumNumberOfOptions");
		List<String> populatedFieldNames = new LinkedList<>();
		if (isSet(object.getMaximumNotionalAmount())) populatedFieldNames.add("maximumNotionalAmount");
		if (isSet(object.getMaximumNumberOfOptions())) populatedFieldNames.add("maximumNumberOfOptions");
		
		ChoiceRuleValidationMethod validationMethod = ChoiceRuleValidationMethod.REQUIRED;
		
		if (validationMethod.check(populatedFieldNames.size())) {
			return success(NAME, ValidationType.CHOICE_RULE, "MultipleExercise", path, "");
		}
		return new ValidationResult.ChoiceRuleFailure<MultipleExercise>(NAME, "MultipleExercise", choiceFieldNames, path, populatedFieldNames, validationMethod);
	}
}
