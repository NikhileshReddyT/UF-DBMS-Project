google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawYearWiseSalesTimeChart);

var sales1 = new Array();
var years1 = new Array();

var count1 = 0;


// Callback that draws the pie chart for Sarah's pizza.
function drawYearWiseSalesTimeChart() 
{
  // Create the data table for Sarah's pizza.
  var i;
  
  var arr = [];
  
  arr.push(["Years","Sales"]);
  
  for(i = 0; i < count1; i++)
  {
//	  var Obj = {Year: null, Sales: null}
//	  Obj.Year = years1[i]+"";
//	  Obj.Sales = sales1[i];
//	  arr.push(Obj);
	  arr.push([years1[i]+"" , sales1[i]]);
  }
  
  console.table(arr);
  var data = new google.visualization.arrayToDataTable(arr);

  var options = {title:'Year-wise Trend in Sales',
		  chartArea: {width: '50%'},
	        hAxis: {
	          title: 'Sales',
	          minValue: 0
	        },
	        vAxis: {
	          title: 'Year'
	        }
  };

  // Instantiate and draw the chart for Sarah's pizza.
  var chart = new google.visualization.BarChart(document.getElementById('TotalSalesYearwiseTime_chart_div'));
  chart.draw(data, options);
}