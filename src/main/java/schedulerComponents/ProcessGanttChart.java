package schedulerComponents;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.data.category.IntervalCategoryDataset;  
import org.jfree.data.gantt.Task;  
import org.jfree.data.gantt.TaskSeries;  
import org.jfree.data.gantt.TaskSeriesCollection;  

public class ProcessGanttChart extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProcessGanttChart(String title) {  
		super(title);  
  
		// Create dataset  
		IntervalCategoryDataset dataset = getCategoryDataset();  
  
		// Create chart  
		JFreeChart chart = ChartFactory.createGanttChart(  
				"Gantt Chart Example", // Chart title  
				"Software Development Phases", // X-Axis Label  
				"Timeline", // Y-Axis Label  
				dataset);  
  
		ChartPanel panel = new ChartPanel(chart);  
		setContentPane(panel);  
   }  
	
	private IntervalCategoryDataset getCategoryDataset() {
		
		
		
		TaskSeriesCollection dataset = new TaskSeriesCollection();
		return dataset;
	}
}
