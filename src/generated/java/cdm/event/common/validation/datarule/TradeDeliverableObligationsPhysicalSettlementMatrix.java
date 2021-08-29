package cdm.event.common.validation.datarule;

import cdm.base.datetime.Period;
import cdm.base.staticdata.asset.credit.NotDomesticCurrency;
import cdm.base.staticdata.asset.credit.SpecifiedCurrency;
import cdm.event.common.ContractDetails;
import cdm.event.common.Trade;
import cdm.legalagreement.common.ContractualMatrix;
import cdm.legalagreement.common.DocumentationIdentification;
import cdm.legalagreement.common.MatrixTypeEnum;
import cdm.legalagreement.common.RelatedAgreement;
import cdm.legalagreement.common.metafields.FieldWithMetaMatrixTypeEnum;
import cdm.product.asset.CreditDefaultPayout;
import cdm.product.common.settlement.DeliverableObligations;
import cdm.product.common.settlement.PCDeliverableObligationCharac;
import cdm.product.common.settlement.PhysicalSettlementTerms;
import cdm.product.common.settlement.SettlementTerms;
import cdm.product.template.ContractualProduct;
import cdm.product.template.EconomicTerms;
import cdm.product.template.Payout;
import cdm.product.template.Product;
import cdm.product.template.TradableProduct;
import com.rosetta.model.lib.annotations.RosettaDataRule;
import com.rosetta.model.lib.expression.CardinalityOperator;
import com.rosetta.model.lib.expression.ComparisonResult;
import com.rosetta.model.lib.mapper.MapperS;
import com.rosetta.model.lib.mapper.MapperTree;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.validation.ModelObjectValidator;
import com.rosetta.model.lib.validation.ValidationResult;
import com.rosetta.model.lib.validation.Validator;

import static com.rosetta.model.lib.expression.ExpressionOperators.*;
import static com.rosetta.model.lib.expression.ExpressionOperators.notExists;

/**
 * @version ${project.version}
 */
@RosettaDataRule("TradeDeliverableObligationsPhysicalSettlementMatrix")
public class TradeDeliverableObligationsPhysicalSettlementMatrix implements Validator<Trade> {
	
	private static final String NAME = "TradeDeliverableObligationsPhysicalSettlementMatrix";
	private static final String DEFINITION = "if (contractDetails -> documentation -> documentationIdentification -> contractualMatrix -> matrixType all <> MatrixTypeEnum -> CreditDerivativesPhysicalSettlementMatrix or contractDetails -> documentation -> documentationIdentification -> contractualMatrix -> matrixType is absent) and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations exists then (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notSubordinated and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> specifiedCurrency and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notSovereignLender and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notDomesticCurrency and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notDomesticLaw and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notContingent and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notDomesticIssuance and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> assignableLoan and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> consentRequiredLoan and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> transferable and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> maximumMaturity and tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> notBearer ) exists and (tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> fullFaithAndCreditObLiability or tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> generalFundObligationLiability or tradableProduct -> product -> contractualProduct -> economicTerms -> payout -> creditDefaultPayout -> settlementTerms -> physicalSettlementTerms -> deliverableObligations -> revenueObligationLiability ) exists";
	
	
	@Override
	public ValidationResult<Trade> validate(RosettaPath path, Trade trade) {
		ComparisonResult result = executeDataRule(trade);
		if (result.get()) {
			return ValidationResult.success(NAME, ValidationResult.ValidationType.DATA_RULE,  "Trade", path, DEFINITION);
		}
		
		return ValidationResult.failure(NAME, ValidationResult.ValidationType.DATA_RULE, "Trade", path, DEFINITION, result.getError());
	}
	
	private ComparisonResult executeDataRule(Trade trade) {
		if (ruleIsApplicable(trade).get()) {
			return evaluateThenExpression(trade);
		}
		return ComparisonResult.success();
	}
	
