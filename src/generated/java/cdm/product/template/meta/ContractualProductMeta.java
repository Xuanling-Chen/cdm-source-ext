package cdm.product.template.meta;

import cdm.product.template.ContractualProduct;
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
@RosettaMeta(model=ContractualProduct.class)
public class ContractualProductMeta implements RosettaMetaData<ContractualProduct> {

	@Override
	public List<Validator<? super ContractualProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}

	@Override
	public List<Validator<? super ContractualProduct>> choiceRuleValidators() {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ContractualProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}
	
	@Override
	public Validator<? super ContractualProduct> validator() {
		return new cdm.product.template.validation.ContractualProductValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ContractualProduct, Set<String>> onlyExistsValidator() {
		return new cdm.product.template.validation.exists.ContractualProductOnlyExistsValidator();
	}
}
