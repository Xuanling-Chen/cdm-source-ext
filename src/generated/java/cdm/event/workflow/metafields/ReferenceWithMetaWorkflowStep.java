package cdm.event.workflow.metafields;

import cdm.event.workflow.WorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilderImpl;
import cdm.event.workflow.metafields.ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepImpl;
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

public interface ReferenceWithMetaWorkflowStep extends RosettaModelObject, ReferenceWithMeta<WorkflowStep> {
	ReferenceWithMetaWorkflowStep build();
	ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder toBuilder();
	
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
	WorkflowStep getValue();
	final static ReferenceWithMetaWorkflowStepMeta metaData = new ReferenceWithMetaWorkflowStepMeta();
	
	@Override
	default RosettaMetaData<? extends ReferenceWithMetaWorkflowStep> metaData() {
		return metaData;
	} 
			
	static ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder builder() {
		return new ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilderImpl();
	}
	
	default Class<? extends ReferenceWithMetaWorkflowStep> getType() {
		return ReferenceWithMetaWorkflowStep.class;
	}
	
		default Class<WorkflowStep> getValueType() {
			return WorkflowStep.class;
		}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
		processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
		
		processRosetta(path.newSubPath("reference"), processor, Reference.class, getReference());
		processRosetta(path.newSubPath("value"), processor, WorkflowStep.class, getValue());
	}
	
	
	interface ReferenceWithMetaWorkflowStepBuilder extends ReferenceWithMetaWorkflowStep, RosettaModelObjectBuilder, ReferenceWithMetaBuilder<WorkflowStep> {
		Reference.ReferenceBuilder getOrCreateReference();
		Reference.ReferenceBuilder getReference();
		WorkflowStep.WorkflowStepBuilder getOrCreateValue();
		WorkflowStep.WorkflowStepBuilder getValue();
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setExternalReference(String externalReference);
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setGlobalReference(String globalReference);
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setReference(Reference reference);
		ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setValue(WorkflowStep value);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("externalReference"), String.class, getExternalReference(), this, AttributeMeta.META);
			processor.processBasic(path.newSubPath("globalReference"), String.class, getGlobalReference(), this, AttributeMeta.META);
			
			processRosetta(path.newSubPath("reference"), processor, Reference.ReferenceBuilder.class, getReference());
			processRosetta(path.newSubPath("value"), processor, WorkflowStep.WorkflowStepBuilder.class, getValue());
		}
		
	}
	
	//ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepImpl
	class ReferenceWithMetaWorkflowStepImpl implements ReferenceWithMetaWorkflowStep {
		private final String externalReference;
		private final String globalReference;
		private final Reference reference;
		private final WorkflowStep value;
		
		protected ReferenceWithMetaWorkflowStepImpl(ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder builder) {
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
		public WorkflowStep getValue() {
			return value;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep build() {
			return this;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder toBuilder() {
			ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder builder) {
			ofNullable(getExternalReference()).ifPresent(builder::setExternalReference);
			ofNullable(getGlobalReference()).ifPresent(builder::setGlobalReference);
			ofNullable(getReference()).ifPresent(builder::setReference);
			ofNullable(getValue()).ifPresent(builder::setValue);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ReferenceWithMetaWorkflowStep _that = getType().cast(o);
		
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
			return "ReferenceWithMetaWorkflowStep {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
	
	//ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilderImpl
	class ReferenceWithMetaWorkflowStepBuilderImpl implements ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder {
	
		protected String externalReference;
		protected String globalReference;
		protected Reference.ReferenceBuilder reference;
		protected WorkflowStep.WorkflowStepBuilder value;
	
		public ReferenceWithMetaWorkflowStepBuilderImpl() {
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
		public WorkflowStep.WorkflowStepBuilder getValue() {
			return value;
		}
		
		@Override
		public WorkflowStep.WorkflowStepBuilder getOrCreateValue() {
			WorkflowStep.WorkflowStepBuilder result;
			if (value!=null) {
				result = value;
			}
			else {
				result = value = WorkflowStep.builder();
			}
			
			return result;
		}
		
	
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setExternalReference(String externalReference) {
			this.externalReference = externalReference==null?null:externalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setGlobalReference(String globalReference) {
			this.globalReference = globalReference==null?null:globalReference;
			return this;
		}
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setReference(Reference reference) {
			this.reference = reference==null?null:reference.toBuilder();
			return this;
		}
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder setValue(WorkflowStep value) {
			this.value = value==null?null:value.toBuilder();
			return this;
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep build() {
			return new ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepImpl(this);
		}
		
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder prune() {
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
		public ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder o = (ReferenceWithMetaWorkflowStep.ReferenceWithMetaWorkflowStepBuilder) other;
			
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
		
			ReferenceWithMetaWorkflowStep _that = getType().cast(o);
		
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
			return "ReferenceWithMetaWorkflowStepBuilder {" +
				"externalReference=" + this.externalReference + ", " +
				"globalReference=" + this.globalReference + ", " +
				"reference=" + this.reference + ", " +
				"value=" + this.value +
			'}';
		}
	}
}

class ReferenceWithMetaWorkflowStepMeta extends BasicRosettaMetaData<ReferenceWithMetaWorkflowStep>{

}