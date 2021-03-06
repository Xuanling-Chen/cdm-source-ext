package cdm.regulation;

import cdm.regulation.meta.NmMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface Nm extends RosettaModelObject {
	Nm build();
	Nm.NmBuilder toBuilder();
	
	/**
	 */
	RefRate getRefRate();
	/**
	 */
	Term getTerm();
	final static NmMeta metaData = new NmMeta();
	
	@Override
	default RosettaMetaData<? extends Nm> metaData() {
		return metaData;
	} 
			
	static Nm.NmBuilder builder() {
		return new Nm.NmBuilderImpl();
	}
	
	default Class<? extends Nm> getType() {
		return Nm.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("refRate"), processor, RefRate.class, getRefRate());
		processRosetta(path.newSubPath("term"), processor, Term.class, getTerm());
	}
	
	
	interface NmBuilder extends Nm, RosettaModelObjectBuilder {
		RefRate.RefRateBuilder getOrCreateRefRate();
		RefRate.RefRateBuilder getRefRate();
		Term.TermBuilder getOrCreateTerm();
		Term.TermBuilder getTerm();
		Nm.NmBuilder setRefRate(RefRate refRate);
		Nm.NmBuilder setTerm(Term term);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("refRate"), processor, RefRate.RefRateBuilder.class, getRefRate());
			processRosetta(path.newSubPath("term"), processor, Term.TermBuilder.class, getTerm());
		}
		
	}
	
	//Nm.NmImpl
	class NmImpl implements Nm {
		private final RefRate refRate;
		private final Term term;
		
		protected NmImpl(Nm.NmBuilder builder) {
			this.refRate = ofNullable(builder.getRefRate()).map(f->f.build()).orElse(null);
			this.term = ofNullable(builder.getTerm()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public RefRate getRefRate() {
			return refRate;
		}
		
		@Override
		public Term getTerm() {
			return term;
		}
		
		@Override
		public Nm build() {
			return this;
		}
		
		@Override
		public Nm.NmBuilder toBuilder() {
			Nm.NmBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Nm.NmBuilder builder) {
			ofNullable(getRefRate()).ifPresent(builder::setRefRate);
			ofNullable(getTerm()).ifPresent(builder::setTerm);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Nm _that = getType().cast(o);
		
			if (!Objects.equals(refRate, _that.getRefRate())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (refRate != null ? refRate.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Nm {" +
				"refRate=" + this.refRate + ", " +
				"term=" + this.term +
			'}';
		}
	}
	
	//Nm.NmBuilderImpl
	class NmBuilderImpl implements Nm.NmBuilder {
	
		protected RefRate.RefRateBuilder refRate;
		protected Term.TermBuilder term;
	
		public NmBuilderImpl() {
		}
	
		@Override
		public RefRate.RefRateBuilder getRefRate() {
			return refRate;
		}
		
		@Override
		public RefRate.RefRateBuilder getOrCreateRefRate() {
			RefRate.RefRateBuilder result;
			if (refRate!=null) {
				result = refRate;
			}
			else {
				result = refRate = RefRate.builder();
			}
			
			return result;
		}
		
		@Override
		public Term.TermBuilder getTerm() {
			return term;
		}
		
		@Override
		public Term.TermBuilder getOrCreateTerm() {
			Term.TermBuilder result;
			if (term!=null) {
				result = term;
			}
			else {
				result = term = Term.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Nm.NmBuilder setRefRate(RefRate refRate) {
			this.refRate = refRate==null?null:refRate.toBuilder();
			return this;
		}
		@Override
		public Nm.NmBuilder setTerm(Term term) {
			this.term = term==null?null:term.toBuilder();
			return this;
		}
		
		@Override
		public Nm build() {
			return new Nm.NmImpl(this);
		}
		
		@Override
		public Nm.NmBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Nm.NmBuilder prune() {
			if (refRate!=null && !refRate.prune().hasData()) refRate = null;
			if (term!=null && !term.prune().hasData()) term = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getRefRate()!=null && getRefRate().hasData()) return true;
			if (getTerm()!=null && getTerm().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Nm.NmBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Nm.NmBuilder o = (Nm.NmBuilder) other;
			
			merger.mergeRosetta(getRefRate(), o.getRefRate(), this::setRefRate);
			merger.mergeRosetta(getTerm(), o.getTerm(), this::setTerm);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Nm _that = getType().cast(o);
		
			if (!Objects.equals(refRate, _that.getRefRate())) return false;
			if (!Objects.equals(term, _that.getTerm())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (refRate != null ? refRate.hashCode() : 0);
			_result = 31 * _result + (term != null ? term.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NmBuilder {" +
				"refRate=" + this.refRate + ", " +
				"term=" + this.term +
			'}';
		}
	}
}
