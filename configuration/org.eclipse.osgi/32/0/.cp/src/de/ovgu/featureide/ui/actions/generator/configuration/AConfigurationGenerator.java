/* FeatureIDE - A Framework for Feature-Oriented Software Development
 * Copyright (C) 2005-2019  FeatureIDE team, University of Magdeburg, Germany
 *
 * This file is part of FeatureIDE.
 *
 * FeatureIDE is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * FeatureIDE is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with FeatureIDE.  If not, see <http://www.gnu.org/licenses/>.
 *
 * See http://featureide.cs.ovgu.de/ for further information.
 */
package de.ovgu.featureide.ui.actions.generator.configuration;

import java.util.List;

import de.ovgu.featureide.fm.core.analysis.cnf.LiteralSet;
import de.ovgu.featureide.fm.core.analysis.cnf.formula.FeatureModelFormula;
import de.ovgu.featureide.fm.core.configuration.Configuration;
import de.ovgu.featureide.fm.core.job.LongRunningMethod;
import de.ovgu.featureide.ui.actions.generator.BuilderConfiguration;
import de.ovgu.featureide.ui.actions.generator.ConfigurationBuilder;

/**
 * Abstract class to generate configurations.
 *
 * @author Jens Meinicke
 * @author Sebastian Krieter
 */
public abstract class AConfigurationGenerator implements LongRunningMethod<List<LiteralSet>> {

	protected final FeatureModelFormula snapshot;

	protected final ConfigurationBuilder builder;

	/**
	 * The count of found configurations.
	 */
	protected long confs = 0;

	public AConfigurationGenerator(ConfigurationBuilder builder, FeatureModelFormula formula) {
		this.builder = builder;
		snapshot = formula;
	}

	protected void cancelGenerationJobs() {
		builder.cancelGenerationJobs();
	}

	protected final void setConfigurationNumber(int foundConfigurations) {
		builder.configurationNumber = foundConfigurations;
	}

	protected final void addConfiguration(Configuration configuration) {
		builder.addConfiguration(new BuilderConfiguration(configuration, ++confs));
	}

}
