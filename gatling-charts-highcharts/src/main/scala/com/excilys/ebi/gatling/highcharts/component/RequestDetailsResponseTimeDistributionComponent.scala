/**
 * Copyright 2011-2012 eBusiness Information, Groupe Excilys (www.excilys.com)
 *
 * Licensed under the Gatling Highcharts License
 */
package com.excilys.ebi.gatling.highcharts.component

import com.excilys.ebi.gatling.charts.component.Component
import com.excilys.ebi.gatling.charts.series.Series
import com.excilys.ebi.gatling.highcharts.series.StackedColumnSeries
import com.excilys.ebi.gatling.highcharts.template.RequestDetailsResponseTimeTemplate
import com.excilys.ebi.gatling.highcharts.template.RequestDetailsResponseTimeDistributionTemplate

class RequestDetailsResponseTimeDistributionComponent(successDistribution: Series[Long, Int], failuresDistribution: Series[Long, Int])
	extends HighchartsComponent(
		new RequestDetailsResponseTimeDistributionTemplate(
			"Response time distribution",
			new StackedColumnSeries(successDistribution.name, successDistribution.data.map{case (time, count) => (time.toString -> count)}, successDistribution.colors.head),
			new StackedColumnSeries(failuresDistribution.name, failuresDistribution.data.map{case (time, count) => (time.toString -> count)}, failuresDistribution.colors.head)))