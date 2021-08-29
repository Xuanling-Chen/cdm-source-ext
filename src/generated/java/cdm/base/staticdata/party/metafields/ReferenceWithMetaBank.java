package cdm.base.staticdata.party.metafields;

import cdm.base.staticdata.party.Bank;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank.ReferenceWithMetaBankBuilder;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank.ReferenceWithMetaBankBuilderImpl;
import cdm.base.staticdata.party.metafields.ReferenceWithMetaBank.ReferenceWithMetaBankImpl;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.BasicRosettaMetaData;
import com.rosetta.model.lib.meta.Reference;
import com.rosetta.model.lib.meta.ReferenceWithMeta;
import com.rosetta.model.lib.meta.ReferenceWithMeta.ReferenceWithMetaBuilder;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.AttributeMeta;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;
import static java.util.Optional.ofNullable;

/**
 * @version 1
 */
@RosettaClass

public interface ReferenceWithMetaBank extends RosettaModelObject, ReferenceWithMeta<Bank> {
	ReferenceWithMetaBank build();
	ReferenceWithMetaBank.ReferenceWithMetaBankBuilder toBuilder();
	
	/**
	 */
	String getExternalReference();
	/**
	 */
	String getGlobalReference();
	/**
	 */
	Reference getReference();
	/**
	 */
	Bank getValue();
	final static ReferenceWithMetaBankMeta metaData = new ReferenceWithMetaBankMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaBank> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaBank.ReferenceWithMetaBankBuilder builder() {
		return new ReferenceWithMetaBank.ReferenceWithMetaBankBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaBank> getType() {
		return ReferenceWithMetaBank.class;
	}
	
		default Class<Bank> getValueType() {
			return Bank.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, Bank.class, getValue());
	}
	
	
	interface ReferenceWithMetaBankBuilder extends ReferenceWithMetaBank, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<Bank> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		Bank.BankBuilder getOrCreateValue();
		Bank.BankBuilder getValue();
		ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setExternalReference(String externalReference);
		ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setReference(Reference reference);
		ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setValue(Bank value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, Bank.BankBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaBank.ReferenceWithMetaBankImpl
	class ReferenceWithMetaBankImpl implements ReferenceWithMetaBank {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final Bank value;
		
		protected ReferenceWithMetaBankImpl(ReferenceWithMetaBank.ReferenceWithMetaBankBuilder builder) {
			this.externalReference = builder.getExternalReference();
			this.globalReference = builder.getGlobalReference();
			this.reference = ofNullable(builder.getReference()).map(f->f.build()).orElse(null);
			this.value = ofNullable(builder.getValue()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference getReference() {
			return reference;
		}
		
		@Override
		public Bank getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaBank build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder toBuilder() {
			ReferenceWithMetaBank.ReferenceWithMetaBankBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaBank.ReferenceWithMetaBankBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaBank _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaBank {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaBank.ReferenceWithMetaBankBuilderImpl
	class ReferenceWithMetaBankBuilderImpl implements ReferenceWithMetaBank.ReferenceWithMetaBankBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected Bank.BankBuilder value;
	
		public ReferenceWithMetaBankBuilderImpl() {
		}
	
		@Override
		public String getExternalReference() {
			return externalReference;
		}
		
		@Override
		public String getGlobalReference() {
			return globalReference;
		}
		
		@Override
		public Reference.ReferenceBuilder getReference() {
			return reference;
		}
		
		@Override
		public Reference.ReferenceBuilder getOrCreateReference() {
			Reference.ReferenceBuilder result;
			if (reference!=null) {
				result = reference;
			}
			else {
				result = reference = Reference.builder();
			}
			
			return result;
		}
		
		@Override
		public Bank.BankBuilder getValue() {
			return value;
		}
		
		@Override
		public Bank.BankBuilder getOrCreateValue() {
			Bank.BankBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = Bank.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder setValue(Bank value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaBank build() {
			return new ReferenceWithMetaBank.ReferenceWithMetaBankImpl(this);
		}
		
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder prune() {
			if (reference!=null && !reference.prune().hasData()) reference = null;
			if (value!=null && !value.prune().hasData()) value = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getExternalReference()!=null) return true;
			if (getGlobalReference()!=null) return true;
			if (getReference()!=null && getReference().hasData()) return true;
			if (getValue()!=null && getValue().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaBank.ReferenceWithMetaBankBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaBank.ReferenceWithMetaBankBuilder o = (ReferenceWithMetaBank.ReferenceWithMetaBankBuilder) other;
			
			merger.mergeRosetta(getReference(), o.getReference(), this::setReference);
			merger.mergeRosetta(getValue(), o.getValue(), this::setValue);
			
			merger.mergeBasic(getExternalReference(), o.getExternalReference(), this::setExternalReference);
			merger.mergeBasic(getGlobalReference(), o.getGlobalReference(), this::setGlobalReference);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaBank _that = getType().cast(o);
		
			if (!Objects.equals(externalReference, _that.getExternalReference())) return false;
			if (!Objects.equals(globalReference, _that.getGlobalReference())) return false;
			if (!Objects.equals(reference, _that.getReference())) return false;
			if (!Objects.equals(value, _that.getValue())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (externalReference != null ? externalReference.hashCode() : 0);
			_result = 31 * _result + (globalReference != null ? globalReference.hashCode() : 0);
			_result = 31 * _result + (reference != null ? reference.hashCode() : 0);
			_result = 31 * _result + (value != null ? value.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ReferenceWithMetaBankBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaBankMeta extends BasicRosettaMetaData<ReferenceWithMetaBank>{

}
