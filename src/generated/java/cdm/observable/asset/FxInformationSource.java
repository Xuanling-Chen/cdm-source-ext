package cdm.observable.asset;

import cdm.base.datetime.BusinessCenterTime;
import cdm.observable.asset.InformationSource.InformationSourceBuilder;
import cdm.observable.asset.InformationSource.InformationSourceBuilderImpl;
import cdm.observable.asset.InformationSource.InformationSourceImpl;
import cdm.observable.asset.meta.FxInformationSourceMeta;
import cdm.observable.asset.metafields.FieldWithMetaInformationProviderEnum;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.metafields.FieldWithMetaString;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Information source specific to Foreign Exchange products.
 * @version ${project.version}
 */
@RosettaClass

public interface FxInformationSource extends InformationSource {
	FxInformationSource build();
	FxInformationSource.FxInformationSourceBuilder toBuilder();
	
	/**
	 * The time that the fixing will be taken along with a business center to define the time zone.
	 */
	BusinessCenterTime getFixingTime();
	final static FxInformationSourceMeta metaData = new FxInformationSourceMeta();
	
	@Override
	default RosettaMetaData<? extends FxInformationSource> metaData() {
		return metaData;
	} 
			
	static FxInformationSource.FxInformationSourceBuilder builder() {
		return new FxInformationSource.FxInformationSourceBuilderImpl();
	}
	
	default Class<? extends FxInformationSource> getType() {
		return FxInformationSource.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.observable.asset.InformationSource.super.process(path, processor);
		
		processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.class, getFixingTime());
	}
	
	
	interface FxInformationSourceBuilder extends FxInformationSource, InformationSource.InformationSourceBuilder, RosettaModelObjectBuilder {
		BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime();
		BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime();
		FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime fixingTime);
		FxInformationSource.FxInformationSourceBuilder setSourcePage(FieldWithMetaString sourcePage);
		FxInformationSource.FxInformationSourceBuilder setSourcePageValue(String sourcePage);
		FxInformationSource.FxInformationSourceBuilder setSourcePageHeading(String sourcePageHeading);
		FxInformationSource.FxInformationSourceBuilder setSourceProvider(FieldWithMetaInformationProviderEnum sourceProvider);
		FxInformationSource.FxInformationSourceBuilder setSourceProviderValue(InformationProviderEnum sourceProvider);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			InformationSource.InformationSourceBuilder.super.process(path, processor);
			
			
			processRosetta(path.newSubPath("fixingTime"), processor, BusinessCenterTime.BusinessCenterTimeBuilder.class, getFixingTime());
		}
		
	}
	
	//FxInformationSource.FxInformationSourceImpl
	class FxInformationSourceImpl extends InformationSource.InformationSourceImpl implements FxInformationSource {
		private final BusinessCenterTime fixingTime;
		
		protected FxInformationSourceImpl(FxInformationSource.FxInformationSourceBuilder builder) {
			super(builder);
			this.fixingTime = ofNullable(builder.getFixingTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public BusinessCenterTime getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public FxInformationSource build() {
			return this;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			FxInformationSource.FxInformationSourceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxInformationSource.FxInformationSourceBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getFixingTime()).ifPresent(builder::setFixingTime);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSource {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}
	
	//FxInformationSource.FxInformationSourceBuilderImpl
	class FxInformationSourceBuilderImpl extends InformationSource.InformationSourceBuilderImpl  implements FxInformationSource.FxInformationSourceBuilder {
	
		protected BusinessCenterTime.BusinessCenterTimeBuilder fixingTime;
	
		public FxInformationSourceBuilderImpl() {
		}
	
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getFixingTime() {
			return fixingTime;
		}
		
		@Override
		public BusinessCenterTime.BusinessCenterTimeBuilder getOrCreateFixingTime() {
			BusinessCenterTime.BusinessCenterTimeBuilder result;
			if (fixingTime!=null) {
				result = fixingTime;
			}
			else {
				result = fixingTime = BusinessCenterTime.builder();
			}
			
			return result;
		}
		
	
		@Override
		public FxInformationSource.FxInformationSourceBuilder setFixingTime(BusinessCenterTime fixingTime) {
			this.fixingTime = fixingTime==null?null:fixingTime.toBuilder();
			return this;
		}
		@Override
		public FxInformationSource.FxInformationSourceBuilder setSourcePage(FieldWithMetaString sourcePage) {
			this.sourcePage = sourcePage==null?null:sourcePage.toBuilder();
			return this;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder setSourcePageValue(String sourcePage) {
			this.getOrCreateSourcePage().setValue(sourcePage);
			return this;
		}
		@Override
		public FxInformationSource.FxInformationSourceBuilder setSourcePageHeading(String sourcePageHeading) {
			this.sourcePageHeading = sourcePageHeading==null?null:sourcePageHeading;
			return this;
		}
		@Override
		public FxInformationSource.FxInformationSourceBuilder setSourceProvider(FieldWithMetaInformationProviderEnum sourceProvider) {
			this.sourceProvider = sourceProvider==null?null:sourceProvider.toBuilder();
			return this;
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder setSourceProviderValue(InformationProviderEnum sourceProvider) {
			this.getOrCreateSourceProvider().setValue(sourceProvider);
			return this;
		}
		
		@Override
		public FxInformationSource build() {
			return new FxInformationSource.FxInformationSourceImpl(this);
		}
		
		@Override
		public FxInformationSource.FxInformationSourceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder prune() {
			super.prune();
			if (fixingTime!=null && !fixingTime.prune().hasData()) fixingTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getFixingTime()!=null && getFixingTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxInformationSource.FxInformationSourceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			FxInformationSource.FxInformationSourceBuilder o = (FxInformationSource.FxInformationSourceBuilder) other;
			
			merger.mergeRosetta(getFixingTime(), o.getFixingTime(), this::setFixingTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			FxInformationSource _that = getType().cast(o);
		
			if (!Objects.equals(fixingTime, _that.getFixingTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (fixingTime != null ? fixingTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxInformationSourceBuilder {" +
				"fixingTime=" + this.fixingTime +
			'}' + " " + super.toString();
		}
	}
}
