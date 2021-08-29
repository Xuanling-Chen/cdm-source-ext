package cdm.base.staticdata.identifier.meta;

import cdm.base.staticdata.identifier.Identifier;
import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

/**
 * @version ${project.version}
 */
@RosettaMeta(model=Identifier.class)
public class IdentifierMeta implements RosettaMetaData<Identifier> {

	@Override
	public List<Validator<? super Identifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super Identifier>> choiceRuleValidators() {
		return Arrays.asList(
			new cdm.base.staticdata.identifier.validation.choicerule.IdentifierIssuerChoice()
		);
	}
	
	@Override
	public List<Function<? super Identifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super Identifier> validator() {
		return new cdm.base.staticdata.identifier.validation.IdentifierValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Identifier, Set<String>> onlyExistsValidator() {
		return new cdm.base.staticdata.identifier.validation.exists.IdentifierOnlyExistsValidator();
	}
}
