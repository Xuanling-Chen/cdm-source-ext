package cdm.product.template;

import cdm.product.template.meta.DurationMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies the Duration Terms of the Security Financing Transaction, and optionally any Evergreen terms.
 * @version ${project.version}
 */
@RosettaClass

public interface Duration extends RosettaModelObject {
	Duration build();
	Duration.DurationBuilder toBuilder();
	
	/**
	 * Specifies the Duration Terms of the Security Financing transaction. e.g. Open or Term.
	 */
	DurationTypeEnum getDurationType();
	/**
	 * A data defining: the right of a party to exercise an Evergreen option
	 */
	EvergreenProvision getEvergreenProvision();
	final static DurationMeta metaData = new DurationMeta();
	
	@Override
	default RosettaMetaData<? extends Duration> metaData() {
		return metaData;
	} 
			
	static Duration.DurationBuilder builder() {
		return new Duration.DurationBuilderImpl();
	}
	
	default Class<? extends Duration> getType() {
		return Duration.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("durationType"), DurationTypeEnum.class, getDurationType(), this);
		
		processRosetta(path.newSubPath("evergreenProvision"), processor, EvergreenProvision.class, getEvergreenProvision());
	}
	
	
	interface DurationBuilder extends Duration, RosettaModelObjectBuilder {
		EvergreenProvision.EvergreenProvisionBuilder getOrCreateEvergreenProvision();
		EvergreenProvision.EvergreenProvisionBuilder getEvergreenProvision();
		Duration.DurationBuilder setDurationType(DurationTypeEnum durationType);
		Duration.DurationBuilder setEvergreenProvision(EvergreenProvision evergreenProvision);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("durationType"), DurationTypeEnum.class, getDurationType(), this);
			
			processRosetta(path.newSubPath("evergreenProvision"), processor, EvergreenProvision.EvergreenProvisionBuilder.class, getEvergreenProvision());
		}
		
	}
	
	//Duration.DurationImpl
	class DurationImpl implements Duration {
		private final DurationTypeEnum durationType;
		private final EvergreenProvision evergreenProvision;
		
		protected DurationImpl(Duration.DurationBuilder builder) {
			this.durationType = builder.getDurationType();
			this.evergreenProvision = ofNullable(builder.getEvergreenProvision()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public DurationTypeEnum getDurationType() {
			return durationType;
		}
		
		@Override
		public EvergreenProvision getEvergreenProvision() {
			return evergreenProvision;
		}
		
		@Override
		public Duration build() {
			return this;
		}
		
		@Override
		public Duration.DurationBuilder toBuilder() {
			Duration.DurationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Duration.DurationBuilder builder) {
			ofNullable(getDurationType()).ifPresent(builder::setDurationType);
			ofNullable(getEvergreenProvision()).ifPresent(builder::setEvergreenProvision);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Duration _that = getType().cast(o);
		
			if (!Objects.equals(durationType, _that.getDurationType())) return false;
			if (!Objects.equals(evergreenProvision, _that.getEvergreenProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (durationType != null ? durationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (evergreenProvision != null ? evergreenProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Duration {" +
				"durationType=" + this.durationType + ", " +
				"evergreenProvision=" + this.evergreenProvision +
			'}';
		}
	}
	
	//Duration.DurationBuilderImpl
	class DurationBuilderImpl implements Duration.DurationBuilder {
	
		protected DurationTypeEnum durationType;
		protected EvergreenProvision.EvergreenProvisionBuilder evergreenProvision;
	
		public DurationBuilderImpl() {
		}
	
		@Override
		public DurationTypeEnum getDurationType() {
			return durationType;
		}
		
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder getEvergreenProvision() {
			return evergreenProvision;
		}
		
		@Override
		public EvergreenProvision.EvergreenProvisionBuilder getOrCreateEvergreenProvision() {
			EvergreenProvision.EvergreenProvisionBuilder result;
			if (evergreenProvision!=null) {
				result = evergreenProvision;
			}
			else {
				result = evergreenProvision = EvergreenProvision.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Duration.DurationBuilder setDurationType(DurationTypeEnum durationType) {
			this.durationType = durationType==null?null:durationType;
			return this;
		}
		@Override
		public Duration.DurationBuilder setEvergreenProvision(EvergreenProvision evergreenProvision) {
			this.evergreenProvision = evergreenProvision==null?null:evergreenProvision.toBuilder();
			return this;
		}
		
		@Override
		public Duration build() {
			return new Duration.DurationImpl(this);
		}
		
		@Override
		public Duration.DurationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Duration.DurationBuilder prune() {
			if (evergreenProvision!=null && !evergreenProvision.prune().hasData()) evergreenProvision = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDurationType()!=null) return true;
			if (getEvergreenProvision()!=null && getEvergreenProvision().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Duration.DurationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Duration.DurationBuilder o = (Duration.DurationBuilder) other;
			
			merger.mergeRosetta(getEvergreenProvision(), o.getEvergreenProvision(), this::setEvergreenProvision);
			
			merger.mergeBasic(getDurationType(), o.getDurationType(), this::setDurationType);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Duration _that = getType().cast(o);
		
			if (!Objects.equals(durationType, _that.getDurationType())) return false;
			if (!Objects.equals(evergreenProvision, _that.getEvergreenProvision())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (durationType != null ? durationType.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (evergreenProvision != null ? evergreenProvision.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DurationBuilder {" +
				"durationType=" + this.durationType + ", " +
				"evergreenProvision=" + this.evergreenProvision +
			'}';
		}
	}
}
