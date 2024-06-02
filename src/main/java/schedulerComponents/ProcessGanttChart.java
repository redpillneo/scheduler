package schedulerComponents;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.IntervalCategoryDataset;  
import org.jfree.data.gantt.Task;  
import org.jfree.data.gantt.TaskSeries;  
import org.jfree.data.gantt.TaskSeriesCollection;  

public class ProcessGanttChart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFreeChart chart;
	private ChartPanel panel;
	
	public ProcessGanttChart() {  
		// Create dataset  
		IntervalCategoryDataset dataset = getCategoryDataset();
		// Create chart  
		chart = ChartFactory.createGanttChart(  
				"Process Schedule", // Chart title  
				"Processes", // X-Axis Label  
				"Time", // Y-Axis Label  
				dataset
				);  
  
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setOrientation(PlotOrientation.HORIZONTAL);
        GanttRenderer renderer = new GanttRenderer();
        plot.setRenderer(renderer);
        
        panel = new ChartPanel(chart);  
		setContentPane(panel);
   }  
	
	private IntervalCategoryDataset getCategoryDataset() {
		TaskSeries series = new TaskSeries("Scheduled Processes");
		
		//TODO Get processlist to place into the taskseries
		System.out.println(processConfig.processes.size());
		
		//Add the processes
		series.add(new Task("Process 1", new Date(124, 5, 31, 0, 0), new Date(124, 5, 31, 0, 10)));
        series.add(new Task("Process 2", new Date(124, 5, 31, 0, 15), new Date(124, 5, 31, 0, 25)));
        series.add(new Task("Process 3", new Date(124, 5, 31, 0, 30), new Date(124, 5, 31, 0, 80)));
		
		TaskSeriesCollection dataset = new TaskSeriesCollection();
		dataset.add(series);
		return dataset;
	}
	
	public ChartPanel getChartPanel() {
		return panel;
	}
	
	public void setSize(int width, int height) {
		panel.setPreferredSize(new Dimension(width, height));
	}
}
