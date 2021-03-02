google.charts.load('current', {packages: ['corechart', 'bar']});
google.charts.setOnLoadCallback(drawMonthWiseSalesTimeChart);


var sales2 = new Array();
var years2 = new Array();
var months2 = new Array();

var count2 = 0;


function drawMonthWiseSalesTimeChart() 
{
  // Create the data table for Sarah's pizza.
  var i;
  
  var arr = [];
  
//  var Obj = {Year: null, Sales: null}
//  
//  Obj.Year = 'Years';
//  Obj.Sales = 'Sales';
  
  arr.push(["Months","Total Sales In 2016","Total Sales In 2017","Total Sales In 2018"]);
  
  var flag = 0;
  
  var str = "";
  
  for(i = 0; i < count2; i++)
  {
//	  var Obj = {Year: null, Sales: null}
//	  Obj.Year = years1[i]+"";
//	  Obj.Sales = sales1[i];
//	  arr.push(Obj);
	  if(months2[i] == 1)
		  str = "January";
	  else if(months2[i] == 2)
		  str = "February";
	  else if(months2[i] == 3)
		  str = "March";
	  else if(months2[i] == 4)
		  str = "April";
	  else if(months2[i] == 5)
		  str = "May";
	  else if(months2[i] == 6)
		  str = "June";
	  else if(months2[i] == 7)
		  str = "July";
	  else if(months2[i] == 8)
		  str = "August";
	  else if(months2[i] == 9)
		  str = "September";
	  else if(months2[i] == 10)
		  str = "October";
	  else if(months2[i] == 11)
		  str = "November";
	  else
		  str = "December";
	  flag = flag+1;
	  
	  if(flag%3 == 0)
		  arr.push([str, sales2[flag-3], sales2[flag-2], sales2[flag-1]]);
  }
  
  console.table(arr);
  var data = new google.visualization.arrayToDataTable(arr);

  var options = {title:'Month-wise Trend in Sales',
		  chartArea: {width: '50%'},
	        hAxis: {
	          title: 'Sales',
	          minValue: 0
	        },
	        vAxis: {
	          title: 'Month'
	        },
	        height: 600
  };

  // Instantiate and draw the chart for Sarah's pizza.
  var chart = new google.visualization.BarChart(document.getElementById('TotalSalesMonthwiseTime_chart_div'));
  chart.draw(data, options);
}