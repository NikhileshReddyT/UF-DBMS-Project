google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawCategorywiseSalesChart);

var sales3 = new Array();
var Category3 = new Array();

var count3 = 0;


// Callback that draws the pie chart for Sarah's pizza.
function drawCategorywiseSalesChart() 
{
  // Create the data table for Sarah's pizza.
  var i;
  
  var arr = [];
  
  arr.push(["Product Categories","Sales"]);
  
  for(i = 0; i < count3; i++)
  {
	  arr.push([Category3[i] , sales3[i]]);
  }
  
  console.table(arr);
  var data = new google.visualization.arrayToDataTable(arr);

  var options = {title:'Category-wise Trend in Sales',
		  chartArea: {width: '50%'},
	        hAxis: {
	          title: 'Sales',
	          minValue: 0
	        },
	        vAxis: {
	          title: 'Product Categories'}, height: 600};

  // Instantiate and draw the chart for Sarah's pizza.
  var chart = new google.visualization.BarChart(document.getElementById('CategorywiseProductSales_chart_div1'));
  chart.draw(data, options);
}