	private ComparisonResult ruleIsApplicable(Trade trade) {
		try {
			return notEqual(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", _contractualMatrix -> _contractualMatrix.getMatrixType()).<MatrixTypeEnum>map("getValue", _f->_f.getValue()), MapperS.of(MatrixTypeEnum.CREDIT_DERIVATIVES_PHYSICAL_SETTLEMENT_MATRIX), CardinalityOperator.All).or(notExists(MapperS.of(trade).<ContractDetails>map("getContractDetails", _trade -> _trade.getContractDetails()).<RelatedAgreement>mapC("getDocumentation", _contractDetails -> _contractDetails.getDocumentation()).<DocumentationIdentification>map("getDocumentationIdentification", _relatedAgreement -> _relatedAgreement.getDocumentationIdentification()).<ContractualMatrix>mapC("getContractualMatrix", _documentationIdentification -> _documentationIdentification.getContractualMatrix()).<FieldWithMetaMatrixTypeEnum>map("getMatrixType", _contractualMatrix -> _contractualMatrix.getMatrixType()).<MatrixTypeEnum>map("getValue", _f->_f.getValue()))).and(exists(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations())));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
	
	private ComparisonResult evaluateThenExpression(Trade trade) {
		try {
			return exists(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.andDifferent(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotSubordinated", _deliverableObligations -> _deliverableObligations.getNotSubordinated())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<SpecifiedCurrency>map("getSpecifiedCurrency", _deliverableObligations -> _deliverableObligations.getSpecifiedCurrency()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotSovereignLender", _deliverableObligations -> _deliverableObligations.getNotSovereignLender()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<NotDomesticCurrency>map("getNotDomesticCurrency", _deliverableObligations -> _deliverableObligations.getNotDomesticCurrency()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotDomesticLaw", _deliverableObligations -> _deliverableObligations.getNotDomesticLaw()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotContingent", _deliverableObligations -> _deliverableObligations.getNotContingent()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotDomesticIssuance", _deliverableObligations -> _deliverableObligations.getNotDomesticIssuance()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<PCDeliverableObligationCharac>map("getAssignableLoan", _deliverableObligations -> _deliverableObligations.getAssignableLoan()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<PCDeliverableObligationCharac>map("getConsentRequiredLoan", _deliverableObligations -> _deliverableObligations.getConsentRequiredLoan()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getTransferable", _deliverableObligations -> _deliverableObligations.getTransferable()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Period>map("getMaximumMaturity", _deliverableObligations -> _deliverableObligations.getMaximumMaturity()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getNotBearer", _deliverableObligations -> _deliverableObligations.getNotBearer())))).and(exists(MapperTree.or(MapperTree.or(MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getFullFaithAndCreditObLiability", _deliverableObligations -> _deliverableObligations.getFullFaithAndCreditObLiability())), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getGeneralFundObligationLiability", _deliverableObligations -> _deliverableObligations.getGeneralFundObligationLiability()))), MapperTree.of(MapperS.of(trade).<TradableProduct>map("getTradableProduct", _trade -> _trade.getTradableProduct()).<Product>map("getProduct", _tradableProduct -> _tradableProduct.getProduct()).<ContractualProduct>map("getContractualProduct", _product -> _product.getContractualProduct()).<EconomicTerms>map("getEconomicTerms", _contractualProduct -> _contractualProduct.getEconomicTerms()).<Payout>map("getPayout", _economicTerms -> _economicTerms.getPayout()).<CreditDefaultPayout>map("getCreditDefaultPayout", _payout -> _payout.getCreditDefaultPayout()).<SettlementTerms>map("getSettlementTerms", _payoutBase -> _payoutBase.getSettlementTerms()).<PhysicalSettlementTerms>map("getPhysicalSettlementTerms", _settlementTerms -> _settlementTerms.getPhysicalSettlementTerms()).<DeliverableObligations>map("getDeliverableObligations", _physicalSettlementTerms -> _physicalSettlementTerms.getDeliverableObligations()).<Boolean>map("getRevenueObligationLiability", _deliverableObligations -> _deliverableObligations.getRevenueObligationLiability())))));
		}
		catch (ModelObjectValidator.ModelObjectValidationException ex) {
			return ComparisonResult.failure(ex.getErrors());
		}
	}
}