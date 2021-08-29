package cdm.legalagreement.csa.validation.datarule;

import cdm.legalagreement.csa.ExceptionEnum;
import cdm.legalagreement.csa.PledgeeRepresentativeRider;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;

/**
 * @version ${project.version}
 */
@RosettaDataRule("PledgeeRepresentativeRiderrepresentativeEventTerms")
public class PledgeeRepresentativeRiderrepresentativeEventTerms implements Validator<PledgeeRepresentativeRider> {
	
	private static final String NAME = "PledgeeRepresentativeRiderrepresentativeEventTerms";
	private static final String DEFINITION = "if representativeEvent = ExceptionEnum->Other then representativeEventTerms exists";
	
	
	@Override
	public ValidationResult<PledgeeRepresentativeRider> validate(RosettaPath path, PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		ComparisonResult result = executeDataRule(pledgeeRepresentativeRider);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "PledgeeRepresentativeRider", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "PledgeeRepresentativeRider", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		if (ruleIsApplicable(pledgeeRepresentativeRider).get()) {
			return evaluateThenExpression(pledgeeRepresentativeRider);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		try {
			return areEqual(MapperS.of(pledgeeRepresentativeRider).<ExceptionEnum>map("getRepresentativeEvent", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEvent()), MapperS.of(ExceptionEnum.OTHER), CardinalityOperator.All);
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(PledgeeRepresentativeRider pledgeeRepresentativeRider) {
		try {
			return exists(MapperS.of(pledgeeRepresentativeRider).<String>map("getRepresentativeEventTerms", _pledgeeRepresentativeRider -> _pledgeeRepresentativeRider.getRepresentativeEventTerms()));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}
